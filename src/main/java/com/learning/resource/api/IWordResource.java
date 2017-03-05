package com.learning.resource.api;

import com.learning.model.impl.Word;

/**
 * Created by jun.ouyang on 3/4/17.
 */
public interface IWordResource {
    Word lookUp(String word);
}
