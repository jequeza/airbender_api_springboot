package com.spring.practice.airbenderapi.members;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    public MemberService memberService;

    @GetMapping("/search")
    public ResponseEntity<List<Member>> getMembers(@PathVariable String category) {
        List<Member> members = memberService.getMembers(category);
        HttpStatus status = HttpStatus.OK;
        if (members.isEmpty()) {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(members, status);
    }

}
