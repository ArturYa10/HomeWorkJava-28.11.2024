import java.util.*;

public class MyArrayList<T> implements Iterable<T> {
    private final List<T> data;

    public MyArrayList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        data.add(element);
    }

    public T get(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException();
        }
        return data.get(index);
    }

    public int size() {
        return data.size();
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator(); // Стандартный итератор для списка
    }

    public Iterable<T> reverse() {
        return () -> new Iterator<>() {
            private int index = data.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data.get(index--);
            }
        };
    }

    public Iterable<T> random() {
        return () -> new Iterator<>() {
            private final List<T> shuffled = new ArrayList<>(data);
            private int index = 0;

            {
                Collections.shuffle(shuffled);
            }

            @Override
            public boolean hasNext() {
                return index < shuffled.size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return shuffled.get(index++);
            }
        };
    }
}
