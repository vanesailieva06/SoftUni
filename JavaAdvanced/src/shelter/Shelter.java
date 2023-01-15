package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

     public void add(Animal animal){
        if (this.data.size() < this.capacity){
            this.data.add(animal);
        }
     }
     public boolean remove(String name){
        Animal removedAnimal = this.data.stream().filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
        if (removedAnimal != null){
            this.data.remove(removedAnimal);
            return true;
        }
        return false;
     }
     public Animal getAnimal(String name, String caretaker){
        return this.data.stream().filter(e -> e.getName().equals(name)).filter(e -> e.getCaretaker().equals(caretaker))
                .findFirst().orElse(null);
     }
     public Animal getOldestAnimal(){
        return this.data.stream().max(Comparator.comparingInt(Animal::getAge)).orElse(null);
     }
     public int getCount(){
        return this.data.size();
     }
     public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        String format = "The shelter has the following animals:";
        sb.append(format);
         for (Animal animal : this.data) {
             sb.append(System.lineSeparator()).append(animal.getName()).append(" ").append(animal.getCaretaker());
         }
         return sb.toString().trim();
     }
}
