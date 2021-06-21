package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator<T> {

    public static <T> T[] arr(int length, T item){
        Object arr = Array.newInstance(item.getClass(), length);
        return (T[]) arr;
    }
}
