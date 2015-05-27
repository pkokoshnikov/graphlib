package com.pkokoshnikov.main;

import com.pkokoshnikov.graph.DirectedGraph;
import com.pkokoshnikov.graph.UndirectedGraph;
import com.pkokoshnikov.graph.factory.GraphFactory;
import java.util.Arrays;
import static com.pkokoshnikov.main.TestData.*;

/**
 * User: pako1113
 * Date: 22.05.15
 */
public class Main {
    public static void main(String [] args) {

        System.out.println("It is a simple test program\n");
        System.out.println("Lets try to create directed graph and path with");
        DirectedGraph directedGraph = new GraphFactory().createGraph(DirectedGraph.class);

        directedGraph.addVertices(Arrays.asList(VERTICES));
        directedGraph.addEdges(Arrays.asList(DIRECTED_EDGES));

        System.out.println("AbstractGraph has been created\n" + directedGraph + "\n");

        System.out.println("Now lets try to get path");
        System.out.println("We've found path " + directedGraph.getPath(VERTICES[0], VERTICES[1]) + "\n");

        System.out.println("Lets try to create undirected graph and path with");
        UndirectedGraph undirectedGraph = new GraphFactory().createGraph(UndirectedGraph.class);

        undirectedGraph.addVertices(Arrays.asList(VERTICES));
        undirectedGraph.addEdges(Arrays.asList(UNDIRECTED_EDGES));

        System.out.println("AbstractGraph has been created\n" + undirectedGraph + "\n");

        System.out.println("Now lets try to get path");
        System.out.println("We've found path " + undirectedGraph.getPath(VERTICES[0], VERTICES[7]) + "\n");
    }
}
