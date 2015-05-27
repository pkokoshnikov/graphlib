package com.pkokoshnikov.graph;

import com.pkokoshnikov.graph.data.AdjacencyListDataStructure;
import com.pkokoshnikov.graph.edge.Edge;
import com.pkokoshnikov.graph.vertex.Vertex;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: pako1113
 * Date: 27.05.15
 */
public class AbstractGraphTest {
    private AbstractGraph abstractGraph;

    @Before
    public void setup() {
        abstractGraph = new AbstractGraph<EdgeStub>(new AdjacencyListDataStructure<EdgeStub>() {
            @Override
            public List<Vertex> getAdjacencyList(Vertex u) {
                return null;
            }
        }) {
        };
    }

    @Test
    public void testAddingVerticesAndEdges() {
        Vertex[] vertices = new VertexStub[]{new VertexStub(), new VertexStub()};
        Edge[] edges = new EdgeStub[]{new EdgeStub(), new EdgeStub()};
        assertTrue(abstractGraph.addVertices(Arrays.asList(vertices)));
        assertTrue(abstractGraph.addEdges(Arrays.asList(edges)));
        assertArrayEquals(abstractGraph.getVertices().toArray(), vertices);
        assertArrayEquals(abstractGraph.getEdges().toArray(), edges);
    }

    public static class EdgeStub implements Edge {
    }

    public static class VertexStub implements Vertex {
    }
}
