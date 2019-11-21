package aufgabe3;

import java.util.*;

class Aufgabe3 {

    List<Flea[]> combinationsOfLengthK = new ArrayList<>();

    int getOptimalValue(float money, List<Flea> fleas) {
        int res = 0;
        List<Flea[]> allCombinations = getAllCombinations(fleas);
        for (Flea[] possibleCombination : allCombinations) {
            int valueOfThisCombination = 0;
            float priceOfThisCombination = 0;
            for (Flea flea : possibleCombination) {
                valueOfThisCombination += flea.getRating();
                priceOfThisCombination += flea.getPrice();
            }
            if (priceOfThisCombination <= money && valueOfThisCombination > res) {
                res = valueOfThisCombination;
            }
        }
        return res;
    }

    List<Flea[]> getAllCombinations(List<Flea> fleas) {
        List<Flea[]> allCombinations = new ArrayList<>();

        for (int i = 1; i <= fleas.size(); i++) {
            getAllCombinationsWithKElements(fleas, i, 0, new Flea[i]);
            allCombinations.addAll(combinationsOfLengthK);
            combinationsOfLengthK.clear();
        }
        return allCombinations;
    }

    void getAllCombinationsWithKElements(List<Flea> fleas, int k, int start, Flea[] intermediateResult) {
        if (k == 0) {
            Flea[] oneCombination = new Flea[intermediateResult.length];
            System.arraycopy(intermediateResult, 0, oneCombination, 0, intermediateResult.length);
            combinationsOfLengthK.add(oneCombination);
            return;
        }
        for (int i = start; i <= fleas.size() - k; i++) {
            intermediateResult[intermediateResult.length - k] = fleas.get(i);
            getAllCombinationsWithKElements(fleas, k - 1, i + 1, intermediateResult);
        }
    }
}
