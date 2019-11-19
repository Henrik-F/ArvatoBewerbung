package aufgabe1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Aufgabe1 {

    String[] compareFiles(File list1, File list2) {
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
            String[] output = {"'onlyInList1': " + onlyInList1.toString(), "'onlyInList2': "
                    + onlyInList2.toString(), "'inBothLists': " + inBothLists.toString()};

            return output;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
