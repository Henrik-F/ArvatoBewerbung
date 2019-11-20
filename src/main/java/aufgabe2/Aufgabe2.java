package aufgabe2;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

class Aufgabe2 {

    String getMetaData(String jsonInput){
        Product[] productData = convertToObjects(jsonInput);
        String mostExpensiveProduct = getMostExpensiveProduct(productData);
        String cheapestProduct = getCheapestProduct(productData);
        String mostPopularProduct = getMostPopularProduct(productData);
        String[] germanProducts = getGermanProducts(productData);
        String[] chineseProducts = getChineseProducts(productData);
        boolean containsFragileProducts = getContainsFragileProducts(productData);

        MetaData metaData = new MetaData(mostExpensiveProduct, cheapestProduct, mostPopularProduct,
                germanProducts, chineseProducts, containsFragileProducts);

        Gson gson = new Gson();
        return gson.toJson(metaData);
    }

    String getMostExpensiveProduct(Product[] productData) {
        Product mostExpensiveProduct = productData[0];
        for (Product product : productData) {
            if(product.getPrice() > mostExpensiveProduct.getPrice()){
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct.getName();
    }

    String getCheapestProduct(Product[] productData) {
        Product cheapestProduct = productData[0];
        for (Product product : productData) {
            if(product.getPrice() < cheapestProduct.getPrice()){
                cheapestProduct = product;
            }
        }
        return cheapestProduct.getName();
    }

    String getMostPopularProduct(Product[] productData) {
        Product mostPopularProduct = productData[0];
        for (Product product : productData) {
            if(product.getTimesPurchased() > mostPopularProduct.getTimesPurchased()){
                mostPopularProduct = product;
            }
        }
        return mostPopularProduct.getName();
    }

    String[] getGermanProducts(Product[] productData) {
        List<String> germanProductsLlist = new ArrayList<>();
        for (Product product : productData) {
            if(product.getCountryofOrigin().equals("DE")){
                germanProductsLlist.add(product.getName());
            }
        }
        return germanProductsLlist.toArray(new String[0]);
    }

    String[] getChineseProducts(Product[] productData) {
        List<String> chineseProducts = new ArrayList<>();
        for (Product product : productData) {
            if(product.getCountryofOrigin().equals("CN")){
                chineseProducts.add(product.getName());
            }
        }
        return chineseProducts.toArray(new String[0]);
    }

    boolean getContainsFragileProducts(Product[] productData) {
        for (Product product : productData) {
            if(product.getIsFragile()){
                return true;
            }
        }
        return false;
    }

    Product[] convertToObjects(String jsonInput) {
        Gson gson = new Gson();
        return gson.fromJson(jsonInput, Product[].class);
    }
}

class Product {
    //This unpretty class in necessary for Gson to correctly convert to JSON
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

    @Override // This is only necessary for useful accessibility during testing
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Product product = (Product) o;
        return name.equals(product.name) &&
                countryofOrigin.equals(product.countryofOrigin) &&
                price == product.price &&
                isFragile == product.isFragile &&
                timesPurchased == product.timesPurchased;
    }


    Product(String name, String countryofOrigin, double price, boolean isFragile, int timesPurchased) {
        this.name = name;
        this.countryofOrigin = countryofOrigin;
        this.price = price;
        this.isFragile = isFragile;
        this.timesPurchased = timesPurchased;
    }
}

class MetaData{
    //This unpretty class in necessary for Gson to correctly convert to JSON
    private String mostExpensiveProduct;
    private String cheapestProduct;
    private String mostPopularProduct;
    private String[] germanProducts;
    private String[] chineseProducts;
    private boolean containsFragileProducts;

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
