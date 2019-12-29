package net.stef.paa.exams.datastructures;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphAdjList extends AbstractGraph {
    private List<List<Integer>> adjList;

    public DirectedGraphAdjList(final Integer vertexCount){
        adjList = new ArrayList<>(vertexCount);
        for (int i = 0; i < vertexCount; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(final Edge edge) {
        final int sourceVertex = edge.getSourceVertex();
        final int destVertex = edge.getDestinationVertex();
        throwExceptionIfOutOfGraph(sourceVertex, destVertex);
        if(adjList.get(sourceVertex).contains(destVertex)){
            throw new RuntimeException("an edge already exist for vertex " + sourceVertex
                    + " and vertex " + destVertex + ".");
        }
        adjList.get(sourceVertex).add(destVertex);
    }
    

    public boolean removeEdge(final Edge edge) {
        final int sourceVertex = edge.getSourceVertex();
        final int destVertex = edge.getDestinationVertex();
        throwExceptionIfOutOfGraph(sourceVertex,destVertex);
        if(adjList.get(sourceVertex).contains(destVertex)){
            throw new RuntimeException("an edge does not exist for vertex " + sourceVertex
                    + " and vertex " + destVertex + ".");
        }
        adjList.get(sourceVertex).remove(destVertex);
        return true;
    }

    public int vertexCount() {
        return adjList.size();
    }

    public Integer[] getNeighbours(int i) {
        throwExceptionIfOutOfGraph(i);
        return adjList.get(i).toArray(new Integer[0]);
    }

    private void throwExceptionIfOutOfGraph(final int i){
        if(i > adjList.size() - 1)
            throw new RuntimeException("vertex " + i + " does not exist.");
    }

    private void throwExceptionIfOutOfGraph(final int i, final int j){
        throwExceptionIfOutOfGraph(i);
        throwExceptionIfOutOfGraph(j);
    }
}
