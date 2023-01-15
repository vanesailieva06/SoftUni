package Generics.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>>{
    private List<T> list;

    public CustomList() {
        list = new ArrayList<>();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    //•	void add(T element)
    //•	T remove(int index)
    //•	boolean contains(T element)
    //•	void swap(int index, int index)
    //•	int countGreaterThan(T element)
    //•	T getMax()
    //•	T getMin()
    public  void add(T element){
        list.add(element);
    }
    public T remove(int index){
        return list.remove(index);
    }
    public boolean contains(T element){
        return list.contains(element);
    }
    public void swap(int firstIndex, int secondIndex){
        Collections.swap(list,firstIndex,secondIndex);
    }
    public int countGreaterThan(T element){
        return (int) list.stream().filter(existingElement -> existingElement.compareTo(element) > 0)
                .count();
    }
    public T getMax(){
        return list.stream().max(Comparable::compareTo).get();
    }
    public T getMin(){
        return list.stream().min(Comparable::compareTo).get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : list) {
            sb.append(value).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

