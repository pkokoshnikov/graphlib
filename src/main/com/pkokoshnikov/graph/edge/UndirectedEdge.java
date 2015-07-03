package com.pkokoshnikov.graph.edge;

import com.pkokoshnikov.graph.vertex.Vertex;

/**
 * User: pako1113
 * Date: 22.05.15
 * Implementation for undirected eges
 */
public class UndirectedEdge implements Edge{
    private Vertex u;
    private Vertex v;

    public UndirectedEdge(Vertex u, Vertex v) {
        this.u = u;
        this.v = v;
    }

    public Vertex getU() {
        return u;
    }

    public Vertex getV() {
        return v;
    }

    @Override
    public String toString() {
        return "UndirectedEdge{" +
                "u=" + u +
                ", v=" + v +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (getClass() != obj.getClass())
            return false;

        if (((UndirectedEdge) obj).getU().equals(getU()) && ((UndirectedEdge) obj).getV().equals(getV()) ||
                ((UndirectedEdge) obj).getU().equals(getV()) && ((UndirectedEdge) obj).getV().equals(getU()))
            return true;

        return false;
    }
}
