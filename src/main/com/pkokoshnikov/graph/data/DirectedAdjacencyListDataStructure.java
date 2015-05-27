package com.pkokoshnikov.graph.data;

import com.pkokoshnikov.graph.edge.DirectedEdge;
import com.pkokoshnikov.graph.vertex.Vertex;

import java.util.LinkedList;
import java.util.List;

/**
 * User: pako1113
 * Date: 25.05.15
 */
public class DirectedAdjacencyListDataStructure extends AdjacencyListDataStructure<DirectedEdge> {

    @Override
    public List<Vertex> getAdjacencyList(Vertex u) {
        List<Vertex> adjacencyList = new LinkedList<Vertex>();
        for (DirectedEdge edge : edges) {
            if (edge.getStart().equals(u)) adjacencyList.add(edge.getEnd());
        }

        return adjacencyList;
    }
}
