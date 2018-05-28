package com.github.git_leon.ioutils.console;

import com.github.git_leon.ioutils.ConsoleIO;

import java.io.*;

/**
 * @author leon on 5/28/18.
 */
public class ConsoleTestUtils {
    public static ConsoleIO getConsoleWithBufferedInput(String input, OutputStream outputStream) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ConsoleIO console = new ConsoleIO(inputStream, new PrintStream(outputStream));
        return console;
    }

    public static ConsoleIO getConsoleWithBufferedInput(Number input, OutputStream outputStream) {
        return getConsoleWithBufferedInput(input.toString(), outputStream);
    }

    public static ConsoleIO getMockConsole() {
        return getConsoleWithBufferedInput("", new PrintStream(new ByteArrayOutputStream()));
    }
}
