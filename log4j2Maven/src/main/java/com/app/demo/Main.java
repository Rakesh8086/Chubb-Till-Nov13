package com.app.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Hello, Log4j2!");
        logger.debug("This is a debug message");
        logger.error("An error occurred!");
        // both properties and xml file of log is the same, 
        // just different ways of writing
    }
}
