package com.learning.model.api;

import com.learning.model.impl.Word;

/**
 * Created by jun.ouyang on 3/4/17.
 */
public interface IDict {
    Word lookUp(String word);
}
