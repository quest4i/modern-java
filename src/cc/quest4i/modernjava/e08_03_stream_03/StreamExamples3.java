package cc.quest4i.modernjava.e08_03_stream_03;



import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import static java.util.stream.Collectors.*;


/**
 * from kevin
 *
 * Created by samyeong-gu on 2016. 6. 14..
 */
public class StreamExamples3 {


    public static void main(String[] args) {


        System.out.println("collect(toList()): " +
                Stream.of(1, 3, 3, 5, 5)
                      .filter(i -> i > 2)
                      .map(i -> i * 2)
                      .map(i -> "#" + i)
                      .collect(toList())
        );

        System.out.println("collect(toSet()): " +
                Stream.of(1, 3, 3, 5, 5)
                      .filter(i -> i > 2)
                      .map(i -> i * 2)
                      .map(i -> "#" + i)
                      .collect(toSet())
        );

        System.out.println("collect(joining()): " +
                Stream.of(1, 3, 3, 5, 5)
                      .filter(i -> i > 2)
                      .map(i -> i * 2)
                      .map(i -> "#" + i)
                      .collect(joining())
        );

        System.out.println("collect(joining(\", \")): " +
                Stream.of(1, 3, 3, 5, 5)
                      .filter(i -> i > 2)
                      .map(i -> i * 2)
                      .map(i -> "#" + i)
                      .collect(joining(", "))
        );

        System.out.println("collect(joining(\", \", \"[\", \"]\")): " +
                Stream.of(1, 3, 3, 5, 5)
                      .filter(i -> i > 2)
                      .map(i -> i * 2)
                      .map(i -> "#" + i)
                      .collect(joining(", ", "[", "]"))
        );

         System.out.println("distinct().collect(joining(\", \", \"[\", \"]\")): " +
                Stream.of(1, 3, 3, 5, 5)
                      .filter(i -> i > 2)
                      .map(i -> i * 2)
                      .map(i -> "#" + i)
                      .distinct()
                      .collect(joining(", ", "[", "]"))
        );

        System.out.println("distinct().collect(toList()): " +
                Stream.of(1, 3, 3, 5, 5)
                      .filter(i -> i > 2)
                      .map(i -> i * 2)
                      .map(i -> "#" + i)
                      .distinct()
                      .collect(toList())
        );

        final Integer integer3 = 3;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5)
                      .filter(i -> i == integer3)
                      .findFirst()
        );

        final Integer integer127 = 127;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 127)
                      .filter(i -> i == integer127)
                      .findFirst()
        );

        // Java의 기본 캐쉬 설정에 달렸다!
        final Integer integer128 = 128;
        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                      .filter(i -> i == integer128)
                      .findFirst()
        );

        System.out.println(
                Stream.of(1, 2, 3, 4, 5, 128)
                      .filter(i -> i.equals(integer128))
                      .findFirst()
        );

        System.out.println(".filter(i -> i > integer3).count(): " +
                Stream.of(1, 2, 3, 4, 5)
                      .filter(i -> i > integer3)
                      .count()
        );

        final List<Integer> numbers = IntStream.rangeClosed(1, 5).boxed().collect(toList());
        System.out.println("for (Integer i : numbers): " );
        for (Integer i : numbers) {
            System.out.print("i = " + i + " ");
        }
        System.out.println();

        System.out.println("\n\nforEach(i -> System.println(i))");
        Stream.of(1, 2, 3, 4, 5)
              .forEach(i -> System.out.print(i + " "));


        System.out.println(".filter(i -> i > integer3).count(): " +
                Stream.of(1, 2, 3, 4, 5)
                      .filter(i -> i > integer3)
                      .count()
        );


    }   // end of main()
}
