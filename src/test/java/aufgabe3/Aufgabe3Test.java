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
        assertEquals(10, Aufgabe3.getOptimalValue(5, fleas));
    }

    @Test
    public void twoFleasWithHigherPriceAsMoney_ReturnsZero() {
        List<Flea> fleas = Arrays.asList(new Flea("flea1", 5, 10), new Flea("flea1", 5, 9));
        assertEquals(0, Aufgabe3.getOptimalValue(0, fleas));
    }

    @Test
    public void twoFleasWithEnoughMoneyForBoth_ReturnsCombinedRatings() {
        List<Flea> fleas = Arrays.asList(new Flea("flea1", 5, 10), new Flea("flea1", 5, 9));
        assertEquals(19, Aufgabe3.getOptimalValue(10, fleas));
    }

    @Test
    public void helperMethodFaculty_ShouldWorkProperlyWithLongs() {
        assertEquals(1, Aufgabe3.faculty(0));
        assertEquals(1, Aufgabe3.faculty(1));
        assertEquals(6, Aufgabe3.faculty(3));
        assertEquals(24, Aufgabe3.faculty(4));
        assertEquals(479001600, Aufgabe3.faculty(12));
        assertEquals(121645100408832000L, Aufgabe3.faculty(19));
    }

    @Test
    public void numberOfPossibleCombinations_ReturnsSumOfBinomialCoefficients() {
        assertEquals(1, new Aufgabe3().numberOfPossibleCombinations(1));
        assertEquals(3, new Aufgabe3().numberOfPossibleCombinations(2));
        assertEquals(7, new Aufgabe3().numberOfPossibleCombinations(3));
        assertEquals(511, new Aufgabe3().numberOfPossibleCombinations(9));
    }

    @Test
    public void getCombinationsNOverK_ForKEquals1() {
        Flea flea1 = new Flea("flea1", 5, 10);
        Flea flea2 =  new Flea("flea1", 5, 9);
        Flea flea3 = new Flea("flea3", 5, 10);

        List<Flea> fleas = Arrays.asList(flea1, flea2, flea3);

        List<Flea[]> expected = new ArrayList<>();
        expected.add(new Flea[]{flea1});
        expected.add(new Flea[]{flea2});
        expected.add(new Flea[]{flea3});

        assertArrayEquals(expected.toArray(),
                new Aufgabe3().getCombinationsNOverK(fleas, 1).toArray());
    }

    @Test
    public void getCombinationsNOverK_ForKEqualsN() {
        Flea flea1 = new Flea("flea1", 5, 10);
        Flea flea2 =  new Flea("flea1", 5, 9);
        Flea flea3 = new Flea("flea3", 5, 10);

        List<Flea> fleas = Arrays.asList(flea1, flea2, flea3);

        List<Flea[]> expected = new ArrayList<>();
        expected.add(new Flea[]{flea1, flea2, flea3});

        assertArrayEquals(expected.toArray(),
                new Aufgabe3().getCombinationsNOverK(fleas, 3).toArray());
    }

    @Test
    public void getCombinationsNOverK_For2OutOf3() {
        Flea flea1 = new Flea("flea1", 5, 10);
        Flea flea2 =  new Flea("flea1", 5, 9);
        Flea flea3 = new Flea("flea3", 5, 10);

        List<Flea> fleas = Arrays.asList(flea1, flea2, flea3);

        List<Flea[]> expected = new ArrayList<>();
        expected.add(new Flea[]{flea1, flea2});
        expected.add(new Flea[]{flea1, flea3});
        expected.add(new Flea[]{flea2, flea3});

        assertArrayEquals(expected.toArray(),
                new Aufgabe3().getCombinationsNOverK(fleas, 2).toArray());
    }
    @Test
    public void getCombinationsNOverK_For3OutOf4() {
        Flea flea1 = new Flea("flea1", 5, 10);
        Flea flea2 =  new Flea("flea1", 5, 9);
        Flea flea3 = new Flea("flea3", 5, 10);
        Flea flea4 = new Flea("flea4", 5, 10);

        List<Flea> fleas = Arrays.asList(flea1, flea2, flea3, flea4);

        List<Flea[]> expected = new ArrayList<>();
        expected.add(new Flea[]{flea1, flea2, flea3});
        expected.add(new Flea[]{flea1, flea2, flea4});
        expected.add(new Flea[]{flea1, flea3, flea4});
        expected.add(new Flea[]{flea2, flea3, flea4});

        assertArrayEquals(expected.toArray(),
                new Aufgabe3().getCombinationsNOverK(fleas, 3).toArray());
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
}