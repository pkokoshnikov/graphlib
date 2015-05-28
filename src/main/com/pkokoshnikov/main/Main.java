package com.pkokoshnikov.main;

import com.google.inject.TypeLiteral;
import com.pkokoshnikov.graph.DirectedGraph;
import com.pkokoshnikov.graph.UndirectedGraph;
import com.pkokoshnikov.graph.data.DirectedAdjacencyListDataStructure;
import com.pkokoshnikov.graph.data.GraphDataStructure;
import com.pkokoshnikov.graph.edge.DirectedEdge;
import com.pkokoshnikov.graph.factory.GraphFactory;
import com.pkokoshnikov.graph.injection.DefaultGraphLibraryModule;
import com.pkokoshnikov.graph.vertex.Vertex;

import java.util.Arrays;
import java.util.List;

import static com.pkokoshnikov.main.TestData.*;

/**
 * User: pako1113
 * Date: 22.05.15
 */
public class Main {
    public static void main(String [] args) {

        System.out.println("It is a simple test program\n");
        System.out.println("Lets try to create directed graph and path with");
        //You can use your own module in factory for binding data structure
        DirectedGraph directedGraph = new GraphFactory(new ExtendedDefaultGraphLibraryModule()).createGraph(DirectedGraph.class);

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

    /**
     * This class is used to demonstrate the possibility to use your own data structure in code
     */
    public static class ExtendedDirectedAdjacencyListDataStructure extends DirectedAdjacencyListDataStructure {
        @Override
        public List<Vertex> getAdjacencyList(Vertex u) {
            System.out.println("method getAdjacencyList is called from extended DirectedAdjacencyListDataStructure");
            return super.getAdjacencyList(u);
        }
    }

    public static class ExtendedDefaultGraphLibraryModule extends DefaultGraphLibraryModule {
        @Override
        protected void bindDirectedDataStructure() {
            bind(new TypeLiteral<GraphDataStructure<DirectedEdge>>(){}).to(ExtendedDirectedAdjacencyListDataStructure.class);
        }
    }
}
