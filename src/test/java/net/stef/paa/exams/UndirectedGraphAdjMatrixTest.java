package net.stef.paa.exams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UndirectedGraphAdjMatrixTest {
    private UndirectedGraphAdjMatrix g;
    @BeforeEach
    void setUp() {
        g = new UndirectedGraphAdjMatrix(6);
    }

    @Test
    void addEdge() {
    }

    @Test
    void removeEdge() {
    }

    @Test
    void areConnected() {
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(4,5);

        assertTrue(g.areConnected(5,5));
    }

    @Test
    void vertexCount() {
    }

    @Test
    void getNeighbours() {
    }
}