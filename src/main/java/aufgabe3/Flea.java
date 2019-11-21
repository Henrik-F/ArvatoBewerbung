package aufgabe3;

import java.util.List;
import java.util.Objects;

public class Flea {
    String name;
    float price;
    int rating;
    public Flea(){}
    public Flea(final String name, final float price, final int rating){
        this.name = name;
        this.price = price;
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        if(!super.equals(object)) return false;
        Flea flea = (Flea) object;
        return name.equals(flea.name)&&
                price == flea.price&&
                rating == flea.rating;
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), name);
    }
}
