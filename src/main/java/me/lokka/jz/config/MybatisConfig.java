package me.lokka.jz.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("me.lokka.jz.dao")
public class MybatisConfig {

}
