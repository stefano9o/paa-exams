package net.stef.paa.exams.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectedGraphIncMatrix extends AbstractGraph {
    private final Integer vertexCount;
    private List<List<Integer>> incMatrix;

    public DirectedGraphIncMatrix(final Integer vertexCount){
        incMatrix = new ArrayList<>();
        this.vertexCount = vertexCount;
    }

    public void addEdge(final Edge edge) {
        final int sourceVertex = edge.getSourceVertex();
        final int destVertex = edge.getDestinationVertex();

        throwExceptionIfOutOfGraph(sourceVertex,destVertex);
        final Integer[] incArray = new Integer[vertexCount];
        Arrays.fill(incArray, 0);
        incArray[sourceVertex] = 1;
        incArray[destVertex] = -1;
        incMatrix.add(Arrays.asList(incArray));
    }


    public boolean removeEdge(final Edge edge) {
        final int sourceVertex = edge.getSourceVertex();
        final int destVertex = edge.getDestinationVertex();

        //funcrional programming (lambda expression)
        if(!incMatrix.removeIf(e -> e.get(sourceVertex) == 1 && e.get(destVertex) == -1)){
            throw new RuntimeException("an edge does not exist for vertex " + sourceVertex
                    + " and vertex " + destVertex + ".");
        }
        return true;
    }

    public int vertexCount() {
        return this.vertexCount;
    }

    public Integer[] getNeighbours(int i) {
        throwExceptionIfOutOfGraph(i);
        final List<Integer> neighbours = new ArrayList<>();
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
