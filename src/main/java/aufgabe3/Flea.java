package aufgabe3;

import java.util.Objects;

class Flea {
    private String name;
    private float price;
    private int rating;

    Flea(final String name, final float price, final int rating){
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    float getPrice() {
        return price;
    }

    int getRating() {
        return rating;
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
