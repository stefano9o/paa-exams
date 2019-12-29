package net.stef.paa.exams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainJanuary {
    private static List<Edge> edges = new ArrayList<>();
    private static List<VertexPair> vertexPairs = new ArrayList<>();
    private static int vertexCount;

    public static void main(String[] args){
        if(args.length != 1){
            throw new RuntimeException("You must specify one and only one parameter.");
        }

        parseInputFile(args[0]);
        final List<Graph> graphs = new ArrayList<>();
        graphs.add(new UndirectedGraphAdjMatrix(vertexCount));
        graphs.add(new UndirectedGraphAdjList(vertexCount));
        graphs.add(new UndirectedGraphIncMatrix(vertexCount));
        graphs.add(new DirectedGraphAdjMatrix(vertexCount));
        graphs.add(new DirectedGraphAdjList(vertexCount));
        graphs.add(new DirectedGraphIncMatrix(vertexCount));

        for (final Graph g : graphs) {
            constructGraph(g, edges);
            checkConnection(g, vertexPairs);
        }
    }

    private static void parseInputFile(final String pathInputFile) {
        try {
            final File f = new File(pathInputFile);
            final Scanner fileScanner = new Scanner(f);
            vertexCount = Integer.parseInt(fileScanner.nextLine().trim());
            boolean isEdge = false;
            boolean isVertexPair = false;

            while (fileScanner.hasNextLine()) {
                final String currentLine = fileScanner.nextLine();
                if(currentLine.equals("G")){
                    isEdge = true;
                } else if(currentLine.equals("Q")){
                    isVertexPair = true;
                    isEdge = false;
                } else {
                    if(isEdge && isVertexPair){
                        throw new RuntimeException("There was an error when parsing the input file.");
                    } else if(isEdge){
                        final String[] vertexes = currentLine.split(" ");
                        edges.add(new Edge(Integer.parseInt(vertexes[0]), Integer.parseInt(vertexes[1])));
                    } else if(isVertexPair){
                        final String[] vertexes = currentLine.split(" ");
                        vertexPairs.add(new VertexPair(Integer.parseInt(vertexes[0]),Integer.parseInt(vertexes[1])));
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

    private static void constructGraph(final Graph g, final List<Edge> edges) {
        for (final Edge edge : edges) {
            g.addEdge(edge.getSourceVertex(), edge.getDestinationVertex());
        }
    }

    private static void checkConnection(final Graph g, final List<VertexPair> vertexPairs) {
        System.out.println("Checking connectivity with " + g.getClass());
        for (final VertexPair vertexPair : vertexPairs) {
            final int sourceVertex = vertexPair.getA();
            final int destinationVertex = vertexPair.getB();

            if(g.areConnected(sourceVertex, destinationVertex)){
                System.out.println(sourceVertex + " and " + destinationVertex + " are connected.");
            } else{
                System.out.println(sourceVertex + " and " + destinationVertex + " are NOT connected.");
            }
        }
        System.out.println();
    }
}
