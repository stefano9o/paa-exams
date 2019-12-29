package net.stef.paa.exams.datastructures;

public class VertexPair {
    private final int a;
    private final int b;

    public VertexPair(final int source, final int destination){
        this.a = source;
        this.b = destination;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
