package model.mapper;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("student_id"));
        student.setName(rs.getString("first_name"));
        student.setSurname(rs.getString("last_name"));
        student.setGroup(groupMapper.mapRow(rs,i));
        return student;
    }
}
