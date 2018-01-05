package org.arip.batch.item;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Arip Hidayat on 1/4/2018.
 */
public class ContentItemProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String name) throws Exception {
        return name.toUpperCase();
    }
}
