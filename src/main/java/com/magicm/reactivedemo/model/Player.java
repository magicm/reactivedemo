package com.magicm.reactivedemo.model;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;


@Document
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String team;

    private String imageUrl;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

}

