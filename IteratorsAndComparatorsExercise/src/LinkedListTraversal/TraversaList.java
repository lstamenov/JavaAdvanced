package LinkedListTraversal;

import java.util.Iterator;

public class TraversaList implements Iterable<Integer>{
    private int[] elements;
    private int size;
    private int index;

    TraversaList(){
        this.elements = new int[4];
        this.size = 0;
        this.index = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int element){
        if (size < elements.length){
            elements[size++] = element;
        }else {
            elements = grow(element);
        }
    }

    public void remove(int index){
        if (index < size && index >= 0){
            if (size - 1 - index >= 0) System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
            size--;
        }else {
            remove(String.valueOf(index));
        }
    }

    public void remove(String numAsString){
        int number = Integer.parseInt(numAsString);
        for (int i = 0; i < size; i++) {
            if (elements[i] == number){
                remove(i);
                break;
            }
        }
    }

    private int[] grow(int element) {
        int[] newElements = new int[size * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[size] = element;
        return newElements;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator();
    }

    class ListIterator implements Iterator<Integer>{

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Integer next() {
            return elements[index++];
        }
    }
}
