package aufgabe2;

import com.google.gson.Gson;

class Aufgabe2 {

    ProductData[] convertToObjects(String jsonInput) {
        Gson gson = new Gson();
        ProductData[] objArray = gson.fromJson(jsonInput, ProductData[].class);
        return objArray;
    }

    String getProductName(String jsonInput) {
        Gson gson = new Gson();
        ProductData obj = gson.fromJson(jsonInput, ProductData.class);
        String productName = obj.getName();
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

    String getCountryofOrigin() {
        return countryofOrigin;
    }

    double getPrice() {
        return price;
    }

    boolean getIsFragile() {
        return isFragile;
    }

    int getTimesPurchased() {
        return timesPurchased;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        ProductData productData = (ProductData) o;
        return name.equals(productData.name) &&
                countryofOrigin.equals(productData.countryofOrigin) &&
                price == productData.price &&
                isFragile == productData.isFragile &&
                timesPurchased == productData.timesPurchased;
    }


    ProductData(String name, String countryofOrigin, double price, boolean isFragile, int timesPurchased) {
        this.name = name;
        this.countryofOrigin = countryofOrigin;
        this.price = price;
        this.isFragile = isFragile;
        this.timesPurchased = timesPurchased;
    }
}
