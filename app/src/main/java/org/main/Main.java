package org.main;

import org.entities.shell.FileLoader;
import org.entities.shell.WordCount;
import java.util.logging.Logger;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class Main {

    public static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        LOG.fine("Starting");

        if (args != null && args.length == 1) {
            String path = args[0];
            FileLoader fInstance = new FileLoader();
            List<String> lines = fInstance.loadFile(path);
            WordCount wc = new WordCount();
            wc.showStatistics(lines);

        } else {
            System.out.println("Invalid input expecting wc <file>");
        }
        LOG.fine("Complete");
    }
}