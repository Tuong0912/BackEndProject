package com.example.demo.service.iplm;

import com.example.demo.model.job.Job;
import com.example.demo.model.user.User;
import com.example.demo.repository.job.IJobRepository;
import com.example.demo.repository.user.UserRepository;
import com.example.demo.service.interservice.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements IJobService {

    @Autowired
    private IJobRepository iJobRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<Job> findAll() {
        return iJobRepository.findAll();
    }

    @Override
    public Optional<Job> findById(Long id) {
        return iJobRepository.findById(id);
    }

    @Override
    public Job add(Job job) {
        return iJobRepository.save(job);
    }

    @Override
    public void delete(Long id) {
        iJobRepository.deleteById(id);
    }

    @Override
    public Iterable<Job> findAllByMinSalaryAndMaxSalary(double minSalary, double maxSalary) {
        return iJobRepository.findAllBySalaryBetween(minSalary, maxSalary);
    }


    @Override
    public Iterable<Job> findAllByQualificationAndCityAndSalaryBetweenMinSalaryAndMaxSalary(String qualification,
                                                                                            String city,
                                                                                            double minSalary,
                                                                                            double maxSalary) {
        return iJobRepository.findAllByQualificationAndCityAndSalary(qualification, city, minSalary, maxSalary);
    }


    @Override
    public Page<Job> findAllJobWhichTrue(Pageable pageable) {
        return iJobRepository.findAllByStatusIsTrue(pageable);
    }

    @Override
    public Page<Job> findAllJobWhichFalse(Pageable pageable) {
        return iJobRepository.findAllByStatusIsFalse(pageable);
    }

    @Override
    public int browseJob(long id) {
        return iJobRepository.browseAJob(id);
    }

    @Override
    public Iterable<Job> findTopByRecruitments() {
        return iJobRepository.findTopByRecruitments();
    }

    @Override
    public Iterable<Job> selectRandomFromJob() {
        return iJobRepository.selectRandomFromJob();
    }


//    @Override
//    public void applyJobs(User user, List<Long> jobIds) {
//        List<Job> jobs = iJobRepository.findAllById(jobIds);
//        user.getJobs().addAll(jobs);
//        userRepository.save(user);
//    }
//
//    @Override
//    public User getCurrentUser() {
//        return null;
//    }
//

}
