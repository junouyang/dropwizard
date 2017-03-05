package com.learning.resource;

import com.google.inject.*;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.multibindings.Multibinder;
import com.learning.annotation.Resource;
import com.learning.resource.api.IWordResource;

import java.util.Set;

/**
 * Created by jun.ouyang on 3/4/17.
 */
public class ResourceModule extends PrivateModule {
    public static Key<Set<Object>> RESOURCE_KEY = Key.get(new TypeLiteral<Set<Object>>() {
    }, Resource.class);
    private Multibinder<Object> resourceBinder;

    @Override
    protected void configure() {
        resourceBinder = Multibinder.newSetBinder(binder(), Object.class, Resource.class);
        expose(RESOURCE_KEY);
        addResources();
    }

    /**
     * Binder to bind resources.
     *
     * @return
     */
    protected LinkedBindingBuilder<Object> bindResource() {
        return resourceBinder.addBinding();
    }

    protected void addResources(){
        bindResource().to(IWordResource.class);
    }
}