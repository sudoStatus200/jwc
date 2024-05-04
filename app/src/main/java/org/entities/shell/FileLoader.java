package org.entities.shell;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileLoader {

    public FileLoader() {

    }

    public List<String> loadFile(String url, Charset c) throws IOException {
        File f = new File(url);
        if (f.isFile() && f.canRead()) {
            return loadFile(f.toPath(), c);
        } else {
            throw new IOException("Cannot read file " + url);
        }
    }

    public List<String> loadFile(Path path, Charset c) throws IOException {
        return Files.readAllLines(path, c);
    }

    public List<String> loadFile(String url) throws IOException {
        File f = new File(url);
        if (f.isFile() && f.canRead()) {
            return loadFile(f.toPath());
        } else {
            throw new IOException("Cannot read file " + url);
        }
    }

    public List<String> loadFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }

}
