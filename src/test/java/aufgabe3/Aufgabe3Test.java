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
    public void getAllCombinationsWithKElements_OneElementOutOfThree() {
        Flea flea1 = new Flea("flea1", 5, 10);
        Flea flea2 =  new Flea("flea2", 5, 9);
        Flea flea3 = new Flea("flea3", 5, 10);

        List<Flea> fleas = Arrays.asList(flea1, flea2, flea3);

        List<Flea[]> expected = new ArrayList<>();
        expected.add(new Flea[]{flea1});
        expected.add(new Flea[]{flea2});
        expected.add(new Flea[]{flea3});

        Aufgabe3 aufgabe3 = new Aufgabe3();

        aufgabe3.getAllCombinationsWithKElements(fleas, 1, 0, new Flea[1]);

        assertArrayEquals(expected.toArray(), aufgabe3.combinationsOfLengthK.toArray());
    }
    @Test
    public void getAllCombinationsWithKElements_ThreeElementsOutOfFour() {
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

        aufgabe3.getAllCombinationsWithKElements(fleas, 3, 0, new Flea[3]);

        assertArrayEquals(expected.toArray(), aufgabe3.combinationsOfLengthK.toArray());
    }

    @Test
    public void getAllCombinations_TwoElements() {
        Flea flea1 = new Flea("flea1", 5, 10);
        Flea flea2 = new Flea("flea2", 5, 9);

        List<Flea> fleas = Arrays.asList(flea1, flea2);

        List<Flea[]> expected = new ArrayList<>();
        expected.add(new Flea[]{flea1});
        expected.add(new Flea[]{flea2});
        expected.add(new Flea[]{flea1, flea2});

        assertArrayEquals(expected.toArray(), new Aufgabe3().getAllCombinations(fleas).toArray());
    }

    @Test
    public void getAllCombinations_ThreeElements() {
        Flea flea1 = new Flea("flea1", 5, 10);
        Flea flea2 = new Flea("flea2", 5, 9);
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
    public void getOptimalValue_NoMoney_ShouldReturnZero() {
        Flea flea1 = new Flea("flea1", 1, 3);
        Flea flea2 = new Flea("flea1", 5.25f, 5);
        List<Flea> fleas = Arrays.asList(flea1, flea2);

        assertEquals(0, new Aufgabe3().getOptimalValue(0, fleas));
    }

    @Test
    public void getOptimalValue_ManyPossibilities() {
        Flea flea1 = new Flea("flea1", 1, 3);
        Flea flea2 = new Flea("flea2", 5.50f, 5);
        Flea flea3 = new Flea("flea3", 5.99f, 7);
        Flea flea4 = new Flea("flea4", 5.25f, 6);
        Flea flea5 = new Flea("flea5", 8, 9);
        Flea flea6 = new Flea("flea6", 4, 5);
        Flea flea7 = new Flea("flea7", 7.80f, 8);

        List<Flea> fleas = Arrays.asList(flea1, flea2, flea3, flea4, flea5, flea6, flea7);

        assertEquals(24, new Aufgabe3().getOptimalValue(20, fleas));
    }
}