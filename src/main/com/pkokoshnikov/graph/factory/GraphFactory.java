package com.pkokoshnikov.graph.factory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.pkokoshnikov.graph.AbstractGraph;
import com.pkokoshnikov.graph.DirectedGraph;

import com.pkokoshnikov.graph.UndirectedGraph;
import com.pkokoshnikov.graph.injection.DefaultGraphLibraryModule;

/**
 * User: pako1113
 * Date: 25.05.15
 */
public class GraphFactory {
    final protected Injector injector;

    @Inject
    public GraphFactory(Module module) {
        this.injector = Guice.createInjector(module);
    }

    public GraphFactory() {
        this.injector =  Guice.createInjector(new DefaultGraphLibraryModule());
    }

    public <T extends AbstractGraph> T  createGraph(Class<T> type) {
        return injector.getInstance(type);
    }

}
