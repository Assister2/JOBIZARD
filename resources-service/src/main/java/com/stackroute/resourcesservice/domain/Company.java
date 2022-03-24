package com.stackroute.resourcesservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "companyReviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    private int companyId;
    @Indexed(unique = true)
    private String companyName;
    private byte[] companyLogo;
    private List<Review> reviews;
}
