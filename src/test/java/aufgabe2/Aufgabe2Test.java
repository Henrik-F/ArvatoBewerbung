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


}