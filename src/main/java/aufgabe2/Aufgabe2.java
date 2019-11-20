package aufgabe2;

import com.google.gson.Gson;

class Aufgabe2 {

    ProductData[] convertToObjects(String jsonInput) {
        Gson gson = new Gson();
        ProductData[] objArray = gson.fromJson(jsonInput, ProductData[].class);

        for (ProductData obj : objArray) {
            System.out.println(obj.getName() + "\n" + obj.getCountryofOrigin() + "\n" + obj.getPrice() + "\n"
                    + obj.getIsFragile() + "\n" + obj.getTimesPurchased());
        }
        return objArray;
    }

    String getProductName(String jsonInput) {
        Gson gson = new Gson();
        ProductData obj = gson.fromJson(jsonInput, ProductData.class);
        String productName = obj.getName();
        System.out.println(productName);
        return productName;
    }

    double getProductPrice() {
        return 0.0;
    }

    int getTimesPurchased() {
        return 0;
    }

    boolean isGerman() {
/*        ProductValues thisProduct;
        if(thisProduct.getCountryofOrigin().equals("DE")){
            return true;
        }*/
        return false;
    }

    boolean isChinese() {
        return false;
    }

    boolean getIsFragile() {
        return false;
    }

}

class ProductData {
    private String name;
    private String countryofOrigin;
    private double price;
    private boolean isFragile;
    private int timesPurchased;

    String getName() {
        return name;
    }

    public String getCountryofOrigin() {
        return countryofOrigin;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsFragile() {
        return isFragile;
    }

    public int getTimesPurchased() {
        return timesPurchased;
    }

    ProductData(String name, String countryofOrigin, double price, boolean isFragile, int timesPurchased) {
        this.name = name;
        this.countryofOrigin = countryofOrigin;
        this.price = price;
        this.isFragile = isFragile;
        this.timesPurchased = timesPurchased;
    }
}
