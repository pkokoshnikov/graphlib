package com.pkokoshnikov.graph;

import com.google.inject.Inject;
import com.pkokoshnikov.graph.data.GraphDataStructure;
import com.pkokoshnikov.graph.edge.DirectedEdge;
import com.pkokoshnikov.graph.edge.Edge;
import com.pkokoshnikov.graph.vertex.Vertex;

import java.util.LinkedList;
import java.util.List;

/**
 * User: pako1113
 * Date: 22.05.15
 */
abstract public class AbstractGraph<T extends Edge> {
    protected GraphDataStructure<T> graphDataStructure;

    public AbstractGraph(GraphDataStructure<T> graphDataStructure) {
        this.graphDataStructure = graphDataStructure;
    }

    public boolean addVertex(Vertex vertex) {
        return graphDataStructure.addVertex(vertex);
    }

    public boolean addVertices(List<? extends Vertex> vertices) {
        return graphDataStructure.addVertices(vertices);
    }

    public boolean addEdge(T edge) {
        return graphDataStructure.addEdge(edge);
    }

    public boolean addEdges(List<T> edges) {
        return graphDataStructure.addEdges(edges);
    }

    public List<Vertex> getVertices() {
        return graphDataStructure.getVertices();
    }

    protected List<Vertex> DFS(Vertex start, Vertex goal) {
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        List<Vertex> whiteVertices = new LinkedList<Vertex>(graphDataStructure.getVertices());

        DFSrec(start, goal, path, whiteVertices);
        if (!path.isEmpty()) {
            path.addFirst(start);
        }

        return path;
    }

    protected boolean DFSrec(Vertex start, Vertex goal, LinkedList<Vertex> path, List<Vertex> whiteVertices) {
        whiteVertices.remove(start);
        List<Vertex> filteredWhiteVertices = filterWhiteVertices(graphDataStructure.getAdjacencyList(start), whiteVertices);

        if (start.equals(goal)) {
            return true;
        }

        for (Vertex vertex : filteredWhiteVertices) {
            if (DFSrec(vertex, goal, path, whiteVertices)) {
                path.addFirst(vertex);
                return true;
            }
        }

        return false;
    }

    protected List<Vertex> filterWhiteVertices(List<Vertex> adjacencyList, List<Vertex> whiteVertices) {
        LinkedList<Vertex> result = new LinkedList<Vertex>();
        for (Vertex vertex : adjacencyList) {
            if (whiteVertices.contains(vertex)) result.add(vertex);
        }

        return result;
    }

    public List<Vertex> getPath(Vertex start, Vertex goal) {
        return DFS(start, goal);
    }

    protected List<T> getEdges() {
        return graphDataStructure.getEdges();
    }

    protected List<Vertex> getAdjacencyList(Vertex u) {
        return graphDataStructure.getAdjacencyList(u);
    }

    @Override
    public String toString() {
        return "AbstractGraph{" +
                "graphDataStructure=" + graphDataStructure +
                "}";
    }
}
