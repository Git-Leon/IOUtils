package com.github.git_leon.ioutils.filereader.simplefilewriter;

import com.github.git_leon.ioutils.fileutils.SimpleFileWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * @author leon on 5/28/18.
 */
public class WriteLineTest {
    private SimpleFileWriter fileWriter;

    @Before
    public void setup() {
        // Given
        String fileName = "./target/testfiles/test";
        new File(fileName).delete();
        this.fileWriter = new SimpleFileWriter(fileName);
    }

    @Test
    public void writeMultipleLinesTest() {
        // Given
        String expected = "first line\nsecond line\nthird line\nfourth line";
        for (String line : expected.split("\n")) {

            // When
            fileWriter.writeln(line);
        }

        // Then
        String actual = fileWriter.toString();
        Assert.assertEquals(expected, actual);
    }
}
