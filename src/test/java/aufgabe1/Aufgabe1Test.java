package aufgabe1;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class Aufgabe1Test {

    @Test
    public void twoEmptyFiles_compareFilereturnEmtpyOutputLists() {
        File emptyList1 = new File("EmptyList1.txt");
        File emptyList2 = new File("EmtpyList2.txt");

        try {
            emptyList1.createNewFile();
            emptyList2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("{\"onlyInList1\":[],\"onlyInList2\":[],\"inBothLists\":[]}", new Aufgabe1()
                .compareFiles(emptyList1, emptyList2));
        emptyList1.deleteOnExit();
        emptyList2.deleteOnExit();
    }

    @Test
    public void firstListWithOneName_comareFilesReturnsOnlyThatName() {
        File oneWordList1 = new File("OneWordList1.txt");
        File emotylist2 = new File("EmptyList2.txt");

        try {
            oneWordList1.createNewFile();
            emotylist2.createNewFile();

            Writer writeList1 = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(oneWordList1)
                    , StandardCharsets.UTF_8)));
            writeList1.write("testName");
            writeList1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("{\"onlyInList1\":[\"testName\"],\"onlyInList2\":[],\"inBothLists\":[]}",
                new Aufgabe1().compareFiles(oneWordList1, emotylist2));
        oneWordList1.deleteOnExit();
        emotylist2.deleteOnExit();
    }
    @Test
    public void secondListWithOneName_comareFilesReturnsOnlyThatName() {
        File emptylist1 = new File("EmptyList1.txt");
        File oneWordList2 = new File("OneWordList2.txt");

        try {
            emptylist1.createNewFile();
            oneWordList2.createNewFile();

            Writer writeList2 = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(oneWordList2)
                    , StandardCharsets.UTF_8)));
            writeList2.write("testName");
            writeList2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("{\"onlyInList1\":[],\"onlyInList2\":[\"testName\"],\"inBothLists\":[]}",
                new Aufgabe1().compareFiles(emptylist1, oneWordList2));
        emptylist1.deleteOnExit();
        oneWordList2.deleteOnExit();
    }

    @Test
    public void twoListsWithSameName_comareFilesReturnsNameOnlyInBothLists() {
        File oneWordList1 = new File("OneWordList1.txt");
        File oneWordList2 = new File("OneWordList2.txt");

        try {
            oneWordList1.createNewFile();
            oneWordList2.createNewFile();

            Writer writeList1 = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(oneWordList1)
                    , StandardCharsets.UTF_8)));
            writeList1.write("testName");
            writeList1.close();
            Writer writeList2 = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(oneWordList2)
                    , StandardCharsets.UTF_8)));
            writeList2.write("testName");
            writeList2.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("{\"onlyInList1\":[],\"onlyInList2\":[],\"inBothLists\":[\"testName\"]}",
                new Aufgabe1().compareFiles(oneWordList1, oneWordList2));
        oneWordList1.deleteOnExit();
        oneWordList2.deleteOnExit();
    }

    @Test
    public void twoListsWithDifferentNames_comareFilesReturnsBothNames() {
        File oneWordList1 = new File("OneWordList1.txt");
        File otherWordList2 = new File("OtherWordList2.txt");

        try {
            oneWordList1.createNewFile();
            otherWordList2.createNewFile();

            Writer writeList1 = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(oneWordList1)
                    , StandardCharsets.UTF_8)));
            writeList1.write("testName");
            writeList1.close();
            Writer writeList2 = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(otherWordList2)
                    , StandardCharsets.UTF_8)));
            writeList2.write("otherName");
            writeList2.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("{\"onlyInList1\":[\"testName\"],\"onlyInList2\":[\"otherName\"],\"inBothLists\":[]}"
                , new Aufgabe1().compareFiles(oneWordList1, otherWordList2));
        oneWordList1.deleteOnExit();
        otherWordList2.deleteOnExit();
    }

    @Test
    public void twoListsWithSameAndDifferentNames_comareFilesReturnsSameAndDifferntNames() {
        File twoWordList1 = new File("TwoWordList1.txt");
        File twoWordList2 = new File("TwoWordList2.txt");

        try {
            twoWordList1.createNewFile();
            twoWordList2.createNewFile();

            Writer writeList1 = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(twoWordList1)
                    , StandardCharsets.UTF_8)));
            writeList1.write("testName\n");
            writeList1.append("asdf");
            writeList1.close();
            Writer writeList2 = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(twoWordList2)
                    , StandardCharsets.UTF_8)));
            writeList2.write("otherName\n");
            writeList2.append("testName");

            writeList2.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("{\"onlyInList1\":[\"asdf\"],\"onlyInList2\":[\"otherName\"],\"inBothLists\":[\"testName\"]}",
                new Aufgabe1().compareFiles(twoWordList1, twoWordList2));
        twoWordList1.deleteOnExit();
        twoWordList2.deleteOnExit();
    }
    @Test
    public void twoListsWithManySameAndDifferentNames_comareFilesReturnsSameAndDifferntNames() {
        File fiveWordList1 = new File("FiveWordList1.txt");
        File fiveWordList2 = new File("FiveWordList2.txt");

        try {
            fiveWordList1.createNewFile();
            fiveWordList2.createNewFile();

            Writer writeList1 = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(fiveWordList1)
                    , StandardCharsets.UTF_8)));
            writeList1.write("testName\n");
            writeList1.append("name1\n");
            writeList1.append("name2\n");
            writeList1.append("name3\n");
            writeList1.append("name4\n");
            writeList1.close();
            Writer writeList2 = new BufferedWriter((new OutputStreamWriter(new FileOutputStream(fiveWordList2)
                    , StandardCharsets.UTF_8)));
            writeList2.write("otherName\n");
            writeList2.append("name1\n");
            writeList2.append("name2\n");
            writeList2.append("name5\n");
            writeList2.append("name6\n");

            writeList2.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("{\"onlyInList1\":[\"testName\",\"name3\",\"name4\"],\"onlyInList2\":[\"otherName\",\"name5\",\"name6\"],\"inBothLists\":[\"name1\",\"name2\"]}",
                new Aufgabe1().compareFiles(fiveWordList1, fiveWordList2));
        fiveWordList1.deleteOnExit();
        fiveWordList2.deleteOnExit();
    }

    @Test
    public void convertToJson_NoInputShouldReturnStringWithFieldNameButWithoutContent() {
        assertEquals("{\"onlyInList1\":[],\"onlyInList2\":[],\"inBothLists\":[]}",
                new Aufgabe1().convertToJson(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
    }

    @Test
    public void convertToJson_twoInputsForEachListShouldReturnBothNamesInEachList() {
        assertEquals("{\"onlyInList1\":[\"asdf\",\"name1\"],\"onlyInList2\":[\"otherName\",\"name2\"]," +
                        "\"inBothLists\":[\"testName\",\"name3\"]}",
                new Aufgabe1().convertToJson(Arrays.asList("asdf", "name1"), Arrays.asList("otherName", "name2"),
                        Arrays.asList("testName", "name3")));
    }

}
