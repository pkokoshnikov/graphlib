package com.pkokoshnikov.graph.data;

import com.pkokoshnikov.graph.edge.Edge;
import com.pkokoshnikov.graph.vertex.Vertex;

import java.util.LinkedList;
import java.util.List;

/**
 * User: pako1113
 * Date: 25.05.15
 * This data structure provides abstract implementation trough adjacency list
 */
public abstract class AdjListDataStructure<T extends Edge> implements GraphDataStructure<T> {
    protected List<Vertex> vertices;
    protected List<T> edges;

    protected AdjListDataStructure() {
        this.vertices = new LinkedList<Vertex>();
        this.edges = new LinkedList<T>();
    }

    @Override
    public void addVertices(Vertex[] vertices) {
        for(Vertex vertex : vertices) {
            this.vertices.add(vertex);
        }
    }

    @Override
    public void addVertices(List<Vertex> vertices) {
        vertices.addAll(vertices);
    }

    public void addVertex(Vertex vertex) {
        if(vertices.contains(vertex)) {
            throw new IllegalArgumentException("This vertex has been already added");
        }

        vertices.add(vertex);
    }

    public void addEdge(T edge) {
        if(edges.contains(edge)) {
            throw new IllegalArgumentException("This vertex has been already added");
        }

        edges.add(edge);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<T> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return "AdjListDataStructure{\n" +
                "vertices=" + vertices +
                ",\nedges=" + edges +
                '}';
    }
}
