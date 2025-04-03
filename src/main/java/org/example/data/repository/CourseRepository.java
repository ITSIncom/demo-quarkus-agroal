package org.example.data.repository;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.data.model.Course;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped

public class CourseRepository {
	private final AgroalDataSource ds;

	public CourseRepository(AgroalDataSource ds) {
		this.ds = ds;

	}

	public List<Course> findAll() throws SQLException {
		List<Course> courses = new ArrayList<>();
		try (Connection c = ds.getConnection()) {
			try (Statement s = c.createStatement()) {
				try (ResultSet rs = s.executeQuery("select * from Course")) {
					while (rs.next()) {
						String name = rs.getString("name");
						String description = rs.getString("description");
						int totalHour = rs.getInt("total_hour");
						LocalDate date = rs.getDate("date_start").toLocalDate();
						LocalDate endDate = rs.getDate("date_end").toLocalDate();
						int courseId = rs.getInt("Code");
						Course course = new Course(name, courseId, description, totalHour, date, endDate);
						courses.add(course);
					}
				}
			}
		}
		return courses;
	}

}
