package com.pkokoshnikov.graph.factory;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.pkokoshnikov.graph.AbstractGraph;
import com.pkokoshnikov.graph.DirectedGraph;

import com.pkokoshnikov.graph.UndirectedGraph;
import com.pkokoshnikov.graph.injection.DefaultGraphLibraryModule;
import org.apache.log4j.Logger;

/**
 * User: pako1113
 * Date: 25.05.15
 * This factory is used for creating graphs
 */
public class GraphFactory {
    final static Logger logger = Logger.getLogger(GraphFactory.class);
    final protected Injector injector;

    /**
     * Constructor
     * @param module is used for customization of creating data structure for graphs
     */
    public <T extends Module> GraphFactory(Class<T> module) throws IllegalAccessException, InstantiationException {
        this.injector = Guice.createInjector(module.newInstance());
    }

    /**
     * Default constructor with default module
     */
    public GraphFactory() {
        this.injector =  Guice.createInjector(new DefaultGraphLibraryModule());
    }

    public <T extends AbstractGraph> T  createGraph(Class<T> type) {
        logger.debug("createGraph method has been called type = " + type.getName());
        return injector.getInstance(type);
    }

}
