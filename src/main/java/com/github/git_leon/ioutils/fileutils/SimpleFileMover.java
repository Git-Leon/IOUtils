package com.github.git_leon.ioutils.fileutils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author leon on 5/28/18.
 */
public class SimpleFileMover {
    private final File file;

    public SimpleFileMover(String fileName) {
        this(new File(fileName));
    }

    public SimpleFileMover(File file) {
        this.file = file;
    }

    @Deprecated // TODO - TEST!
    public void moveUpOneDirectory() {
        File currentFileDirectory = file.isDirectory() ? file : file.getParentFile();
        File parentFileDirectory = currentFileDirectory.getParentFile();
        try {
            Path currentFilePath = Paths.get(currentFileDirectory.getAbsolutePath());
            Path targetFilePath = Paths.get(parentFileDirectory.getAbsolutePath());
            Files.move(currentFilePath, targetFilePath);
        } catch (IOException e) {
            throw new Error(e);
        }
    }
}

