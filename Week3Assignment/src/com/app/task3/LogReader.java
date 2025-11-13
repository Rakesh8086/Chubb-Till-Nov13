package com.app.task3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class LogReader {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static List<LogEntry> readLogs(List<String> logLines) {
        return logLines.stream()
                .filter(line -> !line.isBlank())
                .map(LogReader::parseLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static LogEntry parseLine(String line) {
        try {
            String[] parts = line.split(" ", 4);
            LocalDateTime time = LocalDateTime.parse(parts[0] + " " + parts[1], formatter);
            String level = parts[2].trim();
            String message = parts[3].trim();
            return new LogEntry(time, level, message);
        } catch (Exception e) {
            System.err.println("Skipping invalid log line: " + line);
            return null;
        }
    }
}