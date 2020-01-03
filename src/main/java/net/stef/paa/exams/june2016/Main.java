package net.stef.paa.exams.june2016;

import net.stef.paa.exams.datastructures.*;
import net.stef.paa.exams.datastructures.Process;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static List<Edge> edges = new ArrayList<>();
    private static int vertexCount;

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length != 1){
            throw new RuntimeException("You must specify one and only one parameter.");
        }

        parseInputFile(args[0]);
        final AbstractGraph graph = new DirectedGraphAdjList(vertexCount);

        constructGraph(graph, edges);

        Set[] sets= new Set[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            sets[i] = graph.getReachableVerticesWithDFS(i);
        }


        final HashMap<Integer, HashSet<Integer>> connectionGroups = new HashMap<>();
        for (int i = 0; i < vertexCount; i++) {
            sets[i].add(i);
            final Integer key = sets[i].hashCode();
            final HashSet<Integer> currentSet = connectionGroups.get(key);
            // if doesn't exist
            if(currentSet == null){
                final HashSet<Integer> newSet = new HashSet<>();
                newSet.add(i);
                connectionGroups.put(sets[i].hashCode(), newSet);
            } else {
                currentSet.add(i);
                connectionGroups.put(sets[i].hashCode(), currentSet);
            }
        }

        System.out.println(connectionGroups);

    }

    private static void parseInputFile(final String pathInputFile) throws FileNotFoundException {

        final File f = new File(pathInputFile);
        final Scanner fileScanner = new Scanner(f);
        vertexCount = Integer.parseInt(fileScanner.nextLine().trim());


        while (fileScanner.hasNextLine()) {
            final String currentLine = fileScanner.nextLine();
            final String[] vertexes = currentLine.split(" ");
            edges.add(new Edge(Integer.parseInt(vertexes[0]), Integer.parseInt(vertexes[1])));
        }
        fileScanner.close();
    }



    private static void constructGraph(final AbstractGraph g, final List<Edge> edges) {
        for (final Edge edge : edges) {
            g.addEdge(edge);
        }
    }

    private static void checkConnection(final AbstractGraph g, final List<VertexPair> vertexPairs) {
        System.out.println("Checking connectivity with " + g.getClass() + " ...");
        for (final VertexPair vertexPair : vertexPairs) {
            final int sourceVertex = vertexPair.getA();
            final int destinationVertex = vertexPair.getB();

         //   if(g.areConnected(sourceVertex, destinationVertex)){
         //       System.out.println("vertex " + sourceVertex + " and vertex " + destinationVertex + " are connected.");
          //  } else{
           //     System.out.println("vertex " + sourceVertex + " and vertex " + destinationVertex + " are NOT connected.");
            }
        }
       // System.out.println();
    }

