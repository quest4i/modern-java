package cc.quest4i.modernjava.e08_02_identity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;



/**
 * from kevin
 *
 * Created by samyeong-gu on 2016. 6. 14..
 */
public class IdentityExamples {


    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);


        System.out.println();
        System.out.println("mapOld(numbers, i -> i * 2)");
        System.out.println(
                mapOld(numbers, i -> i * 2)
        );


        System.out.println();
        System.out.println("map(numbers, i -> i * 2)\n" +
                map(numbers, i -> i * 2)
        );
        System.out.println("map(numbers, i -> i\n" +
                map(numbers, i -> i)
        );
        System.out.println("map(numbers, Function.identity())\n" +
                map(numbers, Function.identity())
        );

    } // end of main()



    private static <T, R> List<R> map(final List<T> list, final Function<T, R> mapper) {

        final List<R> result = new ArrayList<>();

        for (final T t : list) {
            result.add(mapper.apply(t));
        }

        return result;
    } // end of map()


    private static <T, R> List<R> mapOld(final List<T> list, final Function<T, R> mapper) {

        final List<R> result;

        if (mapper != null) {
            result = new ArrayList<>();
        } else {
            result = new ArrayList<>((List<R>) list);
        }

        if (result.isEmpty()) {
            if (!list.isEmpty()) {
                for (final T t : list) {
                    result.add(mapper.apply(t));
                }
            }
        }

        return result;
    } // end of mapOld()
}
