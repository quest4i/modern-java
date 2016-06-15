package cc.quest4i.modernjava.e05_supplier;


import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;



/**
 * Created by samyeong-gu on 2016. 6. 13..
 *  계산 하는데 오래 걸리는 메소드를 시뮬레이션 항상 3초가 걸림
 *
 * @return      항상 "Kevin"만 리턴
 */
public class SupplierExamples {

    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Kevin";
    }


    private static void callingExpensiveMethodWithoutSupplier() {
        System.out.println("SupplierExamples.callingExpensiveMethodWidthoutSupplier()");
        final long start = System.currentTimeMillis();
//        printIfValidIndex(0, getVeryExpensiveValue());
        printIfValidIndex(0, SupplierExamples::getVeryExpensiveValue);
        printIfValidIndex(-1, SupplierExamples::getVeryExpensiveValue);
        printIfValidIndex(-2, SupplierExamples::getVeryExpensiveValue);
        System.out.println("It took " + ((System.currentTimeMillis() - start) / 1000) + " seconds.");
    }

    private static void printIfValidIndex(final int number, final String value) {
        if (number >= 0) {
            System.out.println("The value is " + value + ".");
        } else {
            System.out.println("Invalid");
        }
    }

    private static void callingExpensiveMethodWithSupplier() {

        System.out.println("SupplierExamples.callingExpensiveMethodWithSupplier()");

        final long start = System.currentTimeMillis();

//        printIfValidIndex(0, () -> getVeryExpensiveValue());
        printIfValidIndex(0, SupplierExamples::getVeryExpensiveValue);
        printIfValidIndex(-1, SupplierExamples::getVeryExpensiveValue);
        printIfValidIndex(-2, SupplierExamples::getVeryExpensiveValue);
        System.out.println("It took " + ((System.currentTimeMillis() - start) / 1000) + " seconds.");
    }

    private static void printIfValidIndex(final int number, final Supplier<String> valueSupplier) {
        if (number >= 0) {
            System.out.println("The value is " + valueSupplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }


    private static void supplierExamples() {

        System.out.println("SupplierExamples.supplierExamples()");

        final Supplier<String> helloSupplier = () -> "Hello";

        System.out.println(helloSupplier.get() + "world");
    }


    public static void main(String[] args) {

        supplierExamples();

        System.out.println("\nSupplier 사용하지 않고 시간 오래 걸리는 메소드 호출");
        callingExpensiveMethodWithoutSupplier();

        System.out.println("\nSupplier 사용해서 시간 오래 걸리는 메소드 호출");
        callingExpensiveMethodWithSupplier();
    }
}
