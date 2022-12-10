package org.example;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner obj2 = new Scanner (System.in);
        Scanner obj = new Scanner (System.in);
        Scanner obj3 = new Scanner (System.in);

        System.out.println ( "Directory path> " );
        String path = obj.next() + ".txt";
        while (true){
            File dir1 = new File (path);
            FileWriter writer = new FileWriter (dir1, true);

            System.out.println ( "Word> " );
            String path2 = obj2.next ();

            final var word = path2;
            try (final var files =
                         Files.find(
                                 Paths.get(path),
                                 Integer.MAX_VALUE,
                                 (p, basicFileAttributes) ->
                                         findExtension(p.getFileName().toString()).stream()
                                                 .anyMatch(s -> s.equals("txt")))) {
                files.forEach(p -> {
                    final var lines = getLines(p);
                    IntStream.range(0, lines.size())
                            .filter(i -> Arrays.asList(lines.get(i).split(" ")).contains(word))
                            .forEach(i -> System.out.println("File: [" + p.getFileName() + "], line number: [" + (i + 1) + "], line: [" + lines.get(i)+ "]."));
                });
            }
        }

    }

    public static Optional<String> findExtension(String fileName) {
        return Optional.of(fileName.lastIndexOf('.'))
                .filter(i -> i >= 0)
                .map(i -> fileName.substring(i + 1));
    }

    public static List<String> getLines(Path p) {
        try (final var lines = Files.lines(p)) {
            return lines.collect(Collectors.toList());
        } catch (IOException ex) {
            throw new RuntimeException("Unexpected error occurred.");
        }
    }}