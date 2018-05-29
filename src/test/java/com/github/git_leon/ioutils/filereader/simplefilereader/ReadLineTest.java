package com.github.git_leon.ioutils.filereader.simplefilereader;

import com.github.git_leon.ioutils.fileutils.SimpleFileReader;
import com.github.git_leon.ioutils.fileutils.SimpleFileWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

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
    public void readLinesBetween2And5() {
        // Given
        Integer startIndex = 2;
        Integer endIndex = 5;
        String[] expectedValues = {"Brown", "Fox", "Jumps"};

        // When
        String[] actualValues = fileReader
                .readLines(startIndex, endIndex)
                .stream()
                .toArray(String[]::new);

        // Then
        String expected = Arrays.toString(expectedValues);
        String actual = Arrays.toString(actualValues);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void readLinesBetween1And5() {
        // Given
        Integer startIndex = 1;
        Integer endIndex = 5;
        String[] expectedValues = {"Quick", "Brown", "Fox", "Jumps"};

        // When
        String[] actualValues = fileReader
                .readLines(startIndex, endIndex)
                .stream()
                .toArray(String[]::new);

        // Then
        String expected = Arrays.toString(expectedValues);
        String actual = Arrays.toString(actualValues);

        Assert.assertEquals(expected, actual);
    }



    @Test
    public void readLinesBetween0And5() {
        // Given
        Integer startIndex = 0;
        Integer endIndex = 5;
        String[] expectedValues = {"The", "Quick", "Brown", "Fox", "Jumps"};

        // When
        String[] actualValues = fileReader
                .readLines(startIndex, endIndex)
                .stream()
                .toArray(String[]::new);

        // Then
        String expected = Arrays.toString(expectedValues);
        String actual = Arrays.toString(actualValues);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void readLine0() throws IndexOutOfBoundsException {
        // Given
        Integer lineToBeRead = 0;

        // When
        fileReader.readLine(lineToBeRead);
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


    @Test
    public void readLine2() {
        // Given
        String expected = "Quick";
        Integer lineToBeRead = 2;

        // When
        String actual = fileReader.readLine(lineToBeRead);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void readLine3() {
        // Given
        String expected = "Brown";
        Integer lineToBeRead = 3;

        // When
        String actual = fileReader.readLine(lineToBeRead);

        // Then
        Assert.assertEquals(expected, actual);
    }
}
