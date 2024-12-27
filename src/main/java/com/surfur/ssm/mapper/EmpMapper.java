package com.surfur.ssm.mapper;

import com.surfur.ssm.domain.EmpEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author key point
* description 针对表【emp(员工表)】的数据库操作Mapper
* createDate 2024-12-26 23:06:55
* Entity com.surfur.ssm.domain.EmpEntity
*/
@Repository
@Mapper
public interface EmpMapper {

    EmpEntity findEmpById(Integer id);

}
