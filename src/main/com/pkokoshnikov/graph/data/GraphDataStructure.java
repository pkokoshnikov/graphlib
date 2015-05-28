package com.pkokoshnikov.graph.data;

import com.pkokoshnikov.graph.edge.Edge;
import com.pkokoshnikov.graph.vertex.Vertex;

import java.util.List;
import java.util.Set;

/**
 * User: pako1113
 * Date: 25.05.15
 * Interface for data structure
 */
public interface GraphDataStructure<T extends Edge> {
    boolean addVertices(List<? extends Vertex> vertices);
    boolean addVertex(Vertex vertex);

    boolean addEdge(T edge);
    boolean addEdges(List<T> edges);

    List<Vertex> getVertices();
    List<T> getEdges();

    /**
     * Get adjacency list for vertex u
     * @return list of vertices which adjacent with u
     */
    List<Vertex> getAdjacencyList(Vertex u);
}
