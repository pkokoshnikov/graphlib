package com.pkokoshnikov.graph.data;

import com.pkokoshnikov.graph.data.AdjacencyListDataStructure;
import com.pkokoshnikov.graph.edge.Edge;
import com.pkokoshnikov.graph.vertex.Vertex;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * User: pako1113
 * Date: 27.05.15
 */
public class AdjacencyListDataStructureTest {
    private AdjacencyListDataStructure adjacencyListDataStructure;

    @Before
    public void setup() {
        adjacencyListDataStructure = new AdjacencyListDataStructure() {
            @Override
            public List<Vertex> getAdjacencyList(Vertex u) {
                return null;
            }
        };
    }

    @Test
    public void testReturnFalseIfAddExistedVertex(){
        Vertex vertex = new VertexStub();
        assertTrue(adjacencyListDataStructure.addVertex(vertex));
        assertFalse(adjacencyListDataStructure.addVertex(vertex));
    }


    @Test
    public void testReturnFalseIfAddExistedEdge(){
        Edge edge = new EdgeStub();
        assertTrue(adjacencyListDataStructure.addEdge(edge));
        assertFalse(adjacencyListDataStructure.addEdge(edge));
    }

    @Test
    public void testReturnFalseIfAddListWithExistedVertex(){
        List<VertexStub> vertices = Arrays.asList(new VertexStub[]{new VertexStub(),new VertexStub()});

        assertTrue(adjacencyListDataStructure.addVertices(vertices));
        assertFalse(adjacencyListDataStructure.addVertices(vertices));
    }

    @Test
    public void testReturnFalseIfAddListWithExistedEdge(){
        List<EdgeStub> edges = Arrays.asList(new EdgeStub[]{new EdgeStub(), new EdgeStub()});

        assertTrue(adjacencyListDataStructure.addEdges(edges));
        assertFalse(adjacencyListDataStructure.addEdges(edges));
    }

    public static class EdgeStub implements Edge {
    }

    public static class VertexStub implements Vertex{
    }
}
