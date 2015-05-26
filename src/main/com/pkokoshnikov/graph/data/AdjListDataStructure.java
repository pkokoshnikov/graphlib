package com.pkokoshnikov.graph.data;

import com.pkokoshnikov.graph.edge.Edge;
import com.pkokoshnikov.graph.vertex.Vertex;

import java.util.*;

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
    public void addVertices(List<? extends Vertex> vertices) {
        for(Vertex vertex : vertices) {
            if(this.vertices.contains(vertex)) {
                throw new IllegalArgumentException("This vertex has been already added");
            }
        }

        this.vertices.addAll(vertices);
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

    @Override
    public void addEdges(List<T> edges) {
        for(Edge edge : edges) {
            if(this.edges.contains(edge)) {
                throw new IllegalArgumentException("This vertex has been already added");
            }
        }

        this.edges.addAll(edges);
    }

    public List<Vertex> getVertices() {
        return new ArrayList<Vertex>(vertices);
    }

    public List<T> getEdges() {
        return new ArrayList<T>(edges);
    }

    @Override
    public String toString() {
        return "AdjListDataStructure{\n" +
                "vertices=" + vertices +
                ",\nedges=" + edges +
                '}';
    }
}
