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

        ProductData[] objArray = new Aufgabe2().convertToObjects(jsonInput);
        for (ProductData obj : objArray) {
            System.out.println(obj.getName() + "\n" + obj.getCountryofOrigin() + "\n" + obj.getPrice() + "\n"
                    + obj.getIsFragile() + "\n" + obj.getTimesPurchased());
        }
        // assertArrayEquals(new ProductData[]{obj1, obj2}, new Aufgabe2().convertToObjects(jsonInput));
        assertEquals(obj1, new Aufgabe2().convertToObjects(jsonInput)[0]);

    }


}