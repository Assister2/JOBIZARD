package com.stackroute.recommendationservice.config;

import com.stackroute.recommendationservice.exception.JobAlreadyPresentException;
import com.stackroute.recommendationservice.exception.UserAlreadyExistsException;
import com.stackroute.recommendationservice.model.JobDetails;
import com.stackroute.recommendationservice.model.Seeker;
import com.stackroute.recommendationservice.service.RecommendationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class Consumer {
    @Autowired
    private RecommendationService recommendationService;
    private int id;

    @RabbitListener(queues = "userQueue")
    public void getUser(Seeker seeker) throws UserAlreadyExistsException {
        recommendationService.saveUser(seeker);
    }

    @RabbitListener(queues = "userQueue")
    public void getJob(JobDetails job) throws JobAlreadyPresentException {
        recommendationService.savejob(job);
    }
}
