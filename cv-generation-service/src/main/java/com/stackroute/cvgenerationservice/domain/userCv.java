package com.stackroute.cvgenerationservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Lob;
import javax.persistence.Transient;

@Document
@Data
public class userCv {
    @Transient
    public static final String SEQUENCE_NAME="user_sequence";
    @Id
    private int cvId;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private String address;
    private String[] careerObjective;
    private String[] education;
    private String[] experience;
    private String[] project;
    private String[] skills;
    private String[] languages;
    private byte[] picture;
}

