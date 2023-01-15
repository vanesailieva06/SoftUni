package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Pet> getData() {
        return data;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }

    public void add(Pet pet){
        if (capacity > data.size()){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        Pet petToRemove = data.stream().filter(e -> e.getName().equals(name))
                .findAny().orElse(null);
        if (petToRemove != null){
            data.remove(petToRemove);
            return true;
        }
        return false;
    }
    public Pet getPet(String name,String owner){
        return data.stream().filter(e -> e.getName().equals(name))
                .findAny().orElse(null);
    }
    public Pet getOldestPet(){
        return data.stream().max(Comparator.comparingInt(Pet::getAge)).orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        //o	"The clinic has the following patients:
        //{name} {owner}
        //{name} {owner}
        //   (…)"
        String format = "The clinic has the following patients:";
        StringBuilder sb = new StringBuilder();
        sb.append(format);
        for (Pet pet : data) {
            sb.append(System.lineSeparator())
                    .append(pet);
        }
        return sb.toString();
    }
}
