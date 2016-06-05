package cc.quest4i.modernjava.e01;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



/**
 * Created by quest4i on 2016. 6. 6..
 */
public class WhyJava8 {


    private static final List<Integer> numbers = IntStream.range(1, 11).boxed().collect(Collectors.toList());


    public static void main(String[] args) throws IOException {

        simpleTask();

        // file 읽기전에 /tmp/test.txt 파일이 있어야 함.
        readFile();
    }


    private static void simpleTask() {


        /* 옛날 옛적 for loop 사용하기 */
        final StringBuilder stringBuilder1 = new StringBuilder();
        final int size = numbers.size();
        for (int i = 0; i < size; i++) {
            stringBuilder1.append(numbers.get(i));
            if (i != size - 1) {
                stringBuilder1.append(" : " );
            }
        }
        System.out.println(stringBuilder1);


        /* for-each 사용 */
        final StringBuilder stringBuilder = new StringBuilder();
        final String separator = " : ";
        for (final Integer number : numbers) {
            stringBuilder.append(number).append(separator);
        }
        final int stringLength = stringBuilder.length();
        if (stringLength > 0) {
            stringBuilder.delete(stringLength - separator.length(), stringLength);
        }
        System.out.println(stringBuilder);


        /* Java 8 버전 */
        final String result = numbers.stream()
                                     .map(String::valueOf)
                                     .collect(joining(" : "));
        System.out.println(result);
    }



    private static void readFile() throws IOException {


        /* Java 7 */
        try (
                final FileReader fileReader = new FileReader(new File("/tmp/test.txt"));
                final BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            final List<String> uniqueWords = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line != null) {
                final String[] words = line.split("[\\s]+");  // 공백 문자로 String 나누기
                for (final String word : words) {
                    if (!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }
                }
                line = bufferedReader.readLine();
            }
            Collections.sort(uniqueWords);
            System.out.println(uniqueWords);
        }


        /* Java 8 */
        try (final Stream<String> lines = Files.lines(Paths.get("/tmp/test.txt"))) {
            System.out.println(
                    lines.map(line -> line.split("[\\s]+"))
                         .flatMap(Arrays::stream)
                         .distinct()
                         .sorted()
                         .collect(toList())
            );
        }
    }
}
