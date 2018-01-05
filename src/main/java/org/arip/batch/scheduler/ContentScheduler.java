package org.arip.batch.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Arip Hidayat on 1/5/2018.
 */
@Component
public class ContentScheduler {

    @Autowired
    private Job processJob;

    @Autowired
    private JobLauncher jobLauncher;

    @Scheduled(fixedRate = 5000) //run every 5 sec
    public void printNames() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();

            jobLauncher.run(processJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
