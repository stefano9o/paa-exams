package net.stef.paa.exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UndirectedGraphAdjList extends UndirectedGraph {
    private List<List<Integer>> adjList;

    UndirectedGraphAdjList(final Integer vertexCount){
        adjList = new ArrayList<List<Integer>>(vertexCount);
        for (int i = 0; i < vertexCount; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(final int i, final int j) {
        throwExceptionIfOutOfGraph(i,j);
        if(adjList.get(i).contains(j) || adjList.get(j).contains(i)){
            throw new RuntimeException("an edge already exist for vertex " + i + " and vertex " + j + ".");
        }
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }
    

    public void removeEdge(final int i, final int j) {
        throwExceptionIfOutOfGraph(i,j);
        if(adjList.get(i).contains(j) || adjList.get(j).contains(i)){
            throw new RuntimeException("an edge does not exist for vertex " + i + " and vertex " + j + ".");
        }
        adjList.get(i).remove(j);
        adjList.get(j).remove(i);
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
