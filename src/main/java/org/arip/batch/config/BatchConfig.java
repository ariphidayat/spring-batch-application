package org.arip.batch.config;

import org.arip.batch.item.ContentItemProcessor;
import org.arip.batch.item.ContentItemReader;
import org.arip.batch.item.ContentItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Arip Hidayat on 1/4/2018.
 */
@Configuration
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job processJob() {
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer()).listener(listener())
                .flow(orderStep1()).end()
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new BatchJobListener();
    }

    @Bean
    public Step orderStep1() {
        return stepBuilderFactory.get("orderStep1").<String, String> chunk(1)
                .reader(new ContentItemReader())
                .processor(new ContentItemProcessor())
                .writer(new ContentItemWriter())
                .build();
    }

    @Bean
    public ResourcelessTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }
}
