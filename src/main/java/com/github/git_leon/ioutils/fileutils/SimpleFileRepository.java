package com.github.git_leon.ioutils.fileutils;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author leon on 5/28/18.
 */
public class SimpleFileRepository {
    private static volatile Map<String, File> fileMap = new TreeMap<>();
    public static synchronized File get(String fileName) {
        File file = fileMap.get(fileName);
        if (file == null) {
            file = new File(fileName);
            fileMap.put(fileName, file);
        }
        return file;
    }
}
