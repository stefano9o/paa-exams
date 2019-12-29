package net.stef.paa.exams;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphAdjList extends Graph {
    private List<List<Integer>> adjList;

    DirectedGraphAdjList(final Integer vertexCount){
        adjList = new ArrayList<List<Integer>>(vertexCount);
        for (int i = 0; i < vertexCount; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(final int i, final int j) {
        throwExceptionIfOutOfGraph(i,j);
        if(adjList.get(i).contains(j)){
            throw new RuntimeException("an edge already exist for vertex " + i + " and vertex " + j + ".");
        }
        adjList.get(i).add(j);
    }
    

    public void removeEdge(final int i, final int j) {
        throwExceptionIfOutOfGraph(i,j);
        if(adjList.get(i).contains(j)){
            throw new RuntimeException("an edge does not exist for vertex " + i + " and vertex " + j + ".");
        }
        adjList.get(i).remove(j);
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
