package com.learning.resource;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.learning.model.api.IDict;
import com.learning.model.impl.Word;
import com.learning.resource.api.IWordResource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by jun.ouyang on 3/4/17.
 */
@Path("/words")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class WordResource implements IWordResource {

    @Inject
    private IDict dict;

    @Override
    @GET
    @Timed
    @Path("{word}")
    public Word lookUp(@PathParam("word") String word) {
        return dict.lookUp(word);
    }
}
