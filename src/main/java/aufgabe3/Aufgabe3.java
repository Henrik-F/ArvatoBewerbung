package aufgabe3;

import java.util.*;

public class Aufgabe3 {

    List<Flea[]> nOverKCombinations = new ArrayList<>();

    int getOptimalValue(float money, List<Flea> fleas) {
        List<Flea[]> allCombinations = getAllCombinations(fleas);
        int res = 0;
        for (Flea[] fleaArr : allCombinations) {
            int valueOfThisArray = 0;
            float priceOfThisArray = 0;
            for (Flea flea : fleaArr) {
                valueOfThisArray += flea.getRating();
                priceOfThisArray += flea.getPrice();
            }
            if(priceOfThisArray <= money && valueOfThisArray > res){
                res = valueOfThisArray;
            }
        }
        return res;
    }

    List<Flea[]> getAllCombinations(List<Flea> fleas) {
        //TODO get all combinations n over n (1) and n over k (for 0 < k < n)
        List<Flea[]> allCombinations = new ArrayList<>();

        for (int i = 1; i <= fleas.size(); i++) {
            combinationsNOverK(fleas, i, 0, new Flea[i]);
            allCombinations.addAll(nOverKCombinations);
            nOverKCombinations.clear();
        }
        for (Flea[] fleaArr : allCombinations) {
            System.out.println("Combination:");
            for (Flea flea : fleaArr) {
                System.out.println(flea.getName());
            }
        }

        return allCombinations;
    }

    void combinationsNOverK(List<Flea> fleas, int k, int start, Flea[] intermediateResult) {
        if (k == 0) {
            Flea[] oneCombination = new Flea[intermediateResult.length];
            System.arraycopy(intermediateResult, 0, oneCombination, 0, intermediateResult.length);
            nOverKCombinations.add(oneCombination);
            return;
        }
        for (int i = start; i <= fleas.size() - k; i++) {
            intermediateResult[intermediateResult.length - k] = fleas.get(i);
            combinationsNOverK(fleas, k - 1, i + 1, intermediateResult);
        }
    }

}
