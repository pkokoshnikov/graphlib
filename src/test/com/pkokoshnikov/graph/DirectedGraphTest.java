package com.pkokoshnikov.graph;

import com.pkokoshnikov.graph.edge.DirectedEdge;
import com.pkokoshnikov.graph.factory.DirectedGraphFactory;
import com.pkokoshnikov.graph.vertex.NumberVertex;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * User: pako1113
 * Date: 26.05.15
 */
public class DirectedGraphTest {

    private final DirectedGraphFactory directedGraphFactory = new DirectedGraphFactory();

    private final NumberVertex[] vertices = {new NumberVertex(0), new NumberVertex(1), new NumberVertex(2), new NumberVertex(3),
            new NumberVertex(4), new NumberVertex(5), new NumberVertex(6), new NumberVertex(7), new NumberVertex(8)};

    private final DirectedEdge[] edges ={
            new DirectedEdge(vertices[0], vertices[7]),
            new DirectedEdge(vertices[1], vertices[0]),
            new DirectedEdge(vertices[0], vertices[2]),
            new DirectedEdge(vertices[0], vertices[3]),
            new DirectedEdge(vertices[2], vertices[4]),
            new DirectedEdge(vertices[2], vertices[5]),
            new DirectedEdge(vertices[2], vertices[0]),
            new DirectedEdge(vertices[4], vertices[6]),
            new DirectedEdge(vertices[4], vertices[7]),
            new DirectedEdge(vertices[6], vertices[0]),
            new DirectedEdge(vertices[6], vertices[8]),
            new DirectedEdge(vertices[8], vertices[1])};

    private DirectedGraph directedGraph;

    @Before
    public void setup() {
        directedGraph = directedGraphFactory.create();
        directedGraph.addVertices(Arrays.asList(vertices));
        directedGraph.addEdges(Arrays.asList(edges));
    }

    @Test
    public void testAddingVerticesAndEdges() {
        assertArrayEquals(directedGraph.getVertices().toArray(), vertices);
        assertArrayEquals(directedGraph.getEdges().toArray(), edges);
    }

    @Test
    public void testGetPathInDirectedGraph() {
        assertArrayEquals(new Object[]{vertices[0], vertices[2], vertices[4], vertices[6], vertices[8], vertices[1]}, directedGraph.getPath(vertices[0], vertices[1]).toArray());
    }
}
