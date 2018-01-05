package org.arip.batch.item;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by Arip Hidayat on 1/4/2018.
 */
public class ContentItemWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> names) throws Exception {
        for (String name: names) {
            System.out.println("Writing data using batch writer: " + name);
        }
    }
}
