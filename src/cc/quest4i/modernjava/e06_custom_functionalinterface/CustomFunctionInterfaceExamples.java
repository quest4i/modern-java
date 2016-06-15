package cc.quest4i.modernjava.e06_custom_functionalinterface;



import java.math.BigDecimal;



/**
 * Functional Interface 실전 사용 예제 및 functional Interface 제약 사항 추가
 *
 * Created by samyeong-gu on 2016. 6. 13..
 */
public class CustomFunctionInterfaceExamples {

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }

    public static void main(String[] args) {

        println(1, 2, 3, (i1, i2, i3) -> String.valueOf(i1 + i2 + i3));
        println("Area is " , 12, 20, (message, length, width) -> message + (length * width));
        println(1L, "Kevin", "test@email.com",
                (id, name, email) -> "User info: ID=" + id + ", name=" + name + ", email=" + email);

        final Function3<Integer, Integer, Integer, String>  f3 =
                (i1, i2, i3) -> String.valueOf(i1 + i2 + i3);

        final BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));


      final InvalidFunctionalInterface anonymousClass = new InvalidFunctionalInterface() {

          @Override
          public <T> String mkString(T value) {
              return value.toString();
          }
      };
//        final InvalidFunctionalInterface anonymousClass = (value) -> value.toString();
        System.out.println("anonymous class: " + anonymousClass.mkString(123));
    }
}


@FunctionalInterface
interface Function3<T1, T2, T3, R> {

    R apply(T1 t1, T2 t2, T3 t3);
}


@FunctionalInterface
interface BigDecimalToCurrency {

    String toCurrency(BigDecimal value);
}


@FunctionalInterface
interface InvalidFunctionalInterface {

    <T> String mkString(T value);
}
