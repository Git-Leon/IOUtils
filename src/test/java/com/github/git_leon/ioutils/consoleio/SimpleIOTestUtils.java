package com.github.git_leon.ioutils.consoleio;

import com.github.git_leon.ioutils.SimpleIO;

import java.io.*;

/**
 * @author leon on 5/28/18.
 */
public class SimpleIOTestUtils {
    public static SimpleIO getConsoleWithBufferedInput(String input, OutputStream outputStream) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        SimpleIO console = new SimpleIO(inputStream, new PrintStream(outputStream));
        return console;
    }

    public static SimpleIO getConsoleWithBufferedInput(Number input, OutputStream outputStream) {
        return getConsoleWithBufferedInput(input.toString(), outputStream);
    }

    public static SimpleIO getMockConsole() {
        return getConsoleWithBufferedInput("", new PrintStream(new ByteArrayOutputStream()));
    }
}
