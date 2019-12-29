package net.stef.paa.exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectedGraphAdjMatrix extends Graph {
    private int[][] adjMatrix;

    DirectedGraphAdjMatrix(final Integer vertexCount){
        adjMatrix = new int[vertexCount][];
        for (int i = 0; i < adjMatrix.length; i++) {
            adjMatrix[i] = new int[vertexCount];
            Arrays.fill(adjMatrix[i],0);
        }
    }

    public void addEdge(final int i, final int j) {
        throwExceptionIfOutOfGraph(i,j);
        if(adjMatrix[i][j] != 0){
            throw new RuntimeException("an edge already exist for vertex " + i + " and vertex " + j + ".");
        }
        adjMatrix[i][j] = 1;
    }


    public void removeEdge(final int i, final int j) {
        throwExceptionIfOutOfGraph(i,j);
        if(adjMatrix[i][j] == 0){
            throw new RuntimeException("an edge does not exist for vertex " + i + " and vertex " + j + ".");
        }
        adjMatrix[i][j] = 0;
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
