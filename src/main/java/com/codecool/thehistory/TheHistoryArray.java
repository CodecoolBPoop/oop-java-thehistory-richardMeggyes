package com.codecool.thehistory;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static jdk.nashorn.internal.objects.NativeString.indexOf;
import static jdk.nashorn.internal.runtime.ScriptObject.getCount;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
//       MÉZI 261ms
//        String[] textToArray = text.split("\\s+");
//        String[] unitedArray = new String[this.size() + textToArray.length];
//        System.arraycopy(this.wordsArray, 0, unitedArray, 0, this.size());
//        System.arraycopy(textToArray, 0, unitedArray, this.size(), textToArray.length);
//        this.wordsArray = unitedArray;

        this.wordsArray = text.split(" "); // 140ms
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
//MÉZI 479ms
//        int position = indexOf(this.wordsArray, wordToBeRemoved);
//        while (position > -1) {
//            String[] newWordsArray = new String[size() - 1];
//            System.arraycopy(this.wordsArray, 0, newWordsArray, 0, position);
//            System.arraycopy(this.wordsArray, position + 1, newWordsArray, position,
//                    newWordsArray.length - position);
//            this.wordsArray = newWordsArray;
//            position = indexOf(this.wordsArray, wordToBeRemoved);
//        }

        // 63-41ms
        ArrayList<String> copy = new ArrayList<String>();
        for (int x = 0; x < this.wordsArray.length; x++) {
            if (this.wordsArray[x] != wordToBeRemoved) {
                copy.add(this.wordsArray[x]);
            }
        }
        this.wordsArray = copy.toArray(new String[0]);

//        System.out.println("REMOVEWORD");
//        Object[] objArray = { this.wordsArray };
//        ArrayList<String> copy = new ArrayList<String>();
//        ListIterator<Object> listIterator = Arrays.asList(objArray).listIterator(objArray.length);
//        while (listIterator.hasNext()) {
//            System.out.println("WHILE");
//            Object object = listIterator.next();
//            System.out.println(object.toString());
//            if (object.toString() != wordToBeRemoved){
//                copy.add(object.toString());
//            }
//        }
//        this.wordsArray = copy.toArray(new String[0]);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return this.wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        this.wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        System.out.println("REPLACE_ONE " + from + " " + to);
        for (int i = 0; i < this.size(); i++) {
//            System.out.println(this.wordsArray[i]);
            if (this.wordsArray[i].equals(from)) {
                System.out.println("OLD VAL: "+this.wordsArray[i]);
                this.wordsArray[i] = to;
                System.out.println("NEW VAL: "+this.wordsArray[i]);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
