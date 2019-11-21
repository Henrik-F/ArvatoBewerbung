package aufgabe1;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Aufgabe1 {

    String compareFiles(File list1, File list2) {
        try {
            BufferedReader readList1 = new BufferedReader(new FileReader(list1));
            BufferedReader readList2 = new BufferedReader(new FileReader(list2));

        List<String> namesOfList1 = getNamesOfList(list1);
        List<String> namesOfList2 = getNamesOfList(list2);

        List<String> onlyInList1 = namesThatAreOnlyInFirstList(namesOfList1, namesOfList2);
        List<String> onlyInList2 = namesThatAreOnlyInFirstList(namesOfList2, namesOfList1);
        namesOfList1.removeAll(onlyInList1);

        return convertToJson(onlyInList1, onlyInList2, namesOfList1);
    }

    List<String> getNamesOfList(File list) throws IOException {
        BufferedReader listReader = new BufferedReader(new FileReader(list));

        List<String> namesOfList = new ArrayList<>();
        String currentLine = listReader.readLine();
        while (currentLine != null) {
            namesOfList.add(currentLine);
            currentLine = listReader.readLine();
        }
        return namesOfList;
    }

    List<String> namesThatAreOnlyInFirstList(List<String> namesOfFirstList, List<String> namesOfSecondList) {
        List<String> onlyInFirstList = new ArrayList<>();
        for (String nameInFirstList : namesOfFirstList) {
            boolean isOnlyInFirstList = true;
            for (String nameInSecondList : namesOfSecondList) {
                if (nameInFirstList.equals(nameInSecondList)) {
                    isOnlyInFirstList = false;
                    break;
                }
            }
            if (isOnlyInFirstList) {
                onlyInFirstList.add(nameInFirstList);
            }
        }
        return onlyInFirstList;
    }

    String convertToJson(List<String> onlyInList1, List<String> onlyInList2, List<String> inBothLists) {
        ComparedWordsObj comparedWords = new ComparedWordsObj(onlyInList1.toArray(new String[0]),
                onlyInList2.toArray(new String[0]), inBothLists.toArray(new String[0]));

        Gson gson = new Gson();
        return gson.toJson(comparedWords);
    }
}

class ComparedWordsObj {
    private String[] onlyInList1;
    private String[] onlyInList2;
    private String[] inBothLists;

    ComparedWordsObj(String[] onlyInList1, String[] onlyInList2, String[] inBothLists) {
        this.onlyInList1 = onlyInList1;
        this.onlyInList2 = onlyInList2;
        this.inBothLists = inBothLists;
    }
}
