package com.learning.model.impl;

import com.learning.model.api.IDict;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jun.ouyang on 3/4/17.
 */
public class LocalDict implements IDict {
    private static Logger logger = LoggerFactory.getLogger(LocalDict.class);
    private Map<String, Word> dict = new HashMap<>();

    public LocalDict(String path) {
        try {
            String content = IOUtils.toString(this.getClass().getResourceAsStream(path), Charset.forName("utf-8"));
            CSVParser parse = CSVParser.parse(content, CSVFormat.DEFAULT.withHeader("word","meaning"));
            parse.forEach(csvRecord -> {
                Word word = new Word(0, csvRecord.get("word"), csvRecord.get("meaning"), "//");
                dict.put(word.getWord(), word);
            });
        } catch (IOException e) {
            logger.error("Failed to read local dictionary!", e);
        }

    }

    @Override
    public Word lookUp(String word) {
        return dict.get(word);
    }
}
