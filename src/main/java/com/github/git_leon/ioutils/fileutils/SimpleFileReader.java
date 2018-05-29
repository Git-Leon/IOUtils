package com.github.git_leon.ioutils.fileutils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author leon on 5/28/18.
 */
public class SimpleFileReader {
    private List<String> lines = new ArrayList<>();

    public SimpleFileReader(String fileName) {
        this(new File(fileName));
    }

    public SimpleFileReader(File file) {
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new Error(e);
        }

        while (fileScanner.hasNext()) {
            lines.add(fileScanner.next());
        }
        fileScanner.close();
    }

    public List<String> readLines(Integer startingLine, Integer endingLine) {
        return lines.subList(startingLine, endingLine);
    }

    public String readLine(Integer lineNumber) {
        return readLines(lineNumber - 1, lineNumber + 1).get(0);
    }

    public String readRandomLineNumber() {
        return readLine((int) ThreadLocalRandom.current().nextLong(0, getNumberOfLines()));
    }

    public Integer getNumberOfLines() {
        return lines.size();
    }

    public List<String> readLines() {
        return lines;
    }

    public String toString() {
        String eol = System.getProperty("line.separator");
        String[] stringArray = lines.stream().toArray(String[]::new);
        return String.join(eol, stringArray);
    }

}
