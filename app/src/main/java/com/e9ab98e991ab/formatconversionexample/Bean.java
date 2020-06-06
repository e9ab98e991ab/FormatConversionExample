package com.e9ab98e991ab.formatconversionexample;

import java.io.Serializable;
import java.util.Arrays;
public class Bean implements Serializable {
    /**
     * array : [1,2,3]
     * isBoolean : true
     * number : 123
     * object : {"a":"b","c":"d"}
     * string : Hello World
     */

    private boolean isBoolean;
    private int number = 1;
    private ObjectBean object;
    private String string ="Hello World";
    private int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public boolean isIsBoolean() {
        return isBoolean;
    }

    public void setIsBoolean(boolean isBoolean) {
        this.isBoolean = isBoolean;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public static class ObjectBean {

        private String a ="a";
        private String c ="c";

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "ObjectBean{" +
                    "a='" + a + '\'' +
                    ", c='" + c + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Bean{" +
                "isBoolean=" + isBoolean +
                ", number=" + number +
                ", object=" + object +
                ", string='" + string + '\'' +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
