package net.stef.paa.exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectedGraphIncMatrix extends Graph {
    private final Integer vertexCount;
    private List<List<Integer>> incMatrix;

    DirectedGraphIncMatrix(final Integer vertexCount){
        incMatrix = new ArrayList<List<Integer>>();
        this.vertexCount = vertexCount;
    }

    public void addEdge(final int i, final int j) {
        throwExceptionIfOutOfGraph(i,j);
        final Integer[] edge = new Integer[vertexCount];
        Arrays.fill(edge, 0);
        edge[i] = 1;
        edge[j] = -1;
        incMatrix.add(Arrays.asList(edge));
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
