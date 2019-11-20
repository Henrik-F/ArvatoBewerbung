package aufgabe1;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Aufgabe1Test {
    private File list1 = new File("List1.txt");
    private File list2 = new File("List2.txt");
    private Writer list1Writer = new FileWriter("List1.txt");
    private Writer list2Writer = new FileWriter("List2.txt");

    public Aufgabe1Test() throws IOException {
    }

    @Before
    public void init() throws IOException {
        list1.createNewFile();
        list2.createNewFile();
        list1Writer.write("");
        list2Writer.write("");
    }

    @After
    public void tearDown() throws IOException {
        list1Writer.close();
        list2Writer.close();
        list1.delete();
        list2.delete();
    }

    @Test
    public void getNameOfList_ReturnsListWithOneName() throws IOException {
        list1Writer.write("name1");
        list1Writer.close();
        assertArrayEquals(new String[]{"name1"}, new Aufgabe1().getNamesOfList(list1).toArray());
    }

    @Test
    public void getNameOfList_ReturnsListWithThreeNames() throws IOException {
        list1Writer.write("name1\n");
        list1Writer.append("name2\n");
        list1Writer.append("name3");
        list1Writer.close();
        assertArrayEquals(new String[]{"name1", "name2", "name3"}, new Aufgabe1().getNamesOfList(list1).toArray());
    }

    @Test
    public void namesThatAreOnlyInFirstList_ReturnsOneName() {
        List<String> namesOfFirstList = Arrays.asList("name1", "name2");
        List<String> namesOfSecondList = Arrays.asList("name1");
        assertArrayEquals(new String[]{"name2"},
                new Aufgabe1().namesThatAreOnlyInFirstList(namesOfFirstList, namesOfSecondList).toArray());
    }

    @Test
    public void twoEmptyFiles_compareFileReturnsEmtpyOutputLists() throws IOException {

        String expectedJSON = "{\"onlyInList1\":[],\"onlyInList2\":[],\"inBothLists\":[]}";

        assertEquals(expectedJSON, new Aufgabe1().compareFiles(list1, list2));
    }

    @Test
    public void firstListWithOneName_compareFilesReturnsOnlyThatName() throws IOException {

        list1Writer.write("testName");
        list1Writer.close();

        String expectedJSON = "{\"onlyInList1\":[\"testName\"],\"onlyInList2\":[],\"inBothLists\":[]}";

        assertEquals(expectedJSON, new Aufgabe1().compareFiles(list1, list2));
    }

    @Test
    public void secondListWithOneName_compareFilesReturnsOnlyThatName() throws IOException {

        list2Writer.write("testName");
        list2Writer.close();

        String expectedJSON = "{\"onlyInList1\":[],\"onlyInList2\":[\"testName\"],\"inBothLists\":[]}";

        assertEquals(expectedJSON, new Aufgabe1().compareFiles(list1, list2));
    }

    @Test
    public void twoListsWithSameName_compareFilesReturnsNameOnlyInBothLists() throws IOException {

        list1Writer.write("testName");
        list1Writer.close();
        list2Writer.write("testName");
        list2Writer.close();

        String expectedJSON = "{\"onlyInList1\":[],\"onlyInList2\":[],\"inBothLists\":[\"testName\"]}";

        assertEquals(expectedJSON, new Aufgabe1().compareFiles(list1, list2));
    }

    @Test
    public void twoListsWithDifferentNames_comareFilesReturnsBothNames() throws IOException {

        list1Writer.write("testName");
        list1Writer.close();
        list2Writer.write("otherName");
        list2Writer.close();

        String expectedJSON = "{\"onlyInList1\":[\"testName\"],\"onlyInList2\":[\"otherName\"],\"inBothLists\":[]}";

        assertEquals(expectedJSON, new Aufgabe1().compareFiles(list1, list2));
    }

    @Test
    public void twoListsWithSameAndDifferentNames_compareFilesReturnsSameAndDifferntNames() throws IOException {

        list1Writer.write("testName\n");
        list1Writer.append("asdf");
        list1Writer.close();

        list2Writer.write("otherName\n");
        list2Writer.append("testName");
        list2Writer.close();


        String expectedJSON = "{\"onlyInList1\":[\"asdf\"],\"onlyInList2\":[\"otherName\"]," +
                "\"inBothLists\":[\"testName\"]}";

        assertEquals(expectedJSON, new Aufgabe1().compareFiles(list1, list2));
    }

    @Test
    public void twoListsWithManySameAndDifferentNames_compareFilesReturnsSameAndDifferntNames() throws IOException {

        list1Writer.write("testName\n");
        list1Writer.append("name1\n");
        list1Writer.append("name2\n");
        list1Writer.append("name3\n");
        list1Writer.append("name4\n");
        list1Writer.close();

        list2Writer.write("otherName\n");
        list2Writer.append("name1\n");
        list2Writer.append("name2\n");
        list2Writer.append("name5\n");
        list2Writer.append("name6\n");
        list2Writer.close();


        String expectedJSON = "{\"onlyInList1\":[\"testName\",\"name3\",\"name4\"],\"onlyInList2\":[\"otherName\"," +
                "\"name5\",\"name6\"],\"inBothLists\":[\"name1\",\"name2\"]}";

        assertEquals(expectedJSON, new Aufgabe1().compareFiles(list1, list2));
    }

    @Test
    public void convertToJson_NoInput_ShouldReturnJsonWithFieldNamesWithoutContent() {
        assertEquals("{\"onlyInList1\":[],\"onlyInList2\":[],\"inBothLists\":[]}",
                new Aufgabe1().convertToJson(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));
    }

    @Test
    public void convertToJson_twoInputsForEachList_ShouldReturnBothNamesInEachList() {
        assertEquals("{\"onlyInList1\":[\"asdf\",\"name1\"],\"onlyInList2\":[\"otherName\",\"name2\"]," +
                        "\"inBothLists\":[\"testName\",\"name3\"]}",
                new Aufgabe1().convertToJson(Arrays.asList("asdf", "name1"), Arrays.asList("otherName", "name2"),
                        Arrays.asList("testName", "name3")));
    }

}
