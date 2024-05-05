package org.entities.shell;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.nio.charset.Charset;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import java.io.IOException;
import java.util.TreeMap;
import static java.util.function.Function.identity;

public class WordCount {

    public void run(String file) throws IOException {
        FileLoader fl = new FileLoader();
        List<String> lines = fl.loadFile(file);
        showStatistics(lines);
    }

    public void run(String file, Charset c) throws IOException {
        FileLoader fl = new FileLoader();
        List<String> lines = fl.loadFile(file, c);
        showStatistics(lines);
    }

    public void showStatistics(List<String> lines) {
        countLines(lines);
        coundWords(lines);
        countAvgLettersPerWords(lines);
        mostCommonWord(lines);
    }

    public long countLines(List<String> lines) {
        long totalLines = 0;
        if (lines != null && !lines.isEmpty()) {
            totalLines = lines.size();
        }

        System.out.println("Lines: " + totalLines);
        return totalLines;
    }

    public long coundWords(List<String> lines) {
        long totalWords = 0;
        if (lines != null && !lines.isEmpty()) {
            totalWords = lines.stream()
                    .map(l -> l.trim().split("[\\s]"))
                    .flatMap(Arrays::stream)
                    .filter(l -> l.trim().equals(""))
                    .count();

        }
        System.out.println("words: " + totalWords);
        return totalWords;
    }

    public double countAvgLettersPerWords(List<String> lines) {
        double avg = 0.0;
        if (lines != null && !lines.isEmpty()) {
            avg = lines.stream()
                    .map(l -> l.split("[\\s]"))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.averagingDouble(s -> s.length()));
        }

        System.out.format("average letters per word: %.2f%n", avg);
        return avg;
    }

    public String mostCommonWord(List<String> lines) {
        String word = "";
        Map.Entry<String, Long> mostCommon = null;
        if (lines != null && !lines.isEmpty()) {
            Map<String, Long> wordCount = lines.stream()
                    .map(l -> l.split("[\\s]"))
                    .flatMap(Arrays::stream)
                    .filter(c -> !c.trim().isEmpty())
                    .collect(groupingBy(identity(), TreeMap::new, counting()));
            mostCommon = wordCount.entrySet().stream()
                    .max(Map.Entry.comparingByValue(Long::compareTo))
                    .orElse(null);
        }
        if (mostCommon != null) {
            word = mostCommon.getKey();
            System.out.println("most common letter: " + mostCommon);
        }

        return word;

    }
}
