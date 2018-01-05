package org.arip.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arip Hidayat on 1/4/2018.
 */
@RestController
public class ContentRestController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job processJob;

    @GetMapping("/startJob")
    public String startJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

            jobLauncher.run(processJob, jobParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Batch job has been invoked";
    }
}
