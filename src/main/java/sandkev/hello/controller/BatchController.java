package sandkev.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sandkev.hello.config.SpringBatchConfig;
import sandkev.hello.config.SpringConfig;

@Controller
@Slf4j
//@RequestMapping("/api/v1")
public class BatchController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    ApplicationContext context;

    @GetMapping("/batch") ///{batchJobName}
    public String playGame(
            @RequestParam(name="batchJobName", required=false)
                    String batchJobName,
            Model model) {

        if(batchJobName==null){
            batchJobName = "firstBatchJob";
        }

        //register();
        final Job job = (Job) context.getBean(batchJobName);

        String theOutcome = "error";
        if(job == null){
            theOutcome = "error";
        }else {
            runJob(job, batchJobName);
            theOutcome = "OK";
        }

        model.addAttribute("outcome", theOutcome);
        return "batchResults";

    }

    //AnnotationConfigApplicationContext
    private void runJob(Job job, String batchJobName) {
        //final JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        //final Job job = (Job) context.getBean(batchJobName);

        log.info("Starting the batch job: {}", batchJobName);
        try {
            // To enable multiple execution of a job with the same parameters
            JobParameters jobParameters = new JobParametersBuilder().addString("jobID", String.valueOf(System.currentTimeMillis()))
                    .toJobParameters();
            final JobExecution execution = jobLauncher.run(job, jobParameters);
            log.info("Job Status : {}", execution.getStatus());
        } catch (final Exception e) {
            e.printStackTrace();
            log.error("Job failed {}", e.getMessage());
        }
    }

}
