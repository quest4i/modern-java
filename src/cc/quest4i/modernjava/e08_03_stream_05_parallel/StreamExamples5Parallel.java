package cc.quest4i.modernjava.e08_03_stream_05_parallel;


import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;


/**
 * Created on 2016. 6. 16. 오전 2:01.
 *
 *
 *
 * @author quest4i
 */
public class StreamExamples5Parallel {


    public static void main(String[] args) {

        raceConditionTest();

    } // end of main()


    /**
     * Race Condition을 보여주는 코드입니다
     * Parallel Programming을 할경우 side-effect, 이 예제의 경우 variable의 값을
     * 계속 re-assign하는 방법을 이용하게 되면 Race Condition이 발생하기 쉽습니다.
     */
    private static void raceConditionTest() {

        System.out.println("\n===================================================");
        System.out.println("StreamExamples5Parallel.raceConditionTest");

        final int[] sum = { 0 };
        IntStream.rangeClosed(1, 100)
                 .forEach(i -> sum[0] += i);
        System.out.println("            stream sum (side-effect): " + sum[0]);

        final int[] sum2 = { 0 };
        IntStream.rangeClosed(1, 100)
                 .parallel()
                 .forEach(i -> sum2[0] += i);
        System.out.println("          parallel sum (side-effect): " + sum2[0]);



        System.out.println("         stream sum (no side-effect): " +
                IntStream.rangeClosed(1, 100)
                         .sum());

        System.out.println("parallel stream sum (no side-effect): " +
                IntStream.rangeClosed(1, 100)
                         .parallel()
                         .sum());

        System.out.println("              reduce instead of sum : " +
                IntStream.rangeClosed(1, 1009000000)
                         .parallel()
                         .reduce(0, Integer::sum));
    } // end of raceConditionTest()


}
