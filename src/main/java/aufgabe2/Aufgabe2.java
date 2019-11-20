package aufgabe2;

import com.google.gson.Gson;

class Aufgabe2 {
    String getProductName(String jsonInput) {
        Gson gson = new Gson();
        ProductValues obj = gson.fromJson(jsonInput, ProductValues.class);
        String productName = obj.getName();
        System.out.println(productName);
        return productName;
    }
}
class ProductValues{
    private String name;
    private String countryofOrigin;
    private double price;
    private boolean isFragile;
    private int timesPurchased;

    String getName(){
        return name;
    }

    ProductValues(String name, String countryofOrigin, double price, boolean isFragile, int timesPurchased){
        this.name = name;
        this.countryofOrigin = countryofOrigin;
        this.price = price;
        this.isFragile = isFragile;
        this.timesPurchased = timesPurchased;
    }
}
