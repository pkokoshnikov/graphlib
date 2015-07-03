package com.pkokoshnikov.graph.edge;

import com.pkokoshnikov.graph.vertex.Vertex;

/**
 * User: pako1113
 * Date: 22.05.15
 * Implementation for directed edges
 */
public class DirectedEdge implements Edge{
    private Vertex start;
    private Vertex end;

    public DirectedEdge(Vertex start, Vertex end) {
        this.start = start;
        this.end = end;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "DirectedEdge{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (getClass() != obj.getClass())
            return false;

        if (((DirectedEdge) obj).getStart().equals(getStart()) && ((DirectedEdge) obj).getEnd().equals(getEnd()))
            return true;

        return false;
    }
}

