package com.spring.practice.airbenderapi.members;

import com.spring.practice.airbenderapi.APIService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    @Mock
    private APIService apiService;

    @Mock
    private MemberRepository repository;

    @InjectMocks
    private MemberService service;

    @Test
    public void getMembers_looksForMembersInDB() {
        //call repository with affiliation to find members
        List<Member> members = new ArrayList<>();
        members.add(Member.builder().name("Jack").affiliation("Fire Nation").build());
        members.add(Member.builder().name("Jill").affiliation("Fire Nation").build());
        members.add(Member.builder().name("John").affiliation("Fire Nation").build());

        when(repository.findByAffiliation(anyString())).thenReturn(members);
        //returns list of members if members found
        List<Member> actual = service.getMembers("Fire Nation");
        assertThat(actual).isEqualTo(members);
        assertThat(members.size()).isEqualTo(3);
        verifyNoInteractions(apiService);
    }

    @Test
    public void getMembers_callsAPIservice_ifNoMembersFoundInDB() {
        List<Member> members = new ArrayList<>();
        // calls repository with affiliation to find members
        //repository returns empty list
        //call api service
        //verify that you call api service
        when(repository.findByAffiliation(anyString())).thenReturn(members);
        List<Member> actual = service.getMembers("Fire Nation");
        assertThat(actual).isEqualTo(members);
        verify(apiService).getMembersByAffiliation("Fire Nation");

    }
}