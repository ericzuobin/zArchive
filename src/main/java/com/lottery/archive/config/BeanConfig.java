package com.lottery.archive.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * @author Sahinn
 * @date 16/6/16
 */
@Configuration
@ComponentScan(basePackages = "com.lottery.archive", excludeFilters = @ComponentScan.Filter(Controller.class))
public class BeanConfig {
}
