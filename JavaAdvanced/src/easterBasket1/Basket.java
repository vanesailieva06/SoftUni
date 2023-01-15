package easterBasket1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Egg> getData() {
        return data;
    }

    public void setData(List<Egg> data) {
        this.data = data;
    }
    //•	List<Egg> data - collection that holds added eggs
    //•	Method addEgg(Egg egg) – adds an entity to the data if there is room for it
    //•	Method removeEgg(string color) – removes an egg by given color, if such exists, and returns boolean (true if it is removed, otherwise – false)
    //•	Method getStrongestEgg()– returns the strongest egg
    //•	Method getEgg(string color) – returns the egg with the given color
    //•	Method getCount – returns the number of eggs
    //•	Method report() – returns a string in the following format (print the eggs in order of appearance):
    public void addEgg(Egg egg){
        if (data.size() < capacity){
            data.add(egg);
        }
    }
    public boolean removeEgg(String color){
        Egg eggToRemove = data.stream().filter(e -> e.getColor().equals(color))
                .findFirst().orElse(null);
        if (eggToRemove != null){
            data.remove(eggToRemove);
            return true;
        }
        return false;
    }
    public Egg getStrongestEgg(){
        return data.stream().max(Comparator.comparingInt(Egg::getStrength)).get();
    }
    public Egg getEgg(String color){
        return data.stream().filter(e -> e.getColor().equals(color))
                .findFirst().orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String report(){
        //o	"{material} basket contains:
        //{Egg1}
        //{Egg2}
        //(…)"
        String format = String.format("%s basket contains:%n",material);
        StringBuilder sb = new StringBuilder();
        sb.append(format);
        for (Egg egg : data) {
            sb.append(egg).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
