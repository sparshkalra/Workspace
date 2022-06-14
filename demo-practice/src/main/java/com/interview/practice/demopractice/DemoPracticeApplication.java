package com.interview.practice.demopractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DemoPracticeApplication {

	@Autowired
    private DataSource dataSource;
	
	@GetMapping("/")
	ArrayList<String> home() {
		ArrayList<String> list = new ArrayList<String>();
		try(Connection con = dataSource.getConnection()){
			String stmt = "select * from users;";
			PreparedStatement pstmt = con.prepareStatement(stmt);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				list.add(username);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoPracticeApplication.class, args);
	}

}
