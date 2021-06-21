package ListUtilities;

import java.util.Comparator;
import java.util.List;

public class UtilityList<Type> {


    public static <Type extends Comparable<Type>> Type getMin(List<Type> list){
        return list.stream()
                .min(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new);
    }

    public static <Type extends Comparable<Type>> Type getMax(List<Type> list){
        return list.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(IllegalArgumentException::new);
    }
}
