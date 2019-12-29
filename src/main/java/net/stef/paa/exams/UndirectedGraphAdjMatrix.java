package net.stef.paa.exams;

public class UndirectedGraphAdjMatrix extends DirectedGraphAdjMatrix {
    UndirectedGraphAdjMatrix(Integer vertexCount) {
        super(vertexCount);
    }

    @Override
    public void addEdge(int i, int j) {
        super.addEdge(i, j);
        super.addEdge(j, i);
    }

    @Override
    public void removeEdge(int i, int j) {
        super.removeEdge(i, j);
        super.removeEdge(j, i);
    }


}
