package com.pkokoshnikov.graph;

import com.pkokoshnikov.graph.edge.DirectedEdge;
import com.pkokoshnikov.graph.edge.UndirectedEdge;
import com.pkokoshnikov.graph.factory.DirectedGraphFactory;
import com.pkokoshnikov.graph.factory.UndirectedGraphFactory;
import com.pkokoshnikov.graph.vertex.NumberVertex;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * User: pako1113
 * Date: 26.05.15
 */

public class UndirectedGraphTest {
    private final UndirectedGraphFactory undirectedGraphFactory = new UndirectedGraphFactory();

    private final NumberVertex[] vertices = {new NumberVertex(0), new NumberVertex(1), new NumberVertex(2), new NumberVertex(3),
            new NumberVertex(4), new NumberVertex(5), new NumberVertex(6), new NumberVertex(7), new NumberVertex(8)};

    private final UndirectedEdge[] edges ={
            new UndirectedEdge(vertices[1], vertices[0]),
            new UndirectedEdge(vertices[0], vertices[2]),
            new UndirectedEdge(vertices[0], vertices[3]),
            new UndirectedEdge(vertices[2], vertices[4]),
            new UndirectedEdge(vertices[2], vertices[4]),
            new UndirectedEdge(vertices[2], vertices[5]),
            new UndirectedEdge(vertices[4], vertices[6]),
            new UndirectedEdge(vertices[4], vertices[6]),
            new UndirectedEdge(vertices[4], vertices[7]),
            new UndirectedEdge(vertices[6], vertices[0]),
            new UndirectedEdge(vertices[6], vertices[8]),
            new UndirectedEdge(vertices[8], vertices[1])};

    private UndirectedGraph directedGraph;

    @Before
    public void setup() {
        directedGraph = undirectedGraphFactory.create();
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
        assertArrayEquals(new Object[]{vertices[0], vertices[1]}, directedGraph.getPath(vertices[0], vertices[1]).toArray());
        System.out.println(directedGraph.getPath(vertices[0], vertices[7]));
        assertArrayEquals(new Object[]{vertices[0],vertices[1], vertices[8], vertices[6], vertices[4], vertices[7]}, directedGraph.getPath(vertices[0], vertices[7]).toArray());
    }
}
