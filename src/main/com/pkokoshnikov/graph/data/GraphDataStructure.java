package com.pkokoshnikov.graph.data;

import com.pkokoshnikov.graph.edge.Edge;
import com.pkokoshnikov.graph.vertex.Vertex;

import java.util.List;

/**
 * User: pako1113
 * Date: 25.05.15
 */
public interface GraphDataStructure<T extends Edge> {
    void addVertices(Vertex[] vertices);
    void addVertices(List<Vertex> vertices);
    void addVertex(Vertex vertex);

    void addEdge(T edge);

    List<Vertex> getVertices();
    List<T> getEdges();
    List<Vertex> getAdjacencyList(Vertex u);
}