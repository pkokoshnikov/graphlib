package com.pkokoshnikov.graph.injection;


import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.pkokoshnikov.graph.data.DirectedAdjacencyListDataStructure;
import com.pkokoshnikov.graph.data.GraphDataStructure;
import com.pkokoshnikov.graph.data.UndirectedAdjacencyListDataStructure;
import com.pkokoshnikov.graph.edge.DirectedEdge;
import com.pkokoshnikov.graph.edge.UndirectedEdge;


public class DefaultGraphLibraryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<GraphDataStructure<DirectedEdge>>(){}).to(DirectedAdjacencyListDataStructure.class);
        bind(new TypeLiteral<GraphDataStructure<UndirectedEdge>>(){}).to(UndirectedAdjacencyListDataStructure.class);
    }
}
