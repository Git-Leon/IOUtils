package com.github.git_leon.ioutils.filereader.simplefilereader;

import com.github.git_leon.ioutils.fileutils.SimpleFileReader;
import com.github.git_leon.ioutils.fileutils.SimpleFileWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * @author leon on 5/28/18.
 */
public class ReadLineTest {
    private SimpleFileReader fileReader;

    @Before
    public void setup() {
        // Given
        String fileName = "./target/testfiles/test";
        String expected = "The\nQuick\nBrown\nFox\nJumps\nOver\nThe\nLazy\nDog";
        File fileToHandle = new File(fileName);
        fileToHandle.delete();
        new SimpleFileWriter(fileName).writeln(expected);
        this.fileReader = new SimpleFileReader(fileName);
    }

    @Test
    public void readLine1() {
        // Given
        String expected = "The";
        Integer lineToBeRead = 1;

        // When
        String actual = fileReader.readLine(lineToBeRead);

        // Then
        Assert.assertEquals(expected, actual);
    }
}
