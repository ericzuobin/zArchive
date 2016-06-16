package com.lottery.archive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Sahinn
 * @date 16/6/16
 */
@Configuration
@Import({BeanConfig.class, JPASourceConfig.class, JPASourceConfig.class})
public class InitConfig {
}
