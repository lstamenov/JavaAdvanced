package GenericScale;

class Scale<T extends Comparable<T>> implements Comparable<Scale<T>>{

    @Override
    public int compareTo(Scale<T> o) {
        return 0;
    }

    public T getHeavier(T left, T right){
        if (left.compareTo(right) > 0){
            return left;
        }else if (left.compareTo(right) < 0) {
            return right;
        }else {
            return null;
        }
    }
}
