package net.stef.paa.exams;

import net.stef.paa.exams.datastructures.DirectedGraphAdjMatrix;
import net.stef.paa.exams.datastructures.Edge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectedAbstractGraphAdjMatrixTest {
    private DirectedGraphAdjMatrix g;
    @BeforeEach
    void setUp() {
        g = new DirectedGraphAdjMatrix(6);
    }

    @Test
    void addEdge() {
    }

    @Test
    void removeEdge() {
    }

    @Test
    void areConnected() {
        g.addEdge(new Edge(0,1));
        g.addEdge(new Edge(1,2));
        g.addEdge(new Edge(2,3));
        g.addEdge(new Edge(4,5));

        assertTrue(g.areConnectedBFS(5,5));
    }

    @Test
    void vertexCount() {
    }

    @Test
    void getNeighbours() {
    }
}