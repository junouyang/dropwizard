package com.learning;

/**
 * Created by jun.ouyang on 3/4/17.
 */

import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.setup.Environment;
import org.junit.Before;

public class LearningApplicationBaseTest {
    protected LearningApplication application;
    protected LearningConfiguration configuration = new LearningConfiguration();
    protected Environment environment = new Environment("test", new ObjectMapper(), null, new MetricRegistry(), this.getClass().getClassLoader());

    @Before
    public void setUp() {
        application = new LearningApplication();
    }
}
