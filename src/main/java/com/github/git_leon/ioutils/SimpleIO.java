package com.github.git_leon.ioutils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author leon on 5/28/18.
 */
public class SimpleIO {
    private final Scanner input;
    private final PrintStream output;

    public SimpleIO() {
        this(System.in, System.out);
    }

    public SimpleIO(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.output = out;
    }

    public void print(String val, Object... args) {
        output.format(val, args);
    }

    public void println(String val, Object... vals) {
        print(val + "\n", vals);
    }

    public String getStringInput(String prompt, Object... args) {
        println(prompt, args);
        return input.nextLine();
    }

    public Float getFloatInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Float floatInput = Float.parseFloat(stringInput);
            return floatInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting a numeric value!");
            return getFloatInput(prompt, args);
        }
    }

    public Long getLongInput(String prompt, Object... args) {
        String stringInput = getStringInput(prompt, args);
        try {
            Long longInput = Long.parseLong(stringInput);
            return longInput;
        } catch (NumberFormatException nfe) {
            println("[ %s ] is an invalid user input!", stringInput);
            println("Try inputting an integer value!");
            return getLongInput(prompt, args);
        }
    }

    public Integer getIntegerInput(String prompt, Object... args) {
        return getLongInput(prompt, args).intValue();
    }

    public Double getDoubleInput(String prompt, Object... args) {
        return getFloatInput(prompt, args).doubleValue();
    }
}
