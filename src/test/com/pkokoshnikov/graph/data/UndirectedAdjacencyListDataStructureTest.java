package com.pkokoshnikov.graph.data;

import com.pkokoshnikov.graph.data.UndirectedAdjacencyListDataStructure;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.pkokoshnikov.graph.TestData.*;
import static org.junit.Assert.assertArrayEquals;

/**
 * User: pako1113
 * Date: 26.05.15
 */

public class UndirectedAdjacencyListDataStructureTest {
    private UndirectedAdjacencyListDataStructure undirectedAdjacencyListDataStructure;

    @Before
    public void setup() {
        undirectedAdjacencyListDataStructure = new UndirectedAdjacencyListDataStructure();
        undirectedAdjacencyListDataStructure.addVertices(Arrays.asList(VERTICES));
        undirectedAdjacencyListDataStructure.addEdges(Arrays.asList(UNDIRECTED_EDGES));
    }

    @Test
    public void testGetAdjacencyList(){
        assertArrayEquals(new Object[]{VERTICES[1], VERTICES[2], VERTICES[3], VERTICES[6]}, undirectedAdjacencyListDataStructure.getAdjacencyList(VERTICES[0]).toArray());
    }
}
