package demo.domain;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Item {

    private String itemId = new ObjectId().toString();
    private String itemName;
    private double price;  // in dollars
    private String category;
    private boolean isFavorites = false; // default value is false
    private boolean isActive = true; // default value is true. used for soft deletion
    // private String description;
//    private String image; // image url


    public Item() {
    }

    public Item(String name, double price, String category) {
        this.itemName = name;
        this.price = price;
        this.category = category;
    }
}
