package net.stef.paa.exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectedGraphAdjMatrix implements UndirectedGraph {
    private int[][] adjMatrix;

    UndirectedGraphAdjMatrix(final int vertexCount){
        adjMatrix = new int[vertexCount][];
        for (int i = 0; i < adjMatrix.length; i++) {
            adjMatrix[i] = new int[vertexCount];
            Arrays.fill(adjMatrix[i],0);
        }
    }

    public void addEdge(final int i, final int j) {
        throwExceptionIfOutOfGraph(i,j);
        if(adjMatrix[i][j] != 0 || adjMatrix[j][i] != 0){
            throw new RuntimeException("an edge already exist for vertex " + i + " and vertex " + j + ".");
        }
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void removeEdge(final int i, final int j) {
        throwExceptionIfOutOfGraph(i,j);
        if(adjMatrix[i][j] == 0 || adjMatrix[j][i] == 0){
            throw new RuntimeException("an edge does not exist for vertex " + i + " and vertex " + j + ".");
        }
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public boolean areConnected(final int source, final int destination) {
        final boolean[] discVertices = new boolean[vertexCount()];
        Arrays.fill(discVertices,false);
        discVertices[source] = true;

        final Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        while (!queue.isEmpty()) {
            final Integer currentNode = queue.remove();
            if (currentNode == destination) {
                return true;
            }
            final Integer[] neighbours = getNeighbours(currentNode);
            for (int visitingNode : neighbours) {
                if (!discVertices[visitingNode]) {
                    discVertices[visitingNode] = true;
                    queue.add(visitingNode);
                }
            }
        }
        return false;
    }

    public int vertexCount() {
        return adjMatrix.length;
    }

    public Integer[] getNeighbours(int i) {
        throwExceptionIfOutOfGraph(i);
        final List<Integer> neighbours = new ArrayList<Integer>();

        for (int j = 0; j < adjMatrix[i].length; j++) {
            if(i != j && adjMatrix[i][j] != 0){
                neighbours.add(j);
            }
        }

        return neighbours.toArray(new Integer[0]);
    }

    private void throwExceptionIfOutOfGraph(final int i){
        if(i > adjMatrix.length - 1)
            throw new RuntimeException("vertex " + i + " does not exist.");
    }

    private void throwExceptionIfOutOfGraph(final int i, final int j){
        throwExceptionIfOutOfGraph(i);
        throwExceptionIfOutOfGraph(j);
    }
}
