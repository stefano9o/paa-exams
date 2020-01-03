package net.stef.paa.exams.february2016;

import net.stef.paa.exams.datastructures.ClientDissimilarityPair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<List<Integer>> store = new ArrayList<>();
    private static int client;

    public static void main(String[] args){
        if(args.length != 1){
            throw new RuntimeException("You must specify one and only one parameter.");
        }

        parseInputFile(args[0]);

        List<ClientDissimilarityPair> pairs = new ArrayList<>();
        for (int i = 0; i < store.size(); i++) {
            if(i != client){
                pairs.add(new ClientDissimilarityPair(i, dissimilarityFunction(client, i)));
            }
        }

        pairs.sort((o1, o2) -> o1.getDissimilarity() - o2.getDissimilarity());
        for (final ClientDissimilarityPair pair : pairs){
            System.out.println(pair);
        }
    }

    private static void parseInputFile(final String pathInputFile) {
        try {
            final File f = new File(pathInputFile);
            final Scanner fileScanner = new Scanner(f);
            client = Integer.parseInt(fileScanner.nextLine().trim()) - 1;

            int i = 0;
            while (fileScanner.hasNextLine()) {
                store.add(new ArrayList<>());
                final String currentLine = fileScanner.nextLine();
                final String[] splitLine = currentLine.split(",");
                for (final String split : splitLine) {
                    store.get(i).add(Integer.parseInt(split.trim()));
                }
                ++i;
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static int dissimilarityFunction(final int client1, final int client2) {
        int accumulator = 0;
        for (int i = 0; i < store.get(client1).size(); i++) {
            accumulator += Math.abs(store.get(client1).get(i) - store.get(client2).get(i));
        }
        return accumulator;
    }

}
