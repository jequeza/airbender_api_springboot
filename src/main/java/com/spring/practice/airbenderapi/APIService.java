package com.spring.practice.airbenderapi;

import com.spring.practice.airbenderapi.members.Member;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


//this is the thing responsible for using
// rest template to make the actual API call
@Service
public class APIService {

    public RestTemplate restTemplate;

    public List<Member> getMembersByAffiliation(String affiliation) {
        return null;
    }
}
