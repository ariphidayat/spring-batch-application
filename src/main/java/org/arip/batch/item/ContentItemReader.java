package org.arip.batch.item;

import org.springframework.batch.item.ItemReader;

/**
 * Created by Arip Hidayat on 1/4/2018.
 */
public class ContentItemReader implements ItemReader<String> {

    private String[] names = {
            "Arip Hidayat",
            "Alisiana Ulfah",
            "Satya"
    };

    private int count = 0;

    @Override
    public String read() throws Exception {
        if (count < names.length) {
            return names[count++];
        }
        else {
            count = 0;
        }

        return null;
    }
}
