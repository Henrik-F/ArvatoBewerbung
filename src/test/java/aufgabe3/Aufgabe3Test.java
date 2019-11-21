package aufgabe3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Aufgabe3Test {
    @Test
    public void twoFleasWithSamePriceAsMoney_ReturnsValueOfHigherRating() {
        List<Flea> fleas = Arrays.asList(new Flea("flea1", 5, 10), new Flea("flea1", 5, 9));
        assertEquals(10, new Aufgabe3().getOptimalValue(5, fleas));
    }

    @Test
    public void twoFleasWithHigherPriceAsMoney_ReturnsZero() {
        List<Flea> fleas = Arrays.asList(new Flea("flea1", 5, 10), new Flea("flea1", 5, 9));
        assertEquals(0, new Aufgabe3().getOptimalValue(0, fleas));
    }

    @Test
    public void twoFleasWithEnoughMoneyForBoth_ReturnsCombinedRatings() {
        List<Flea> fleas = Arrays.asList(new Flea("flea1", 5, 10), new Flea("flea1", 5, 9));
        assertEquals(19, new Aufgabe3().getOptimalValue(10, fleas));
    }

    @Test
    public void blablaDeleteLater() {
        Flea flea1 = new Flea("flea1", 5, 10);
        Flea flea2 =  new Flea("flea2", 5, 9);
        Flea flea3 = new Flea("flea3", 5, 10);
        Flea flea4 = new Flea("flea4", 5, 10);

        List<Flea> fleas = Arrays.asList(flea1, flea2, flea3, flea4);

        List<Flea[]> expected = new ArrayList<>();
        expected.add(new Flea[]{flea1, flea2, flea3});
        expected.add(new Flea[]{flea1, flea2, flea4});
        expected.add(new Flea[]{flea1, flea3, flea4});
        expected.add(new Flea[]{flea2, flea3, flea4});

        Aufgabe3 aufgabe3 = new Aufgabe3();

        aufgabe3.combinationsNOverK(fleas, 3, 0, new Flea[3]);

        for (Flea[] fleaArr : aufgabe3.nOverKCombinations) {
            System.out.println("Array:");
            for (Flea flea : fleaArr) {
                System.out.println(flea.getName());

            }
        }

        assertArrayEquals(expected.toArray(), aufgabe3.nOverKCombinations.toArray());
    }

    @Test
    public void createAllPossibleCombinationsOfFleasRegardlessMoney() {
        Flea flea1 = new Flea("flea1", 5, 10);
        Flea flea2 =  new Flea("flea1", 5, 9);
        Flea flea3 = new Flea("flea3", 5, 10);

        List<Flea> fleas = Arrays.asList(flea1, flea2, flea3);
        List<Flea[]> expected = new ArrayList<>();
        expected.add(new Flea[]{flea1});
        expected.add(new Flea[]{flea2});
        expected.add(new Flea[]{flea3});
        expected.add(new Flea[]{flea1, flea2});
        expected.add(new Flea[]{flea1, flea3});
        expected.add(new Flea[]{flea2, flea3});
        expected.add(new Flea[]{flea1, flea2, flea3});

        assertArrayEquals(expected.toArray(), new Aufgabe3().getAllCombinations(fleas).toArray());
    }

    @Test
    public void getOptimalValue_EnoughMoneyForAll() {
        Flea flea1 = new Flea("flea1", 1, 3);
        Flea flea2 = new Flea("flea1", 5.25f, 5);
        List<Flea> fleas = Arrays.asList(flea1, flea2);

        assertEquals(8, new Aufgabe3().getOptimalValue(20, fleas));
    }

    @Test
    public void getOptimalValue_NoMoney_ShoudReturnZero() {
        Flea flea1 = new Flea("flea1", 1, 3);
        Flea flea2 = new Flea("flea1", 5.25f, 5);
        List<Flea> fleas = Arrays.asList(flea1, flea2);

        assertEquals(0, new Aufgabe3().getOptimalValue(0, fleas));
    }


}