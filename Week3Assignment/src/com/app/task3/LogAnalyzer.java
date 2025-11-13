package com.app.task3;

import java.util.*;
import java.util.stream.Collectors;

public class LogAnalyzer {

    public void printReport(List<LogEntry> logs) {
        
        // map to store the log type and its message
        Map<String, Long> countByLevel = logs.stream()
                .collect(Collectors.groupingBy(LogEntry::getLevel, Collectors.counting()));

        countByLevel.forEach((level, count) ->
                System.out.println(level + " - " + count));

        logs.stream()
                .filter(log -> log.getLevel().equals("ERROR"))
                .forEach(System.out::println);
    }
}