package ru.sbt.bit.ood.solid.homework.dao;

import ru.sbt.bit.ood.solid.homework.domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final Connection connection;

    public EmployeeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Collection<Employee> findByDepartmentIdBetweenDate(String departmentId, LocalDate dateFrom, LocalDate dateTo) {

        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select emp.id as emp_id, emp.name as amp_name, sum(salary) as salary from employee emp left join" +
                    "salary_payments sp on emp.id = sp.employee_id where emp.department_id = ? and" +
                    " sp.date >= ? and sp.date <= ? group by emp.id, emp.name");

            ps.setString(0, departmentId);
            ps.setDate(1, new java.sql.Date(dateFrom.toEpochDay()));
            ps.setDate(2, new java.sql.Date(dateTo.toEpochDay()));

            ResultSet results = ps.executeQuery();
            while (results.next()) {
                Employee employee = new Employee();
                employee.setName(results.getString("emp_name"));
                employee.setSalary(results.getDouble("salary"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}