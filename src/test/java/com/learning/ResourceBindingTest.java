package com.learning;

/**
 * Created by jun.ouyang on 3/4/17.
 */

import com.learning.resource.WordResource;
import com.learning.resource.api.IWordResource;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test resource binding API.
 */
@RunWith(MockitoJUnitRunner.class)
public class ResourceBindingTest extends LearningApplicationBaseTest {

    @Before
    public void setUp() {
        super.setUp();
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test bound resources are available in application and don't include instances bound to Object.class
     * without Resource annotation.
     */
    @Test
    public void testResourceBinding() throws Exception {
        application.run(configuration, environment);
        JerseyEnvironment jersey = environment.jersey();
        Set<Object> resources = jersey.getResourceConfig().getInstances();
        IWordResource lookupInstance = application.getInjector().getInstance(IWordResource.class);
        assertThat(resources).contains(lookupInstance);
        assertThat(lookupInstance).isInstanceOf(WordResource.class);
    }
}
