package Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    int[] stones;
    int index = 0;

    public class Frog implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            if (isEvenIndex()){
                return true;
            }else {
                return index <= stones.length - 1;
            }
        }

        @Override
        public Integer next() {
            if (index > stones.length - 1 && isEvenIndex()){
                index = 1;
            }
            int n = stones[index];
            index +=2;
            return n;
        }
    }

    Lake(int[] nums){
        this.stones = nums;
    }

    boolean isEvenIndex(){
        return index % 2 == 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
}
