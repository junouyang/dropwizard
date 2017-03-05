package com.learning.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.learning.LearningConfiguration;
import com.learning.model.api.IDict;
import com.learning.model.impl.LocalDict;
import com.learning.resource.WordResource;
import com.learning.resource.api.IWordResource;

/**
 * Created by jun.ouyang on 3/4/17.
 */
public class GeneralModule implements Module {
    private LearningConfiguration learningConfiguration;

    public GeneralModule(LearningConfiguration learningConfiguration) {
        this.learningConfiguration = learningConfiguration;
    }

    @Override
    public void configure(Binder binder) {
        binder.bind(IWordResource.class).to(WordResource.class);
        binder.bind(IDict.class).toInstance(new LocalDict(learningConfiguration.getDictPath()));
    }
}
