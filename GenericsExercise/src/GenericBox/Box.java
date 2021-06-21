package GenericBox;

public class Box<T> {

    public void getElementClass(T element){
        System.out.printf("%s: %s",element.getClass(), element);
    }

}
