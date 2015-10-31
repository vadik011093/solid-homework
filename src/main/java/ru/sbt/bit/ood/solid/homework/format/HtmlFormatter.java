package ru.sbt.bit.ood.solid.homework.format;

import ru.sbt.bit.ood.solid.homework.domain.Employee;
import ru.sbt.bit.ood.solid.homework.report.Reporter;

import java.util.Collection;

public class HtmlFormatter implements Formatter {

    private final Collection<Employee> employees;

    public HtmlFormatter(Collection<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String format(Reporter reporter) {

        StringBuilder resultingHtml = new StringBuilder();

        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");

        for (Employee employee : employees) {
            resultingHtml.append("<tr>");
            resultingHtml.append("<td>").append(employee.getName()).append("</td>");
            resultingHtml.append("<td>").append(employee.getSalary()).append("</td>");
            resultingHtml.append("</tr>");
        }

        resultingHtml.append("<tr><td>" + reporter.getType() + "</td><td>").append(reporter.report(employees)).append("</td></tr>");
        resultingHtml.append("</table></body></html>");

        return resultingHtml.toString();
    }

}