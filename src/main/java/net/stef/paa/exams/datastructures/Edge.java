package net.stef.paa.exams.datastructures;

public class Edge {
    private final int sourceVertex;
    private final int destinationVertex;

    public Edge(final int source, final int destination){
        this.sourceVertex = source;
        this.destinationVertex = destination;
    }

    public int getSourceVertex() {
        return sourceVertex;
    }

    public int getDestinationVertex() {
        return destinationVertex;
    }
}
