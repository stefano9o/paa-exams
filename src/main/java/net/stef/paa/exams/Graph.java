package net.stef.paa.exams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents an undirected graph with static vertex
 */
public abstract class Graph {
    abstract void addEdge(final int i, final int j);
    abstract void removeEdge(final int i, final int j);
    abstract int vertexCount();
    abstract Integer[] getNeighbours(final int i);

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
}
