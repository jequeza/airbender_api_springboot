package com.spring.practice.airbenderapi.members;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService service;


    @Test
    public void getMembers_looksForMembersInDB() {

    }

    @Test
    public void getMembers_callsAPI() {
    }
}