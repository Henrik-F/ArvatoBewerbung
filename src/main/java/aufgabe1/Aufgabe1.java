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

            List<String> list1Content = new ArrayList<>();
            String currentLine = readList1.readLine();
            while (currentLine != null) {
                list1Content.add(currentLine);
                currentLine = readList1.readLine();
            }

            List<String> list2Content = new ArrayList<>();
            currentLine = readList2.readLine();
            while (currentLine != null) {
                list2Content.add(currentLine);
                currentLine = readList2.readLine();
            }

            List<String> onlyInList1 = new ArrayList<>();
            List<String> onlyInList2;
            List<String> inBothLists = new ArrayList<>();

            for (String nameInList1 : list1Content) {
                boolean isOnlyInList1 = true;
                for (String nameInList2 : list2Content) {
                    if (nameInList1.equals(nameInList2) && !inBothLists.contains(nameInList1)) {
                        inBothLists.add(nameInList1);
                        isOnlyInList1 = false;
                    }
                }
                if (isOnlyInList1) {
                    onlyInList1.add(nameInList1);
                }
            }
            list2Content.removeAll(inBothLists);
            onlyInList2 = list2Content;

            return convertToJson(onlyInList1, onlyInList2, inBothLists);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String convertToJson(List<String> onlyInList1, List<String> onlyInList2, List<String> inBothLists) {
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

    ComparedWordsObj(String[] onlyInList1, String[] onlyInList2, String[] inBothLists){
        this.onlyInList1 = onlyInList1;
        this.onlyInList2 = onlyInList2;
        this.inBothLists = inBothLists;
    }
}
