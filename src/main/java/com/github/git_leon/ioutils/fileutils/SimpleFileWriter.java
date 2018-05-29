package com.github.git_leon.ioutils.fileutils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author leon on 5/28/18.
 */
public class SimpleFileWriter {
    private final File file;

    public SimpleFileWriter(String fileName) {
        this(new File(fileName));
    }

    public SimpleFileWriter(File file) {
        this.file = file;
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public void write(String lineToWrite) {
        String fileName = file.getAbsolutePath();
        byte[] bytesToWrite = lineToWrite.getBytes();
        Path filepath = Paths.get(fileName);

        try {
            Files.write(filepath, bytesToWrite, StandardOpenOption.APPEND);
        } catch (IOException e) {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), Charset.defaultCharset()))) {
                writer.write(lineToWrite);
            } catch (IOException e1) {
                throw new Error(e1);
            }
        }
    }

    public void writeln(String lineToWrite) {
        String eol = System.getProperty("line.separator");
        lineToWrite = lineToWrite + eol;
        write(lineToWrite);
    }

    public File getFile() {
        return file;
    }

    public String toString() {
        return new SimpleFileReader(file).toString();
    }
}
