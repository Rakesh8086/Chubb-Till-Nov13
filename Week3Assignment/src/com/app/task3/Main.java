package com.app.task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    	List<String> logsData = List.of(
                "2025-11-12 10:05:21 INFO  AAAA",
                "2025-11-12 10:05:25 WARN  BBBB",
                "2025-11-12 10:05:30 ERROR CCCC",
                "2025-11-12 10:05:45 INFO  DDDD",
                "2025-11-12 10:05:50 INFO  EEEE",
                "2025-11-12 10:06:00 ERROR FFFF"
        );

        List<LogEntry> logs = LogReader.readLogs(logsData);

        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.printReport(logs);
    }
}