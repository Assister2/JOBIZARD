package com.stackroute.recruitmentservice.model;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobDetails {
    private Long jobId;
    private String experienceRequired;
    private List<String> skillsRequired;
    private String jobRole;
    private Long salary;
    private String lastDate;
    private List<String>  jobLocation;
    private String jobDescription;

}
