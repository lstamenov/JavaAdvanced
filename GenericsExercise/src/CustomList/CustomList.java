package CustomList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomLIst<Type extends Comparable<Type>> {
    List<Type> elements;

    CustomLIst(){
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
}
