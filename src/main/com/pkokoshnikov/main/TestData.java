package com.pkokoshnikov.main;

import com.pkokoshnikov.graph.edge.DirectedEdge;
import com.pkokoshnikov.graph.edge.UndirectedEdge;
import com.pkokoshnikov.graph.vertex.NumberVertex;

/**
 * User: pako1113
 * Date: 27.05.15
 */
public interface TestData {
    NumberVertex[] VERTICES = {new NumberVertex(0), new NumberVertex(1), new NumberVertex(2), new NumberVertex(3),
            new NumberVertex(4), new NumberVertex(5), new NumberVertex(6), new NumberVertex(7), new NumberVertex(8)};

    DirectedEdge[] DIRECTED_EDGES ={
            new DirectedEdge(VERTICES[0], VERTICES[7]),
            new DirectedEdge(VERTICES[1], VERTICES[0]),
            new DirectedEdge(VERTICES[0], VERTICES[2]),
            new DirectedEdge(VERTICES[0], VERTICES[3]),
            new DirectedEdge(VERTICES[2], VERTICES[4]),
            new DirectedEdge(VERTICES[2], VERTICES[5]),
            new DirectedEdge(VERTICES[2], VERTICES[0]),
            new DirectedEdge(VERTICES[4], VERTICES[6]),
            new DirectedEdge(VERTICES[4], VERTICES[7]),
            new DirectedEdge(VERTICES[6], VERTICES[0]),
            new DirectedEdge(VERTICES[6], VERTICES[8]),
            new DirectedEdge(VERTICES[8], VERTICES[1])};

    UndirectedEdge[] UNDIRECTED_EDGES ={
            new UndirectedEdge(VERTICES[1], VERTICES[0]),
            new UndirectedEdge(VERTICES[0], VERTICES[2]),
            new UndirectedEdge(VERTICES[0], VERTICES[3]),
            new UndirectedEdge(VERTICES[2], VERTICES[4]),
            new UndirectedEdge(VERTICES[2], VERTICES[4]),
            new UndirectedEdge(VERTICES[2], VERTICES[5]),
            new UndirectedEdge(VERTICES[4], VERTICES[6]),
            new UndirectedEdge(VERTICES[4], VERTICES[6]),
            new UndirectedEdge(VERTICES[4], VERTICES[7]),
            new UndirectedEdge(VERTICES[6], VERTICES[0]),
            new UndirectedEdge(VERTICES[6], VERTICES[8]),
            new UndirectedEdge(VERTICES[8], VERTICES[1])};
}
