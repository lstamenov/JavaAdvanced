package ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterator<String>, Iterable<String>{
    int index;
    List<String> strings;

    ListIterator(String... strings){
        this.index = 0;
        this.strings = Arrays.asList(strings);
    }

    @Override
    public boolean hasNext() {
        return index < strings.size() - 1;
    }

    @Override
    public String next() {
        return strings.get(index);
    }

    public boolean move(){
        if (hasNext()){
            index++;
            return true;
        }else {
            return false;
        }
    }

    public void print(){
        if (strings.size() == 0){
            System.out.println("Invalid Operation!");
        }else {
            System.out.println(next());
        }
    }

    public void printAll(){
        System.out.println(String.join(" ", strings));
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }
}
