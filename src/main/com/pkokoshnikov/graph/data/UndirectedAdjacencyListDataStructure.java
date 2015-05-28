package com.pkokoshnikov.graph.data;

import com.pkokoshnikov.graph.edge.UndirectedEdge;
import com.pkokoshnikov.graph.vertex.Vertex;

import java.util.LinkedList;
import java.util.List;

/**
 * User: pako1113
 * Date: 25.05.15
 * Implementation of data structure for undirected graphs
 */
public class UndirectedAdjacencyListDataStructure extends AdjacencyListDataStructure<UndirectedEdge> {

    @Override
    public List<Vertex> getAdjacencyList(Vertex u) {
        List<Vertex> adjacencyList = new LinkedList<Vertex>();
        for (UndirectedEdge edge : edges) {
            if (edge.getU().equals(u)) {
                adjacencyList.add(edge.getV());
            } else if (edge.getV().equals(u)) {
                adjacencyList.add(edge.getU());
            }
        }

        return adjacencyList;
    }
}
