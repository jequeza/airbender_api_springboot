package com.spring.practice.airbenderapi.members;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
    private String name;
    private String affiliation;
}
