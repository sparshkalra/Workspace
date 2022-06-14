package com.interview.practice.demopractice.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	 @Bean
	    public DataSource getDataSource() {
	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("org.mariadb.jdbc.Driver");
	        dataSourceBuilder.url("jdbc:mariadb://localhost:3316/demopractice");
	        dataSourceBuilder.username("root");
	        dataSourceBuilder.password("root");
	        return dataSourceBuilder.build();
	    }
	
}
