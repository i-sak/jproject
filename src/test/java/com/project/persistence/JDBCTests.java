package com.project.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mariadb://35.185.201.27:3306/test",
				"isaac",
				"isaackiss"
			))
		{
			log.info(connection);
			if (connection != null) {
				System.out.println("DB Connection Success!");
			}
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
