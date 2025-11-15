package com.app.fileHandling;

import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.util.Arrays.stream;


public class WordCounter {
	public static int normalMethod(String fileName) {
		int indiaCount = 0;
		String line;
				
		try(BufferedReader bufferReader = new BufferedReader(new java.io.FileReader(fileName))) {
            while((line = bufferReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for(String word : words) {
                    if(word.equalsIgnoreCase("india")) {
                    	indiaCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return indiaCount;
	}
	public static int functionalMethod(String fileName) {
		int count = 0;
		try {
			count = (int)Files.lines(Path.of(fileName))
					.flatMap(sentence->stream(sentence.split("\\W+")))
					.filter(word->word.equalsIgnoreCase("india"))
					.count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	public static void main(String[] args) {
		String fileName = "file.txt";
		
		System.out.println(normalMethod(fileName));
		System.out.println("---------");
		
	
		System.out.println(functionalMethod(fileName));
	}
}
