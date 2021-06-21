package ArrayListImplementation;

public class SmartArray {
    private int[] elements;
    private int size;

    SmartArray(){
        this.elements = new int[4];
        this.size = 0;
    }

    public void add(int number){
        if (elements.length == size){
            elements = grow();
        }
        elements[size] = number;
        size++;
    }

    public void add(int number, int index){
        if (index == size){
            elements = grow();
        }
        validateIndex(index);
        for (int i = size; i >= index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = number;
        size++;
    }

    public void remove(int index){
        validateIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public int get(int index){
        validateIndex(index);
        return elements[index];
    }

    private int[] grow() {
        int[] newArray = new int[size * 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        return newArray;
    }

    private void validateIndex(int index){
        if (index >= size){
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        }
    }
}
