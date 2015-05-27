package com.pkokoshnikov.graph.data;

import com.pkokoshnikov.graph.edge.Edge;
import com.pkokoshnikov.graph.vertex.Vertex;

import java.util.*;

/**
 * User: pako1113
 * Date: 25.05.15
 * This data structure provides abstract implementation trough adjacency list
 */
public abstract class AdjacencyListDataStructure<T extends Edge> implements GraphDataStructure<T> {
    protected List<Vertex> vertices;
    protected List<T> edges;

    protected AdjacencyListDataStructure() {
        this.vertices = new LinkedList<Vertex>();
        this.edges = new LinkedList<T>();
    }

    @Override
    public boolean addVertices(List<? extends Vertex> vertices) {
        for(Vertex vertex : vertices) {
            if(this.vertices.contains(vertex)) {
                return false;
            }
        }

        this.vertices.addAll(vertices);
        return true;
    }

    @Override
    public boolean addVertex(Vertex vertex) {
        if(vertices.contains(vertex)) {
            return false;
        }

        vertices.add(vertex);
        return true;
    }

    @Override
    public boolean addEdge(T edge) {
        if(edges.contains(edge)) {
            return false;
        }

        edges.add(edge);
        return true;
    }

    @Override
    public boolean addEdges(List<T> edges) {
        for(Edge edge : edges) {
            if(this.edges.contains(edge)) {
                return false;
            }
        }

        this.edges.addAll(edges);
        return true;
    }

    @Override
    public List<Vertex> getVertices() {
        return new ArrayList<Vertex>(vertices);
    }

    @Override
    public List<T> getEdges() {
        return new ArrayList<T>(edges);
    }

    @Override
    public String toString() {
        return "AdjacencyListDataStructure{\n" +
                "vertices=" + vertices +
                ",\nedges=" + edges +
                '}';
    }
}
