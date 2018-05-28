package com.github.git_leon.ioutils.console;

import com.github.git_leon.ioutils.ConsoleIO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author leon on 5/28/18.
 */
public class GetIntegerInputTest {
    private PrintStream output;

    @Before
    public void setup() {
        this.output = new PrintStream(new ByteArrayOutputStream());
    }

    @Test
    public void getInputOf11Test() {
        // Given
        Integer input = 11;
        Integer expected = input;

        ConsoleIO console = ConsoleTestUtils.getConsoleWithBufferedInput(input, output);

        // When
        Integer actual = console.getIntegerInput("Input an integer");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getInputOf12Test() {
        // Given
        Integer input = 12;
        Integer expected = input;

        ConsoleIO console = ConsoleTestUtils.getConsoleWithBufferedInput(input, output);

        // When
        Integer actual = console.getIntegerInput("Input an integer");

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getInputOf15Test() {
        // Given
        Integer input = 15;
        Integer expected = input;

        ConsoleIO console = ConsoleTestUtils.getConsoleWithBufferedInput(input, output);

        // When
        Integer actual = console.getIntegerInput("Input an integer");

        // then
        Assert.assertEquals(expected, actual);
    }
}
