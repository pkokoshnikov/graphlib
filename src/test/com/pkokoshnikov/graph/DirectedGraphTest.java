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
public class DirectedGraphTest {

    private final GraphFactory directedGraphFactory = new GraphFactory();
    private DirectedGraph directedGraph;

    @Before
    public void setup() {
        directedGraph = directedGraphFactory.createGraph(DirectedGraph.class);
        directedGraph.addVertices(Arrays.asList(VERTICES));
        directedGraph.addEdges(Arrays.asList(DIRECTED_EDGES));
    }


    @Test
    public void testGetPathInDirectedGraph() {
        Object[] testPath = new Object[]{VERTICES[0], VERTICES[2], VERTICES[4], VERTICES[6], VERTICES[8], VERTICES[1]};
        assertArrayEquals(directedGraph.getPath(VERTICES[0], VERTICES[1]).toArray(), testPath);
    }
}
