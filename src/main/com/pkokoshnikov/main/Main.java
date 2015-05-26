package com.pkokoshnikov.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pkokoshnikov.graph.DirectedGraph;
import com.pkokoshnikov.graph.UndirectedGraph;
import com.pkokoshnikov.graph.edge.DirectedEdge;
import com.pkokoshnikov.graph.edge.UndirectedEdge;
import com.pkokoshnikov.graph.factory.DirectedGraphFactory;
import com.pkokoshnikov.graph.factory.UndirectedGraphFactory;
import com.pkokoshnikov.graph.injection.DefaultGraphLibraryInjector;
import com.pkokoshnikov.graph.vertex.NumberVertex;
import com.pkokoshnikov.graph.vertex.Vertex;

import java.util.Arrays;
import java.util.List;

/**
 * User: pako1113
 * Date: 22.05.15
 */
public class Main {
    public static void main(String [] args) {
        System.out.println("It is a simple test program\n");
        System.out.println("Lets try to create directed graph and path with");
        DirectedGraph directedGraph = new DirectedGraphFactory().create();
        NumberVertex[] vertices = {new NumberVertex(0), new NumberVertex(1), new NumberVertex(2), new NumberVertex(3),
                new NumberVertex(4), new NumberVertex(5), new NumberVertex(6), new NumberVertex(7), new NumberVertex(8)};

        DirectedEdge[] directedEdges ={
            new DirectedEdge(vertices[0], vertices[7]),
            new DirectedEdge(vertices[1], vertices[0]),
            new DirectedEdge(vertices[0], vertices[2]),
            new DirectedEdge(vertices[0], vertices[3]),
            new DirectedEdge(vertices[2], vertices[4]),
            new DirectedEdge(vertices[2], vertices[5]),
            new DirectedEdge(vertices[2], vertices[0]),
            new DirectedEdge(vertices[4], vertices[6]),
            new DirectedEdge(vertices[4], vertices[7]),
            new DirectedEdge(vertices[6], vertices[0]),
            new DirectedEdge(vertices[6], vertices[8]),
            new DirectedEdge(vertices[8], vertices[1])};

        UndirectedEdge[] undirectedEdges ={
            new UndirectedEdge(vertices[1], vertices[0]),
            new UndirectedEdge(vertices[0], vertices[2]),
            new UndirectedEdge(vertices[0], vertices[3]),
            new UndirectedEdge(vertices[2], vertices[4]),
            new UndirectedEdge(vertices[2], vertices[4]),
            new UndirectedEdge(vertices[2], vertices[5]),
            new UndirectedEdge(vertices[4], vertices[6]),
            new UndirectedEdge(vertices[4], vertices[6]),
            new UndirectedEdge(vertices[4], vertices[7]),
            new UndirectedEdge(vertices[6], vertices[0]),
            new UndirectedEdge(vertices[6], vertices[8]),
            new UndirectedEdge(vertices[8], vertices[1])};

        directedGraph.addVertices(Arrays.asList(vertices));
        directedGraph.addEdges(Arrays.asList(directedEdges));


        System.out.println("Graph has been created\n" + directedGraph + "\n");

        System.out.println("Now lets try to get path");
        System.out.println("We've found path " + directedGraph.getPath(vertices[0], vertices[1]) + "\n");

        System.out.println("Lets try to create undirected graph and path with");
        UndirectedGraph undirectedGraph = new UndirectedGraphFactory().create();

        undirectedGraph.addVertices(Arrays.asList(vertices));
        undirectedGraph.addEdges(Arrays.asList(undirectedEdges));

        System.out.println("Graph has been created\n" + undirectedGraph + "\n");

        System.out.println("Now lets try to get path");
        System.out.println("We've found path " + undirectedGraph.getPath(vertices[0], vertices[7]) + "\n");
    }
}
