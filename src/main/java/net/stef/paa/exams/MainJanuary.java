package net.stef.paa.exams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainJanuary {
    public static void main(String[] args){
        if(args.length != 1){
            throw new RuntimeException("You must specify one and only one parameter.");
        }
        final List<String> l = new LinkedList<String>();
        try {
            final File f = new File(args[0]);
            final Scanner fileScanner = new Scanner(f);
            final int vertexCount = Integer.parseInt(fileScanner.nextLine().trim());
            final UndirectedGraph g = new UndirectedGraphAdjMatrix(vertexCount);
            boolean isEdge = false;
            boolean isDestination = false;

            while (fileScanner.hasNextLine()) {
                final String currentLine = fileScanner.nextLine();
                if(currentLine.equals("G")){
                    isEdge = true;
                } else if(currentLine.equals("Q")){
                    isDestination = true;
                    isEdge = false;
                } else {
                    if(isEdge && isDestination){
                        throw new RuntimeException("There was an error when parsing the input file.");
                    } else if(isEdge){
                        final String[] vertexes = currentLine.split(" ");
                        g.addEdge(Integer.parseInt(vertexes[0]), Integer.parseInt(vertexes[1]));
                    } else if(isDestination){
                        final String[] vertexes = currentLine.split(" ");
                        if(g.areConnected(Integer.parseInt(vertexes[0]),Integer.parseInt(vertexes[1]))){
                            System.out.println(vertexes[0] + " and " + vertexes[1] + " are connected.");
                        } else{
                            System.out.println(vertexes[0] + " and " + vertexes[1] + " are NOT connected.");
                        }
                    } else {
                        throw new RuntimeException("There was an error when parsing the input file.");
                    }
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
