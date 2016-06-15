package cc.quest4i.modernjava.e03_consumer;

import java.util.function.Consumer;

/**
 * from kevin
 *
 * Created by samyeong-gu on 2016. 6. 13..
 */
public class ConsumerExamples {


    public static void main(String[] args) {


        final Consumer<String> print = System.out::println;
        print.accept("Hello");

        final Consumer<String> greetings = value -> System.out.println("Hello " + value);
        greetings.accept("World");
        greetings.accept("Kevin");


    }
}
