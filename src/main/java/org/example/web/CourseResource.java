package org.example.web;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.example.data.model.Course;
import org.example.data.repository.CourseRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/course")
public class CourseResource {
    private final Template course;
    private final CourseRepository repository;

    public CourseResource(Template course, CourseRepository repository) {
        this.course = course;
        this.repository = repository;
    }

    @GET
    public TemplateInstance index(@QueryParam("name") String name) throws SQLException {
        List<Course> allCourses;
        if (name == null || name.isEmpty()) {
            allCourses = repository.findAll();
        } else {
            allCourses = repository.findByName(name);
        }
        return course.data("courses", allCourses);
    }
}
