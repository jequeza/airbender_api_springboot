package com.spring.practice.airbenderapi.members;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {

    @Mock
    public MemberService memberServiceMock;

    @InjectMocks
    public MemberController controller;

    @Test
    public void getMembers_returnsListOfMembers_whenMembersFound() {
        List<Member> members = new ArrayList<>();
        members.add(Member.builder().name("Jack").build());
        members.add(Member.builder().name("Jill").build());

        ResponseEntity<List<Member>> expected = new ResponseEntity<>(members, HttpStatus.OK);

        when(memberServiceMock.getMembers(anyString())).thenReturn(members);

        ResponseEntity<List<Member>> actual = controller.getMembers("Fire Nation");

        assertThat(actual).isEqualTo(expected);
        verify(memberServiceMock).getMembers("Fire Nation");
    }

    @Test
    public void getMembers_returnsEmptyList_and204_whenNoMembersFound() {
        List<Member> members = new ArrayList<>();
        ResponseEntity<List<Member>> expected = new ResponseEntity<>(members, HttpStatus.NO_CONTENT);

        when(memberServiceMock.getMembers(anyString())).thenReturn(members);

        ResponseEntity<List<Member>> actual = controller.getMembers("Fire Nation");

        assertThat(actual).isEqualTo(expected);
        verify(memberServiceMock).getMembers("Fire Nation");
    }
}