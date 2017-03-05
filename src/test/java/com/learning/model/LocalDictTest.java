package com.learning.model;

import com.learning.model.impl.LocalDict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jun.ouyang on 3/4/17.
 */
@RunWith(JUnit4.class)
public class LocalDictTest {

    @Test
    public void testDict() {
        LocalDict dict = new LocalDict();
        assertThat(dict.lookUp("army")).isNotNull().extracting(word -> word.getMeaning())
                .matches((Predicate<Object[]>) objects -> ((String) objects[0]).contains("军"));
    }
}
