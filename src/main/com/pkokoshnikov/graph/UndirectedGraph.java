package com.pkokoshnikov.graph;

import com.google.inject.Inject;
import com.pkokoshnikov.graph.data.GraphDataStructure;
import com.pkokoshnikov.graph.edge.UndirectedEdge;
import com.pkokoshnikov.graph.vertex.Vertex;

/**
 * User: pako1113
 * Date: 22.05.15
 */
public class UndirectedGraph extends Graph<UndirectedEdge> {
    @Inject
    public UndirectedGraph(GraphDataStructure<UndirectedEdge> graphDataStructure) {
        this.graphDataStructure = graphDataStructure;
    }

    @Override
    public String toString() {
        return "UndirectedGraph{" +
                "graphDataStructure=" + graphDataStructure +
                "}";
    }

}
