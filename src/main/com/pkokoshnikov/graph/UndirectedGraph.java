package com.pkokoshnikov.graph;

import com.google.inject.Inject;
import com.pkokoshnikov.graph.data.GraphDataStructure;
import com.pkokoshnikov.graph.edge.UndirectedEdge;

/**
 * User: pako1113
 * Date: 22.05.15
 */
public class UndirectedGraph extends AbstractGraph<UndirectedEdge> {
    @Inject
    public UndirectedGraph(GraphDataStructure<UndirectedEdge> graphDataStructure) {
        super(graphDataStructure);
    }

    @Override
    public String toString() {
        return "UndirectedGraph{" +
                "graphDataStructure=" + graphDataStructure +
                "}";
    }

}
