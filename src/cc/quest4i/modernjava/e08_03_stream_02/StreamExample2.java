package cc.quest4i.modernjava.e08_03_stream_02;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;



/**
 *
 * stream이 훨씬 효율적으로 작동한다.
 *
 * Created by samyeong-gu on 2016. 6. 14..
 */
public class StreamExample2 {


    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 10)
                                                          .boxed()
                                                          .collect(Collectors.toList());


    public static void main(String[] args) {

//        System.out.println(NUMBERS.getClass().getName());

        Stream.of(1, 2, 3, 4, 5).forEach(i -> System.out.print(i + " "));
        System.out.println("\n==================================================");

        Integer result = null;
        for (final Integer number : NUMBERS) {
            if (number > 3 && number < 9) {
                final Integer newNumber = number * 2;
                if (newNumber > 10) {
                    result = newNumber;
                    break;
                }
            }
        } // end of for
        System.out.println("\n==================================================");
        System.out.println("Imperative Result: " + result);
        System.out.println();


        System.out.println("\n==================================================");
        System.out.println("Functional Result: " +
                NUMBERS.stream()
                       .filter(number -> number > 3)
                       .filter(number -> number < 9)
                       .map(number -> number * 2)
                       .filter(number -> number > 10)
                       .findFirst()
        );


        System.out.println("\n==================================================");
        System.out.println("Functional Result (with loggin): " +
                NUMBERS.stream()
                       .filter(number -> {
                           System.out.println("number > 3");
                           return number > 3;
                       })
                       .filter(number -> {
                           System.out.println("number < 9");
                           return number < 9;
                       })
                       .map(number -> {
                           System.out.println("number * 2");
                           return number * 2;
                       })
                       .filter(number -> {
                           System.out.println("number > 10");
                           return number > 10;
                       })
                       .findFirst()
        );
        System.out.println("\n==================================================");
        System.out.println();



        final List<Integer> greaterThan3 = filter(NUMBERS, i -> i > 3);
        final List<Integer> lessThan9 = filter(NUMBERS, i -> i < 9);
        final List<Integer> doubled = map(lessThan9, i -> i * 2);
        final List<Integer> greaterThan10 = filter(doubled, i -> i > 10);
        System.out.println("My own method result: " + greaterThan10);
        System.out.println("My own method result.get(0): " + greaterThan10.get(0));
        System.out.println();



        System.out.println("\n==================================================");
        final List<Integer> myOwnMethodResult =
                filter(
                        map(
                                filter(
                                        filter(NUMBERS,
                                                i -> i > 3),
                                        i -> i < 9),
                                i -> i * 2),
                        i -> i > 10);

        System.out.println("My own method result: " + myOwnMethodResult);
        System.out.println("My own method result.get(0): " + myOwnMethodResult.get(0));


        System.out.println("\n==================================================");
        customMethodsWithLogging();

    }   // end of main()


    private static void customMethodsWithLogging() {

        final AtomicInteger count = new AtomicInteger(1);

        final List<Integer> greaterThan3 = filter(NUMBERS, i -> {
            System.out.println(count.getAndIncrement() + ": i > 3");
            return i > 3;
        });

        final List<Integer> lessThan9 = filter(greaterThan3, i -> {
            System.out.println(count.getAndIncrement() + ": i < 9");
            return i < 9;
        });

        final List<Integer> doubled = map(lessThan9, i -> {
            System.out.println(count.getAndIncrement() + ": i * 2");
            return i * 2;
        });

        final List<Integer> greaterThan10 = filter(doubled, i -> {
            System.out.println(count.getAndIncrement() + ": i > 10");
            return i > 10;
        });

        System.out.println("My own method result: " + greaterThan10);
        System.out.println("My own method result.get(0): " + greaterThan10.get(0));

    }   // end of customMethodsWithLoggin()


    private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {

        final List<T> result = new ArrayList<>();

        for (final T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }

        return result;
    }   // end of filter()


    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {

        final List<R> result = new ArrayList<>();

        for (final T t : list) {
            result.add(mapper.apply(t));
        }

        return result;
    }   // end of map()
}