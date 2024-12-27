package com.surfur.ssm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ServiceConfig.class, MapperConfig.class, MvcConfig.class})
public class AopConfig {
}
