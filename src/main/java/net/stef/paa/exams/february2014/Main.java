package net.stef.paa.exams.february2014;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        final List<String> l = new LinkedList<>();
        try {
            final File myObj = new File(args[0]);
            final Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                l.add(myReader.nextLine());
            }
            Collections.sort(l);
            for (int i = 0 ; i < l.size(); i++) {
                String word = l.get(i);
                int[] bitArray = createBitArray(word);
                System.out.print(word + " ");
                for (int j = 0; j < l.size(); ++j){
                    if(i != j){
                        final String wordToCompare = l.get(j);
                        if(Arrays.equals(bitArray, createBitArray(wordToCompare))){
                            System.out.print(wordToCompare + " ");
                        }
                    }
                }
                System.out.println();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static int[] createBitArray(final String s){
        final int[] letterCount = new int[26];
        for(int i = 0; i < s.length(); ++i){
            letterCount[s.toLowerCase().charAt(i) - 97]++;
        }
        return letterCount;
    }

}
