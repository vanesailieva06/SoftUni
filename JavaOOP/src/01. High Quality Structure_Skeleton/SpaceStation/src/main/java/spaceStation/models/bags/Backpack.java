package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Backpack implements Bag {

    private List<String> items;

    public Backpack() {
        items = new ArrayList<>();
    }

    @Override
    public List<String> getItems() {
        return items;
    }


   @Override
    public void setItems(List<String> items) {
        this.items = items;
    }
}
