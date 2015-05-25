package com.pkokoshnikov.graph.factory;

import com.google.inject.Injector;
import com.pkokoshnikov.graph.DirectedGraph;
import com.pkokoshnikov.graph.Graph;

/**
 * User: pako1113
 * Date: 25.05.15
 */
public class DirectedGraphFactory extends GraphFactory<DirectedGraph> {

    public DirectedGraphFactory(Injector injector) {
        super(injector);
    }

    public DirectedGraphFactory() {
        super();
    }

    @Override
    public DirectedGraph create() {
        return injector.getInstance(DirectedGraph.class);
    }
}
