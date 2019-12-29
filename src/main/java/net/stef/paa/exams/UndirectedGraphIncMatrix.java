package net.stef.paa.exams;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UndirectedGraphIncMatrix extends UndirectedGraph {
    private final Integer vertexCount;
    private List<List<Integer>> incMatrix;

    UndirectedGraphIncMatrix(final Integer vertexCount){
        incMatrix = new ArrayList<List<Integer>>();
        this.vertexCount = vertexCount;
    }

    public void addEdge(final int i, final int j) {
        throwExceptionIfOutOfGraph(i,j);
        final Integer[] outgoingArray = new Integer[vertexCount];
        final Integer[] incomingArray = new Integer[vertexCount];
        Arrays.fill(outgoingArray, 0);
        Arrays.fill(incomingArray, 0);
        outgoingArray[i] = 1;
        outgoingArray[j] = -1;
        incomingArray[i] = -1;
        incomingArray[j] = 1;
        incMatrix.add(Arrays.asList(outgoingArray));
        incMatrix.add(Arrays.asList(incomingArray));
    }


    public void removeEdge(final int i, final int j) {
        incMatrix.removeIf(e -> e.get(i) == 1 && e.get(j) == -1);
    }

    public int vertexCount() {
        return this.vertexCount;
    }

    public Integer[] getNeighbours(int i) {
        throwExceptionIfOutOfGraph(i);
        final List<Integer> neighbours = new ArrayList<Integer>();
        for (final List<Integer> edge : incMatrix) {
            if (edge.get(i) == 1){
                final int destinationNode = edge.indexOf(-1);
                if(destinationNode == -1){
                    throw new IllegalStateException("No -1 are present for edge " + edge + ".");
                }
                neighbours.add(destinationNode);
            }
        }

        return neighbours.toArray(new Integer[0]);
    }

    private void throwExceptionIfOutOfGraph(final int i){
        if(i > vertexCount)
            throw new RuntimeException("vertex " + i + " does not exist.");
    }

    private void throwExceptionIfOutOfGraph(final int i, final int j){
        throwExceptionIfOutOfGraph(i);
        throwExceptionIfOutOfGraph(j);
    }
}
