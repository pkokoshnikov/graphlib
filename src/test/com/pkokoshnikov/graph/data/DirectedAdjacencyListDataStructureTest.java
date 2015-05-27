package com.pkokoshnikov.graph.data;

import com.pkokoshnikov.graph.data.DirectedAdjacencyListDataStructure;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.pkokoshnikov.graph.TestData.*;
import static org.junit.Assert.assertArrayEquals;

/**
 * User: pako1113
 * Date: 26.05.15
 */

public class DirectedAdjacencyListDataStructureTest {
    private DirectedAdjacencyListDataStructure directedAdjacencyListDataStructure;

    @Before
    public void setup() {
        directedAdjacencyListDataStructure = new DirectedAdjacencyListDataStructure();
        directedAdjacencyListDataStructure.addVertices(Arrays.asList(VERTICES));
        directedAdjacencyListDataStructure.addEdges(Arrays.asList(DIRECTED_EDGES));
    }

    @Test
    public void testGetAdjacencyList(){
        assertArrayEquals(new Object[]{VERTICES[7], VERTICES[2], VERTICES[3]}, directedAdjacencyListDataStructure.getAdjacencyList(VERTICES[0]).toArray());
    }
}
