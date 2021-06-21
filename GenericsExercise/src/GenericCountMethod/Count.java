package GenericCountMethod;

import java.util.ArrayList;
import java.util.List;

public class Count<Type extends Comparable<Type>> implements Comparable<Count> {
    List<Type> elements;
    Count(){
        this.elements = new ArrayList<>();
    }
    public int countElements(Type element){
        int count = 0;
        for (Type t : elements) {
            if (t.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }

    @Override
    public int compareTo(Count o) {
        return 0;
    }

    public void add(Type element){
        this.elements.add(element);
    }
}
