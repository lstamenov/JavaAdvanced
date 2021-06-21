package StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StackIterable implements Iterable<Integer>{
    List<Integer> elements;
    int index;
    StackIterable(){
        this.elements = new ArrayList<>();
        this.index = 0;
    }

    public void push(int[] elements) {
        for (int n : elements) {
            this.elements.add(n);
        }
    }

    public Integer pop(){
        if (iterator().hasNext()) {
            return elements.remove(elements.size() - 1);
        }else {
            System.out.println("No elements");
        }
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        index = 0;
        return new StackIterator();
    }

    public class StackIterator implements Iterator<Integer> {


        @Override
        public boolean hasNext() {
            return index < elements.size();
        }

        @Override
        public Integer next() {
            return elements.get(index++);
        }
    }
}
