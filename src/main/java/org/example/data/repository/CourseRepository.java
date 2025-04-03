package org.example.data.repository;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.data.model.Course;

import java.sql.*;
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
                        Course course = toCourse(rs);
                        courses.add(course);
                    }
                }
            }
        }
        return courses;
    }

    public List<Course> findByName(String name) throws SQLException {
        List<Course> courses = new ArrayList<>();
        try (Connection c = ds.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("select * from Course where name = ?")) {
                ps.setString(1, name);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Course course = toCourse(rs);
                        courses.add(course);
                    }
                }
            }
        }
        return courses;
    }

    public boolean save(Course course) throws SQLException {
        try (Connection c = ds.getConnection()) {
            try (PreparedStatement ps = c.prepareStatement("INSERT INTO Course (name, description, date_start, date_end, total_hour) VALUES (?, ?, ?, ?, ?)")) {
                ps.setString(1, course.getName());
                ps.setString(2, course.getDescription());
                ps.setDate(3, Date.valueOf(course.getStartDate()));
                ps.setDate(4, Date.valueOf(course.getEndDate()));
                ps.setInt(5, course.getTotalHour());
                int modified = ps.executeUpdate();
                return modified > 0;
            }
        }
    }

    private static Course toCourse(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String description = rs.getString("description");
        int totalHour = rs.getInt("total_hour");
        LocalDate date = rs.getDate("date_start").toLocalDate();
        LocalDate endDate = rs.getDate("date_end").toLocalDate();
        int courseId = rs.getInt("Code");
        Course course = new Course(name, courseId, description, totalHour, date, endDate);
        return course;
    }

}
