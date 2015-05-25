package com.pkokoshnikov.graph.factory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pkokoshnikov.graph.Graph;
import com.pkokoshnikov.graph.injection.DefaultGraphLibraryInjector;

/**
 * User: pako1113
 * Date: 25.05.15
 */
public abstract class GraphFactory<T extends Graph> {
    final protected Injector injector;

    protected GraphFactory(Injector injector) {
        this.injector = injector;
    }

    protected GraphFactory() {
        this.injector =  Guice.createInjector(new DefaultGraphLibraryInjector());
    }

    abstract public T create();
}
