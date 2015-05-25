package com.pkokoshnikov.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pkokoshnikov.graph.DirectedGraph;
import com.pkokoshnikov.graph.UndirectedGraph;
import com.pkokoshnikov.graph.injection.AppInjector;
import com.pkokoshnikov.graph.vertex.NumberVertex;

/**
 * User: pako1113
 * Date: 22.05.15
 */
public class Main {
    public static void main(String [] args) {
        Injector injector = Guice.createInjector(new AppInjector());

        System.out.println("It is a simple test program\n");
        System.out.println("Lets try to create directed graph and path with");
        DirectedGraph directedGraph = injector.getInstance(DirectedGraph.class);
        NumberVertex[] vertices = {new NumberVertex(0), new NumberVertex(1), new NumberVertex(2), new NumberVertex(3),
                new NumberVertex(4), new NumberVertex(5), new NumberVertex(6), new NumberVertex(7), new NumberVertex(8)};

        directedGraph.addVertices(vertices);
        directedGraph.addEdge(vertices[0], vertices[7]);
        directedGraph.addEdge(vertices[1], vertices[0]);
        directedGraph.addEdge(vertices[0], vertices[2]);
        directedGraph.addEdge(vertices[0], vertices[3]);
        directedGraph.addEdge(vertices[2], vertices[4]);
        directedGraph.addEdge(vertices[2], vertices[5]);
        directedGraph.addEdge(vertices[2], vertices[0]);
        directedGraph.addEdge(vertices[4], vertices[6]);
        directedGraph.addEdge(vertices[4], vertices[7]);
        directedGraph.addEdge(vertices[6], vertices[0]);
        directedGraph.addEdge(vertices[6], vertices[8]);
        directedGraph.addEdge(vertices[8], vertices[1]);


        System.out.println("Graph has been created\n" + directedGraph + "\n");

        System.out.println("Now lets try to get path");
        System.out.println("We've found path " + directedGraph.getPath(vertices[0], vertices[1]) + "\n");

        System.out.println("Lets try to create undirected graph and path with");
        UndirectedGraph undirectedGraph = injector.getInstance(UndirectedGraph.class);

        undirectedGraph.addVertices(vertices);
        undirectedGraph.addEdge(vertices[1], vertices[0]);
        undirectedGraph.addEdge(vertices[0], vertices[2]);
        undirectedGraph.addEdge(vertices[0], vertices[3]);
        undirectedGraph.addEdge(vertices[2], vertices[4]);
        undirectedGraph.addEdge(vertices[2], vertices[5]);
        undirectedGraph.addEdge(vertices[2], vertices[0]);
        undirectedGraph.addEdge(vertices[4], vertices[6]);
        undirectedGraph.addEdge(vertices[4], vertices[7]);
        undirectedGraph.addEdge(vertices[6], vertices[0]);
        undirectedGraph.addEdge(vertices[6], vertices[8]);
        undirectedGraph.addEdge(vertices[8], vertices[1]);

        System.out.println("Graph has been created\n" + undirectedGraph + "\n");

        System.out.println("Now lets try to get path");
        System.out.println("We've found path " + undirectedGraph.getPath(vertices[0], vertices[1]) + "\n");
    }
}
