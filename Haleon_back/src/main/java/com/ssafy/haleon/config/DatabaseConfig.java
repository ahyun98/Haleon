package com.ssafy.haleon.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.haleon.model.dao")
public class DatabaseConfig {}