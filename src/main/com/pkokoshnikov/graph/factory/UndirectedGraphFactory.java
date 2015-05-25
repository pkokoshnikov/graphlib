package com.pkokoshnikov.graph.factory;

import com.google.inject.Injector;
import com.pkokoshnikov.graph.UndirectedGraph;

/**
 * User: pako1113
 * Date: 25.05.15
 */
public class UndirectedGraphFactory extends GraphFactory<UndirectedGraph> {

    public UndirectedGraphFactory(Injector injector) {
        super(injector);
    }

    public UndirectedGraphFactory() {
        super();
    }

    @Override
    public UndirectedGraph create() {
        return injector.getInstance(UndirectedGraph.class);
    }
}
