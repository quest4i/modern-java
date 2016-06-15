package cc.quest4i.modernjava.e08_03_stream_01;


import java.math.BigInteger;

import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * from kevin
 *
 * Created by samyeong-gu on 2016. 6. 14..
 */
public class StreamExamples1 {


    public static void main(String[] args) {

        range();


        /**
         * 아래 두 메소드를 실행하고 그냥 두시면 숫자가 계속 증가합니다
         * 꼭 강제종료 시켜주세요.
         */
//        infiniteCollection1();
//        infiniteCollection2();

    } // end of main()


    private static void range() {
        /**
         * 0 1 2 3 4 5 6 7 8 9
         */
        IntStream.range(0, 10)
                 .forEach(i -> System.out.print(i + " "));
        System.out.println();

        /**
         * 1 2 3 4 5 6 7 8 9 10
         */
        IntStream.rangeClosed(1, 10)
                 .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }


    private static void infiniteCollection1() {

        IntStream.iterate(1, i -> i + 1)
                 .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }   // end of infiniteCollection1()


    private static void infiniteCollection2() {

        Stream.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE))
                 .forEach(i -> System.out.print(i + " "));

    }   // end of infiniteCollection2()
}
