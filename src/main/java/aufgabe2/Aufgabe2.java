package aufgabe2;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

class Aufgabe2 {

    String getMetaData(String jsonInput){
        ProductData[] productDates = convertToObjects(jsonInput);
        String mostExpensiveProduct = getMostExpensiveProduct(productDates);
        String cheapestProduct = getCheapestProduct(productDates);
        String mostPopularProduct = getMostPopularProduct(productDates);
        String[] germanProducts = getGermanProducts(productDates);
        String[] chineseProducts = getChineseProducts(productDates);
        boolean containsFragileProducts = getContainsFragileProducts(productDates);

        MetaData metaData = new MetaData(mostExpensiveProduct, cheapestProduct, mostPopularProduct,
                germanProducts, chineseProducts, containsFragileProducts);

        Gson gson = new Gson();
        return gson.toJson(metaData);
    }

    String getMostExpensiveProduct(ProductData[] productDates) {
        ProductData mostExpensiveProduct = productDates[0];
        for (ProductData product : productDates) {
            if(product.getPrice() > mostExpensiveProduct.getPrice()){
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct.getName();
    }

    String getCheapestProduct(ProductData[] productDates) {
        ProductData cheapestProduct = productDates[0];
        for (ProductData product : productDates) {
            if(product.getPrice() < cheapestProduct.getPrice()){
                cheapestProduct = product;
            }
        }
        return cheapestProduct.getName();
    }

    String getMostPopularProduct(ProductData[] productDates) {
        ProductData mostPopularProduct = productDates[0];
        for (ProductData product : productDates) {
            if(product.getTimesPurchased() > mostPopularProduct.getTimesPurchased()){
                mostPopularProduct = product;
            }
        }
        return mostPopularProduct.getName();
    }

    String[] getGermanProducts(ProductData[] productDates) {
        List<String> germanProductsLlist = new ArrayList<>();
        for (ProductData product : productDates) {
            if(product.getCountryofOrigin().equals("DE")){
                germanProductsLlist.add(product.getName());
            }
        }
        return germanProductsLlist.toArray(new String[0]);
    }

    String[] getChineseProducts(ProductData[] productDates) {
        List<String> chineseProducts = new ArrayList<>();
        for (ProductData product : productDates) {
            if(product.getCountryofOrigin().equals("CN")){
                chineseProducts.add(product.getName());
            }
        }
        return chineseProducts.toArray(new String[0]);
    }

    boolean getContainsFragileProducts(ProductData[] productDates) {
        for (ProductData product : productDates) {
            if(product.getIsFragile()){
                return true;
            }
        }
        return false;
    }

    ProductData[] convertToObjects(String jsonInput) {
        Gson gson = new Gson();
        ProductData[] objArray = gson.fromJson(jsonInput, ProductData[].class);
        return objArray;
    }

    String getProductName(String jsonInput) {
        Gson gson = new Gson();
        ProductData obj = gson.fromJson(jsonInput, ProductData.class);
        return obj.getName();
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

class MetaData{
    String mostExpensiveProduct;
    String cheapestProduct;
    String mostPopularProduct;
    String[] germanProducts;
    String[] chineseProducts;
    boolean containsFragileProducts;

    MetaData(String mostExpensiveProduct, String cheapestProduct, String mostPopularProduct,
            String[] germanProducts, String[] chineseProducts,
             boolean containsFragileProducts){
        this.mostExpensiveProduct = mostExpensiveProduct;
        this.cheapestProduct = cheapestProduct;
        this.mostPopularProduct = mostPopularProduct;
        this.germanProducts = germanProducts;
        this.chineseProducts = chineseProducts;
        this.containsFragileProducts = containsFragileProducts;
    }
}
