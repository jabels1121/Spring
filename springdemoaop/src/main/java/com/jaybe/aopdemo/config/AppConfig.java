package com.jaybe.aopdemo.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.jaybe.aopdemo.service", "com.jaybe.aopdemo.DAO", "com.jaybe.aopdemo.aspect"})
public class AppConfig {
}
