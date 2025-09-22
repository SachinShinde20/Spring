package com.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmpRowMapperImp implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
            rs.getInt("employee_id"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("department"),
            rs.getInt("salary")
        );
    }
}
