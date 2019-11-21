package aufgabe3;

import java.util.*;

public class Aufgabe3 {

    List<Flea[]> nOverKCombinations = new ArrayList<>();

    /*    public static int getOptimalValue(float money, List<Flea> fleas){
            int res = 0;
            for (Flea flea : fleas) {
                if(money >= flea.getPrice()){
                    res += flea.getRating();
                    money -= flea.getPrice();
                }
            }
            return res;
        }*/
    public static int getOptimalValue(float money, List<Flea> fleas) {
        Map fleasByValuePerPrice = new HashMap();
        for (Flea flea : fleas) {
            double valueByPrice = flea.getRating() / flea.getPrice();
            fleasByValuePerPrice.put(flea, valueByPrice);
        }
        int res = 0;
        for (Flea flea : fleas) {
            if (money >= flea.getPrice()) {
                res += flea.getRating();
                money -= flea.getPrice();
            }
        }
        return res;
    }

    public List<Flea[]> getAllCombinations(List<Flea> fleas) {
        //TODO get all combinations n over n (1) and n over k (for 0 < k < n)
        List<Flea[]> allCombinations = new ArrayList<>();
        //add All Single fleas
        for (int i = 1; i <= fleas.size(); i++) {
            getCombinationsNOverK(fleas, i);
        }
        for (Flea[] fleaArr : allCombinations) {
            System.out.println("Combination:");
            for (Flea flea : fleaArr) {
                System.out.println(flea.getName());
            }
        }

        return allCombinations;
    }

    List<Flea[]> getCombinationsNOverK(List<Flea> fleas, int k) {
        List<Flea[]> combinations = new ArrayList<>();

        if (fleas.size() == k) {
            combinations.add(fleas.toArray(new Flea[0]));
            return combinations;
        }
        if (k == 1) {
            for (Flea flea : fleas) {
                combinations.add(new Flea[]{flea});
            }
            return combinations;
        }
        if (k == 2) {
            for (int i = 0; i < fleas.size(); i++) {
                for (int j = 0; j < fleas.size(); j++) {
                    if (j > i) {
                        combinations.add(new Flea[]{fleas.get(i), fleas.get(j)});
                    }
                }
            }
        }
        if (k == 3) {
            for (int i = 0; i < fleas.size(); i++) {
                for (int j = 0; j < fleas.size(); j++) {
                    for (int l = 0; l < fleas.size(); l++) {
                        if (j > i && l > j) {
                            combinations.add(new Flea[]{fleas.get(i), fleas.get(j), fleas.get(l)});
                        }
                    }
                }
            }
        }

        return combinations;
    }

    void combinationsNOverK(List<Flea> fleas, int k, int start, Flea[] result) {
        int counter = 1;
        if (k == 0) {
            nOverKCombinations.add(result);
            System.out.println("Combination No.: " + counter++);
            for (Flea flea : result) {
                System.out.println(flea.getName());
            }
            return;
        }
        for (int i = start; i <= fleas.size()-k; i++) {
            result[result.length-k] = fleas.get(i);
            combinationsNOverK(fleas, k-1, i+1, result);
        }
    }

    int numberOfPossibleCombinations(int numberOfFleas) {
        int possibleCombinations = 0;
        for (int i = 1; i <= numberOfFleas; i++) {
            possibleCombinations += binomialCoefficient(numberOfFleas, i);
        }
        return possibleCombinations;
    }

    static long binomialCoefficient(int n, int k) {
        return faculty(n) / (faculty(k) * faculty(n - k));
    }

    static long faculty(long n) {
        long result = 1L;
        for (long i = 1L; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}
