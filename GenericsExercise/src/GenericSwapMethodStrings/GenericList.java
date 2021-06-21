package GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class GenericList<Type> {
    private List<Type> list;

    GenericList(){
        this.list = new ArrayList<>();
    }

    public void add(Type element){
        this.list.add(element);
    }

    public List<Type> getList() {
        return list;
    }

    public void swap(int fIndex, int sIndex){
        Type temp = list.get(fIndex);
        list.set(fIndex, list.get(sIndex));
        list.set(sIndex, temp);
    }
}
