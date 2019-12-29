package net.stef.paa.exams.datastructures;

public class UndirectedGraphIncMatrix extends DirectedGraphIncMatrix {
    public UndirectedGraphIncMatrix(Integer vertexCount) {
        super(vertexCount);
    }

    @Override
    public void addEdge(final Edge edge) {
        super.addEdge(edge);
        super.addEdge(new Edge(edge.getDestinationVertex(), edge.getSourceVertex()));
    }

    @Override
    public boolean removeEdge(final Edge edge) {
        return super.removeEdge(edge) &&
                super.removeEdge(new Edge(edge.getDestinationVertex(), edge.getSourceVertex()));
    }
}
