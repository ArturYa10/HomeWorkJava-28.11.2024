import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Normal:");
        for (Integer value : list) { // Работает, так как MyArrayList реализует Iterable
            System.out.println(value);
        }

        System.out.println("Reverse:");
        for (Integer value : list.reverse()) {
            System.out.println(value);
        }

        System.out.println("Random:");
        for (Integer value : list.random()) {
            System.out.println(value);
        }
    }
}
