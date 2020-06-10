package me.lokka.ssmcrud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("me.lokka.ssmcrud.dao")
public class MybatisConfig {
}
