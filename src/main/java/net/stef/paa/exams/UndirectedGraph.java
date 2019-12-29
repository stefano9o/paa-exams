package net.stef.paa.exams;

/**
 * Represents an undirected graph with static vertex
 */
public interface UndirectedGraph {
    void addEdge(final int i, final int j);
    void removeEdge(final int i, final int j);
    boolean areConnected(final int i, final int j);
    int vertexCount();
    Integer[] getNeighbours(final int i);

}
