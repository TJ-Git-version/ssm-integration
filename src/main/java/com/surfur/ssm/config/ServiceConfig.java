package com.surfur.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(value = {"com.surfur.ssm.service", "com.surfur.ssm.pointcut"})
@EnableAspectJAutoProxy
@EnableTransactionManagement
@PropertySource(value = "classpath:mysql/jdbc.properties")
public class ServiceConfig {

    // 配置druid数据源信息

    // 方式一：
    // @Bean
    // public DataSource dataSource() {
    //     try {
    //         Properties properties = new Properties();
    //         properties.load(new ClassPathResource("mysql/jdbc.properties").getInputStream());
    //         return DruidDataSourceFactory.createDataSource(properties);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         throw new RuntimeException(e);
    //     }
    // }

    /**
     * 方式二：
     *    使用@PropertySource(value = "classpath:mysql/jdbc.properties")：引入外部配置文件
     */
    @Bean
    public DataSource dataSource(@Value("${driver}") String driver,
                                 @Value("${url}") String url,
                                 @Value("${username}") String username,
                                 @Value("${password}") String password
                                 ) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    // 配置声明式事务
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
