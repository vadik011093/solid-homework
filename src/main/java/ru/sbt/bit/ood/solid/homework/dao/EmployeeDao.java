package ru.sbt.bit.ood.solid.homework.dao;

import ru.sbt.bit.ood.solid.homework.domain.Employee;

import java.time.LocalDate;
import java.util.Collection;

public interface EmployeeDao {

    Collection<Employee> findByDepartmentIdBetweenDate(String departmentId, LocalDate dateFrom, LocalDate dateTo);

}
