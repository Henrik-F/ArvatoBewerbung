package aufgabe2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Aufgabe2Test {
    @Test
    public void parsingEmtpyProductNameOutOfEmptyJSON() {
        String jsonInput = "{\"name\":\"\"," +
                "\"countryofOrigin\":\"\"," +
                "\"price\":0," +
                "\"isFragile\":false," +
                "\"timesPurchased\":0}";
        assertEquals("", new Aufgabe2().getProductName(jsonInput));
    }

    @Test
    public void parsingProductnameOutOfJSON() {
        String jsonInput = "{\"name\":\"product1\"," +
                "\"countryofOrigin\":\"\"," +
                "\"price\":0," +
                "\"isFragile\":false," +
                "\"timesPurchased\":0}";
        assertEquals("product1", new Aufgabe2().getProductName(jsonInput));
    }

    @Test
    public void convertingjsonInputToObjectArray_twoObjectsNotEmpty() {
        String jsonInput = "[{\"name\":\"asdf\"," +
                "\"countryofOrigin\":\"DE\"," +
                "\"price\":5.50," +
                "\"isFragile\":false," +
                "\"timesPurchased\":10}," +
                "{\"name\":\"product1\"," +
                "\"countryofOrigin\":\"DE\"," +
                "\"price\":7.50," +
                "\"isFragile\":true," +
                "\"timesPurchased\":20}]";
        ProductData obj1 = new ProductData("asdf", "DE", 5.50, false,
                10);
        ProductData obj2 = new ProductData("product1", "DE", 7.50, true,
                20);

        assertArrayEquals(new ProductData[]{obj1, obj2}, new Aufgabe2().convertToObjects(jsonInput));
    }

    @Test
    public void getMostExpensiveProduct_TwoProductsOnlyDifferByNameAndPrice() {
        ProductData[] productDates = {new ProductData("product1", "DE", 5.50, false, 0),
        new ProductData("product2", "DE", 4.50, false, 0)};

        assertEquals("product1", new Aufgabe2().getMostExpensiveProduct(productDates));
    }


    @Test
    public void getCheapestProduct_TwoProductsOnlyDifferByNameAndPrice() {
        ProductData[] productDates = {new ProductData("product1", "DE", 5.50, false, 0),
        new ProductData("product2", "DE", 4.50, false, 0)};

        assertEquals("product2", new Aufgabe2().getCheapestProduct(productDates));
    }

    @Test
    public void getMostPopularProduct_TwoProductsOnlyDifferByNameAndTimesPurchased() {
        ProductData[] productDates = {new ProductData("product1", "DE", 5.50, false, 10),
        new ProductData("product2", "DE", 5.50, false, 5)};

        assertEquals("product1", new Aufgabe2().getMostPopularProduct(productDates));
    }

    @Test
    public void getGermanProducts_NoGermanProductsUsed() {
        ProductData[] productDates = {new ProductData("product1", "AD", 5.50, false, 0),
        new ProductData("product2", "AE", 5.50, false, 0)};

       assertArrayEquals(new String[]{}, new Aufgabe2().getGermanProducts(productDates));
    }

    @Test
    public void getGermanProducts_TwoOutOfThreeAreGerman() {
        ProductData[] productDates = {new ProductData("product1", "DE", 5.50, false, 0),
        new ProductData("product2", "AE", 5.50, false, 0),
                new ProductData("product3", "DE", 10.99, false, 0)};

       assertArrayEquals(new String[]{"product1", "product3"}, new Aufgabe2().getGermanProducts(productDates));
    }

    @Test
    public void getChineseProducts_NoChineseProductsUsed() {
        ProductData[] productDates = {new ProductData("product1", "DE", 5.50, false, 0),
        new ProductData("product2", "AE", 5.50, false, 0),
                new ProductData("product3", "DE", 10.99, false, 0)};

       assertArrayEquals(new String[]{}, new Aufgabe2().getChineseProducts(productDates));
    }

    @Test
    public void getChineseProducts_TwoOutOfThreeAreChinese() {
        ProductData[] productDates = {new ProductData("product1", "DE", 5.50, false, 0),
        new ProductData("product2", "CN", 5.50, false, 0),
                new ProductData("product3", "CN", 10.99, false, 0)};

       assertArrayEquals(new String[]{"product2", "product3"}, new Aufgabe2().getChineseProducts(productDates));
    }

    @Test
    public void getContainsFragileProducts_ShouldBeFalse() {
        ProductData[] productDates = {new ProductData("product1", "DE", 5.50, false, 0),
        new ProductData("product2", "CN", 5.50, false, 0),
                new ProductData("product3", "CN", 10.99, false, 0)};

       assertFalse(new Aufgabe2().getContainsFragileProducts(productDates));
    }

    @Test
    public void getContainsFragileProducts_ShouldBeTrue() {
        ProductData[] productDates = {new ProductData("product1", "DE", 5.50, false, 0),
        new ProductData("product2", "CN", 5.50, true, 0),
                new ProductData("product3", "CN", 10.99, false, 0)};

       assertTrue(new Aufgabe2().getContainsFragileProducts(productDates));
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