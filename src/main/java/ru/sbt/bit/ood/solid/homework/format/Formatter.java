package ru.sbt.bit.ood.solid.homework.format;

import ru.sbt.bit.ood.solid.homework.report.Reporter;

@FunctionalInterface
public interface Formatter {

    String format(Reporter reporter);

}