package StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StackIterator implements Iterable<Integer>{
    List<Integer> elements;

    StackIterator(){
        this.elements = new ArrayList<>();
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
