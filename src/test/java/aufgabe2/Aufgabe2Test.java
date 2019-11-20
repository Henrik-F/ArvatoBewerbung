package aufgabe2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Aufgabe2Test {

    @Test
    public void convertingjsonInputToObjectArray_twoObjectsNotEmpty() {
        String jsonInput = "[{\"name\":\"product1\"," +
                "\"countryofOrigin\":\"DE\"," +
                "\"price\":5.50," +
                "\"isFragile\":false," +
                "\"timesPurchased\":10}," +
                "{\"name\":\"product2\"," +
                "\"countryofOrigin\":\"DE\"," +
                "\"price\":7.50," +
                "\"isFragile\":true," +
                "\"timesPurchased\":20}]";
        Product product1 = new Product("product1", "DE", 5.50, false,
                10);
        Product product2 = new Product("product2", "DE", 7.50, true,
                20);

        assertArrayEquals(new Product[]{product1, product2}, new Aufgabe2().convertToObjects(jsonInput));
    }

    @Test
    public void getMostExpensiveProduct_TwoProductsOnlyDifferByNameAndPrice() {
        Product[] productData = {new Product("product1", "DE", 5.50, false, 0),
        new Product("product2", "DE", 4.50, false, 0)};

        assertEquals("product1", new Aufgabe2().getMostExpensiveProduct(productData));
    }


    @Test
    public void getCheapestProduct_TwoProductsOnlyDifferByNameAndPrice() {
        Product[] productData = {new Product("product1", "DE", 5.50, false, 0),
        new Product("product2", "DE", 4.50, false, 0)};

        assertEquals("product2", new Aufgabe2().getCheapestProduct(productData));
    }

    @Test
    public void getMostPopularProduct_TwoProductsOnlyDifferByNameAndTimesPurchased() {
        Product[] productData = {new Product("product1", "DE", 5.50, false, 10),
        new Product("product2", "DE", 5.50, false, 5)};

        assertEquals("product1", new Aufgabe2().getMostPopularProduct(productData));
    }

    @Test
    public void getGermanProducts_NoGermanProductsUsed() {
        Product[] productData = {new Product("product1", "AD", 5.50, false, 0),
        new Product("product2", "AE", 5.50, false, 0)};

       assertArrayEquals(new String[]{}, new Aufgabe2().getGermanProducts(productData));
    }

    @Test
    public void getGermanProducts_TwoOutOfThreeAreGerman() {
        Product[] productData = {new Product("product1", "DE", 5.50, false, 0),
        new Product("product2", "AE", 5.50, false, 0),
                new Product("product3", "DE", 10.99, false, 0)};

       assertArrayEquals(new String[]{"product1", "product3"}, new Aufgabe2().getGermanProducts(productData));
    }

    @Test
    public void getChineseProducts_NoChineseProductsUsed() {
        Product[] productData = {new Product("product1", "DE", 5.50, false, 0),
        new Product("product2", "AE", 5.50, false, 0),
                new Product("product3", "DE", 10.99, false, 0)};

       assertArrayEquals(new String[]{}, new Aufgabe2().getChineseProducts(productData));
    }

    @Test
    public void getChineseProducts_TwoOutOfThreeAreChinese() {
        Product[] productData = {new Product("product1", "DE", 5.50, false, 0),
        new Product("product2", "CN", 5.50, false, 0),
                new Product("product3", "CN", 10.99, false, 0)};

       assertArrayEquals(new String[]{"product2", "product3"}, new Aufgabe2().getChineseProducts(productData));
    }

    @Test
    public void getContainsFragileProducts_ShouldBeFalse() {
        Product[] productData = {new Product("product1", "DE", 5.50, false, 0),
        new Product("product2", "CN", 5.50, false, 0),
                new Product("product3", "CN", 10.99, false, 0)};

       assertFalse(new Aufgabe2().getContainsFragileProducts(productData));
    }

    @Test
    public void getContainsFragileProducts_ShouldBeTrue() {
        Product[] productData = {new Product("product1", "DE", 5.50, false, 0),
        new Product("product2", "CN", 5.50, true, 0),
                new Product("product3", "CN", 10.99, false, 0)};

       assertTrue(new Aufgabe2().getContainsFragileProducts(productData));
    }

    @Test
    public void getMetaData_returnsAllDataInJsonReadableFormat() {
        String jsonInput = "[{\"name\":\"product1\"," +
                "\"countryofOrigin\":\"DE\"," +
                "\"price\":5.50," +
                "\"isFragile\":false," +
                "\"timesPurchased\":10}," +
                "{\"name\":\"product2\"," +
                "\"countryofOrigin\":\"DE\"," +
                "\"price\":8.00," +
                "\"isFragile\":false," +
                "\"timesPurchased\":100}," +
                "{\"name\":\"product3\"," +
                "\"countryofOrigin\":\"CN\"," +
                "\"price\":7.50," +
                "\"isFragile\":true," +
                "\"timesPurchased\":20}]";
        String expectedOutput = "{\"mostExpensiveProduct\":\"product2\"," +
                "\"cheapestProduct\":\"product1\"," +
                "\"mostPopularProduct\":\"product2\"," +
                "\"germanProducts\":[\"product1\",\"product2\"]," +
                "\"chineseProducts\":[\"product3\"]," +
                "\"containsFragileProducts\":true}";
        assertEquals(expectedOutput, new Aufgabe2().getMetaData(jsonInput));
    }
}
