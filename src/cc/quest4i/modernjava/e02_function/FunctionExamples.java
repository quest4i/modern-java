package cc.quest4i.modernjava.e02_function;

import java.util.function.Function;

/**
 * from kevin
 *
 * Created by samyeong-gu on 2016. 6. 13..
 */
public class FunctionExamples {


    public static void main(String[] args) {

        final Function<String, Integer> toInt = Integer::parseInt;

        final Integer number = toInt.apply("100");
        System.out.println(number);

        final Function<Integer, Integer> identity = Function.identity();
        final Function<Integer, Integer> identity2 = T -> T;

        System.out.println(identity.apply(999));
        System.out.println(identity.apply(999));
    }
}
