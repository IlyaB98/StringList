import org.example.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class ListTests {

    private List list = new List(3);
    private String string1;
    private String string2;
    private String string3;

    @BeforeEach
    public void setUp() {
        string1 = "String 1";
        string2 = "String 2";
        string3 = "String 3";
    }

    @Test
    public void addInList() {
        list.add(string1);
        list.add(string2);
        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    public void addInListByIndex() {
        list.add(0, string1);
        list.add(1, string2);
        list.add(1, string3);
        Assertions.assertEquals(list.size(), 3);
    }

    @Test
    public void setInListByIndex() {
        list.set(1, string1);
        list.set(2, string2);
        list.set(2, string3);
        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    public void remove() {

        list.add(string1);
        list.add(string2);
        list.add(string3);
        list.remove(string1);
        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    public void removeByIndex() {
        list.add(string1);
        list.add(string2);
        list.add(string3);
        list.remove(1);
        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    public void contains() {
        list.add(string1);
        list.add(string2);
        list.add(string3);

//        Assertions.assertEquals(list.contains(string1), true);
        Assertions.assertEquals(list.contains("string4"), false);
    }

    @Test
    public void indexOf() {
        list.add(string1);
        list.add(string2);
        list.add(string3);

        Assertions.assertEquals(list.indexOf(string1), 0);
//        Assertions.assertEquals(list.indexOf("string4"), -1);
    }

    @Test
    public void lastIndexOf() {
        list.add(string1);
        list.add(string2);
        list.add(string3);

//        Assertions.assertEquals(list.indexOf(string1), 0);
        Assertions.assertEquals(list.indexOf("string4"), -1);
    }

    @Test
    public void get() {
        list.add(string1);
        list.add(string2);
        list.add(string3);

        Assertions.assertEquals(list.get(1), string2);
    }

    @Test
    public void equals() {
        List list2 = new List(3);
        list2.add(string1);
        list2.add(string2);
        list2.add(string3);

        list.add(string1);
        list.add(string2);
        list.add(string3);

        Assertions.assertEquals(list.equals(list2), true);
    }

    @Test
    public void size() {
        list.add(string1);
        list.add(string2);
        list.add(string3);

        Assertions.assertEquals(list.size(), 3);
    }

    @Test
    public void isEmpty() {
        list.add(string1);

        Assertions.assertEquals(list.isEmpty(), false);
    }

    @Test
    public void clear() {
        list.add(string1);
        list.clear();
        Assertions.assertEquals(list.size(), 0);
    }

    @Test
    public void toArray() {
        String[] strings = {string1};
        list.add(string1);
        Assertions.assertEquals(Arrays.equals(strings, list.toArray()), true);
    }
}
