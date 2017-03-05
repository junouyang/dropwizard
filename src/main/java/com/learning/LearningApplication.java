package com.learning;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.learning.module.GeneralModule;
import com.learning.resource.ResourceModule;
import com.sun.tools.javac.jvm.Gen;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jun.ouyang on 3/4/17.
 */
public class LearningApplication extends Application<LearningConfiguration> {
    private Injector injector;
    private GeneralModule generalModule;

    public static void main(String[] args) throws Exception {
        new LearningApplication().run(args);
    }

//    @Override
//    public void initialize(Bootstrap<LearningConfiguration> bootstrap) {
//        super.initialize(bootstrap);
//    }

    @Override
    public void run(LearningConfiguration configuration, Environment environment) throws Exception {
        this.generalModule = new GeneralModule(configuration);
        registerResource(getInjector(), environment);
    }

    /**
     * Gets the resources and registers to jersey.
     * @param injector       injector
     * @param environment    DW environment
     */
    private void registerResource(Injector injector, Environment environment) {
        Set<Object> instances = injector.getInstance(ResourceModule.RESOURCE_KEY);
        instances.forEach(instance -> environment.jersey().register(instance));
    }

    public Injector getInjector( ) {
        if( injector == null ) {
            synchronized(this) {
                Set<Module> modules = new HashSet<>();
                modules.add(generalModule);
                modules.add(new ResourceModule());
                injector = Guice.createInjector(modules);
            }
        }
        return injector;
    }
}
