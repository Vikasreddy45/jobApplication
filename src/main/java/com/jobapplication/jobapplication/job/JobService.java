package com.jobapplication.jobapplication.job;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    //private List<Job> jobs = new ArrayList<>();

    JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private Long nextId = 1L;
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public void createJob(Job job){
        job.setId(nextId++);
        jobRepository.save(job);
        //jobs.add(job);
        return;
    }

    public Job getJobById(Long id){
        return jobRepository.findById(id).orElse(null);
    }

    public boolean deleteJob(Long id){

        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean updateJob(Long id, Job job) {
        Optional<Job> jobsOptional = jobRepository.findById(id);

        if (jobsOptional.isPresent()) {
            Job job1 = jobsOptional.get();
            job1.setId(job.getId());
            job1.setDescription(job.getDescription());
            job1.setTitle(job.getTitle());
            job1.setMinSalary(job.getMinSalary());
            job1.setMinSalary(job.getMinSalary());
            job1.setLocation(job.getLocation());
            jobRepository.save(job1);
            return true;
        }
        return false;
    }

}
