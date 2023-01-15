package Generics.GenericBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public List<T> getList() {
        list = new ArrayList<>();
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    public void add(T element){
        list.add(element);
    }

    public void swap(int firstIndex, int secondIndex){
        Collections.swap(list, firstIndex,secondIndex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : list) {
            sb.append(String.format("%s: %s%n",element.getClass().getName(),element));
        }
        return sb.toString();
    }
}
