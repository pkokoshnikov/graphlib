package com.pkokoshnikov.graph.injection;


import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.pkokoshnikov.graph.data.AdjListDataStructure;
import com.pkokoshnikov.graph.data.DirAdjListDataStructure;
import com.pkokoshnikov.graph.data.GraphDataStructure;
import com.pkokoshnikov.graph.data.UndirAdjListDataStructure;
import com.pkokoshnikov.graph.edge.DirectedEdge;
import com.pkokoshnikov.graph.edge.UndirectedEdge;


public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<GraphDataStructure<DirectedEdge>>(){}).to(DirAdjListDataStructure.class);
        bind(new TypeLiteral<GraphDataStructure<UndirectedEdge>>(){}).to(UndirAdjListDataStructure.class);
    }
}
