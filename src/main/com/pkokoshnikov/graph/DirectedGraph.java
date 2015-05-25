package com.pkokoshnikov.graph;

import com.google.inject.Inject;
import com.pkokoshnikov.graph.data.GraphDataStructure;
import com.pkokoshnikov.graph.edge.DirectedEdge;
import com.pkokoshnikov.graph.vertex.Vertex;
/**
 * User: pako1113
 * Date: 22.05.15
 */
public class DirectedGraph extends Graph<DirectedEdge> {

    @Inject
    public DirectedGraph(GraphDataStructure<DirectedEdge> graphDataStructure) {
        this.graphDataStructure = graphDataStructure;
    }

    @Override
    public DirectedEdge addEdge(Vertex u, Vertex v) {
        DirectedEdge edge = new DirectedEdge(u, v);
        graphDataStructure.addEdge(edge);

        return edge;
    }

    @Override
    public String toString() {
        return "DirectedGraph{" +
                "graphDataStructure=" + graphDataStructure +
                "}";
    }
}
