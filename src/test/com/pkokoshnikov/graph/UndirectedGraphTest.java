package com.pkokoshnikov.graph;

import com.pkokoshnikov.graph.factory.GraphFactory;
import org.junit.Before;
import org.junit.Test;

import static com.pkokoshnikov.graph.TestData.*;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * User: pako1113
 * Date: 26.05.15
 */

public class UndirectedGraphTest {
    private final GraphFactory undirectedGraphFactory = new GraphFactory();
    private UndirectedGraph directedGraph;

    @Before
    public void setup() {
        directedGraph = undirectedGraphFactory.createGraph(UndirectedGraph.class);
        directedGraph.addVertices(Arrays.asList(VERTICES));
        directedGraph.addEdges(Arrays.asList(UNDIRECTED_EDGES));
    }

    @Test
    public void testGetPathInUndirectedGraph() {
        assertArrayEquals(new Object[]{VERTICES[0], VERTICES[1]}, directedGraph.getPath(VERTICES[0], VERTICES[1]).toArray());
        assertArrayEquals(new Object[]{VERTICES[0],VERTICES[1], VERTICES[8], VERTICES[6], VERTICES[4], VERTICES[7]}, directedGraph.getPath(VERTICES[0], VERTICES[7]).toArray());
    }
}
