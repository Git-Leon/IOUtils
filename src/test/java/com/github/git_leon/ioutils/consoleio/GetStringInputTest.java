package com.github.git_leon.ioutils.consoleio;

/**
 * @author leon on 5/28/18.
 */

import com.github.git_leon.ioutils.SimpleIO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author leon on 5/28/18.
 */
public class GetStringInputTest  {
    private PrintStream output;

    @Before
    public void setup() {
        this.output = new PrintStream(new ByteArrayOutputStream());
    }

    @Test
    public void getInputOf11Test() {
        // Given
        String input = "11";
        String expected = input;

        SimpleIO console = SimpleIOTestUtils.getConsoleWithBufferedInput(input, output);

        // When
        String actual = console.getStringInput("Input a string");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getInputOfTheQuickBrownFoxTest() {
        // Given
        String input = "The Quick Brown Fox";
        String expected = input;

        SimpleIO console = SimpleIOTestUtils.getConsoleWithBufferedInput(input, output);

        // When
        String actual = console.getStringInput("Input a string");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getInputOfJumpsOverTheLazyDogTest() {
        // Given
        String input = "Jumps Over The Lazy Dog";
        String expected = input;

        SimpleIO console = SimpleIOTestUtils.getConsoleWithBufferedInput(input, output);

        // When
        String actual = console.getStringInput("Input a string");

        // then
        Assert.assertEquals(expected, actual);
    }
}

