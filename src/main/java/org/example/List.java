package org.example;

import org.example.exception.ArgumentNullException;
import org.example.exception.ElementNotFoundException;
import org.example.exception.InvalidArrayLengthException;

import java.util.Arrays;

public class List implements StringList {
    private int lengthArray;
    private String[] strings;

    public List(int lengthArray) {
        setLengthArray(lengthArray);
        strings = new String[lengthArray];
    }

    @Override
    public String add(String item) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == null) {
                strings[i] = item;
                return strings[i];
            }
        }
        return "Массив заполнен";
    }

    @Override
    public String add(int index, String item) {
        if (index < strings.length && strings[index] == null) {
            strings[index] = item;
            return strings[index];
        } else if (index < strings.length && strings[index] != null) {
            for (int i = strings.length - 1; i >= index; i++) {
                String oldString = strings[index];
                strings[index] = item;
                for (int j = 0; j < strings.length; j++) {
                    if (strings[j] == null) {
                        strings[j] = oldString;
                    }
                }
            }
            strings[index] = item;
            return strings[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы фактического количества элементов");
        }
    }

    @Override
    public String set(int index, String item) {
        if (index < strings.length) {
            strings[index] = item;
            return "Новая строка : " + strings[index] + ", записана под индексом " + index;
        } else {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы фактического количества элементов");
        }
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(item)) {
                String oldString = strings[i];
                strings[i] = null;
                return "Строка: " + oldString + ", удалена";
            }
        }
        throw new ElementNotFoundException("Элемент отсутствует в списке");
    }

    @Override
    public String remove(int index) {
        if (index < strings.length) {
            String oldString = strings[index];
            strings[index] = null;
            return "Строка: " + oldString + ", удалена";
        } else {
            throw new ElementNotFoundException("Элемент отсутствует в списке");
        }
    }

    @Override
    public boolean contains(String item) {
        for (String string : strings) {
            if (string == null) {
                continue;
            }
            if (string.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i] == null) {
                continue;
            }
            if (strings[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < strings.length) {
            return strings[index];
        } else {
            throw new IndexOutOfBoundsException("Индекс выходит за рамки фактического количества элементов");
        }
    }

    @Override
    public boolean equals(StringList[] otherList) {
        if (otherList == null) {
            throw new ArgumentNullException();
        }
        return strings.length == otherList.length && Arrays.equals(strings, otherList);
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (String str : strings) {
            if (str != null) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    @Override
    public void clear() {
        Arrays.fill(strings, null);
    }

    @Override
    public String[] toArray() {
        String[] newStrings = new String[this.size()];

        int counter = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                newStrings[counter] = strings[i];
                counter++;
            }
        }
        return newStrings;
    }

    public int getLengthArray() {
        return lengthArray;
    }

    public void setLengthArray(int lengthArray) {
        if (lengthArray > 0) {
            this.lengthArray = lengthArray;
        } else {
            throw new InvalidArrayLengthException("Длинна массива не может быть меньше или равна 0");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List list = (List) o;
        return Arrays.equals(strings, list.strings);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(strings);
    }
}
