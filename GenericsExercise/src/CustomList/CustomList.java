package CustomList;

import java.util.*;
import java.util.function.Consumer;

public class CustomList<Type extends Comparable<Type>> implements Iterable<Type> {
    List<Type> elements;

    CustomList(){
        this.elements = new ArrayList<>();
    }

    public void add(Type element){
        this.elements.add(element);
    }

    public void remove(int index){
        this.elements.remove(index);
    }

    public boolean contains(Type element){
        return this.elements.contains(element);
    }

    public void swap(int fIndex, int sIndex){
        Type temp = this.elements.get(fIndex);
        this.elements.set(fIndex, elements.get(sIndex));
        elements.set(sIndex, temp);
    }

    public int countGreaterThan(Type element){
        int counter = 0;
        for (Type t : elements) {
            if (t.compareTo(element) > 0){
                counter++;
            }
        }
        return counter;
    }

    public Type getMax(){
        return elements.stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    public Type getMin(){
        return elements.stream()
                .min(Comparator.naturalOrder())
                .get();
    }

    public void print(){
        Iterator<Type> iteratorList = elements.listIterator();
        while (iteratorList.hasNext()){
            System.out.println(iteratorList.next());
        }
    }

    public void sort(){
        Collections.sort(elements);
    }

    @Override
    public Iterator<Type> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Type> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Type> spliterator() {
        return Iterable.super.spliterator();
    }
}
