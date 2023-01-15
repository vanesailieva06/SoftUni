package Workshop;

import java.util.function.Consumer;

public class SmartArray {
    private int[]data;
    private int capacity;
    private  int size;

    public SmartArray() {
        data = new int[4];
        capacity = data.length;
    }
    public int remove(int index){
        check(index);
        int removedElement = data[index];
        shift(index);
        size--;
        if (size <= capacity / 4){
            shrink();
        }
        return removedElement;
    }
    public boolean contains(int element){
        for (int i = 0; i < size; i++) {
           if (data[i] == element){
               return true;
           }
        }
        return false;
    }
    public void add(int index,int element){
        check(index);
        if (index == size - 1){
            add(data[size - 1]);
            data[size - 2] = element;
        }else{
            size++;
            shiftRight(index);
            data[index] = element;
        }
    }
    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(data[i]);
        }
    }

    public void add(int element){
        if (size == capacity){
            resize();
        }
        data[size++] = element;
    }
    public int get(int index){
        check(index);
        return data[index];
    }

    private void check(int index) {
        if (index < 0 || index >= size){
            String exceptions = String.format("Index %d out of bounds length %d",index,size);
            throw new IndexOutOfBoundsException(exceptions);
        }
    }

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[this.capacity];
        System.arraycopy(data, 0, newArr, 0, data.length);
        data = newArr;
    }
    private void shift(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = 0;
    }
    private void shrink() {
        capacity /= 2;
        int[] arr = new int[capacity];
        if (size >= 0) System.arraycopy(data, 0, arr, 0, size);
        data = arr;
    }
    private void shiftRight(int index) {
        for (int i = size - 1; i > index; i--) {
            data[i] = data[i - 1];
        }
    }

}
