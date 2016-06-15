package cc.quest4i.modernjava.e01;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 *
 * An example of "Inheritance breaks Encapsulation"
 * 상속Inheritance)이 캡슐화Encapsulation)을 망치는 예제입니다.
 *
 * Created by quest4i on 2016. 6. 6..
 */
public class OopExample {


    public static void main(String[] args) {

        final MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("    list count: " + list.getCount());

        final MyList<Integer> list2 = new MyList<>();
        list2.addAll(IntStream.range(1, 6).boxed().collect(Collectors.toList()));
        System.out.println("    list2 count: " + list2.getCount());


        System.out.println("----------------------------");
        final MySet<Integer> mySet = new MySet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);
        System.out.println("    mySet count: " + mySet.getCount());

        final MySet<Integer> mySet2 = new MySet<>();
        mySet2.addAll(IntStream.range(1, 6).boxed().collect(Collectors.toSet()));
        System.out.println("    mySet2 count: " + mySet2.getCount());


        System.out.println("----------------------------");
        final MyNewSet<Integer> myNewSet = new MyNewSet<>();
        myNewSet.add(1);
        myNewSet.add(2);
        myNewSet.add(3);
        System.out.println(" myNewSet count: " + myNewSet.getCount());

        final MyNewSet<Integer> myNewSet2 = new MyNewSet<>();
        myNewSet2.addAll(IntStream.range(1, 6).boxed().collect(Collectors.toSet()));
        System.out.println(" myNewSet2 count: " + myNewSet2.getCount());



    }
}




class MyList<E> extends ArrayList<E> {

    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        count += c.size();
        return super.addAll(c);
    }

    @Override
    public boolean add(final E e) {
        count++;
        return super.add(e);
    }
}



class MySet<E> extends HashSet<E> {

    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {
        count += c.size();
        return super.addAll(c);
    }

    @Override
    public boolean add(final E e) {
        count++;
        return super.add(e);
    }
}


/**
 * NewSet은 HashSet에 있는 Inheritance가 Encapsulation을 깨뜨리는 것을 미리 예방해서
 * 다시 디자인한것입니다 (add와 addAll 메소드에 한정)
 *
 */
class NewSet<E> extends HashSet<E> {

    @Override
    public boolean add(final E e) {

        return add0(e);
    }

    private boolean add0(final E e) {

        return super.add(e);
    }

    @Override
    public boolean addAll(final Collection<? extends E> c) {

        boolean modified = false;

        for (E e : c) {
            if (add0(e)) {
                modified = true;
            }
        }

        return modified;
    }
}


class MyNewSet<E> extends NewSet<E> {

    private int count;

    public int getCount() {
        return count;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        count += c.size();
        return super.addAll(c);
    }

    @Override
    public boolean add(E e) {
        count++;
        return super.add(e);
    }
}
