package com.spring.practice.airbenderapi.members;

import com.spring.practice.airbenderapi.APIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final APIService apiService;
    private final MemberRepository memberRepository;

    public List<Member> getMembers(String affiliation) {
        List<Member> members = memberRepository.findByAffiliation(affiliation);
        if (members.isEmpty()) {
             members = apiService.getMembersByAffiliation(affiliation);
            return members;
        }
        return members;
    }
}
