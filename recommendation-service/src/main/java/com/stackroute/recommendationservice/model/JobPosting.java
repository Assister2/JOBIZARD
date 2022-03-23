package com.stackroute.recommendationservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.ArrayList;

@NodeEntity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobPosting {
    @Id
    private long jobId;
    private ArrayList skillsRequired;
    private String jobRole;
}
