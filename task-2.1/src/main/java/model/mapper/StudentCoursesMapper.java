package model.mapper;

import model.StudentCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCoursesMapper implements RowMapper<StudentCourses> {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public StudentCourses mapRow(ResultSet rs, int i) throws SQLException {
        StudentCourses studentCourses = new StudentCourses();
        studentCourses.setStudent(studentMapper.mapRow(rs,i));
        studentCourses.setCourse(courseMapper.mapRow(rs,i));
        return studentCourses;
    }
}
