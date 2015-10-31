package ru.sbt.bit.ood.solid.homework.report;

import ru.sbt.bit.ood.solid.homework.domain.Employee;

import java.util.Collection;
import java.util.function.Function;

public final class Reporter {

    private final String type;
    private final Function<Collection<Employee>, Double> salaryReport;

    public Reporter(Function<Collection<Employee>, Double> salaryReport, String type) {
        this.salaryReport = salaryReport;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double report(Collection<Employee> employees) {
        return salaryReport.apply(employees);
    }

}