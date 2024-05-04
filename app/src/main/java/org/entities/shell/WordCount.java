package org.entities.shell;

import java.util.List;

public class WordCount {

    public long countLines(List<String> lines) {
        long totalLines = 0;
        if (lines != null && !lines.isEmpty()) {
            totalLines = lines.size();
        }

        System.out.println("Lines: " + totalLines);
        return totalLines;
    }
}
