package com.techtrek.customerservice.test_data_provider;

import com.techtrek.customerservice.config.user_security.ApplicationUserRole;
import com.techtrek.customerservice.participant.Participant;
import com.techtrek.customerservice.participant_adapter.ParticipantEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ParticipantTestDataProvider {
    public static Participant buildParticipant(){
        return Participant.builder()
                .password("Smit")
                .username("Smit Shah")
                .isActive(true)
                .build();
    }

    public static ParticipantEntity buildParticipantEntity(){
        ParticipantEntity participantEntity = new ParticipantEntity();
        participantEntity.setUsername("Smit Shah");
        participantEntity.setPassword("Smit");
        participantEntity.setActive(true);
        participantEntity.setAuthenticationId("Smit");

        return participantEntity;
    }

    public static String[] getAdminAuthorities(){
        Set<SimpleGrantedAuthority> grantedAuthorities = ApplicationUserRole.ADMIN.getGrantedAuthorities();
        String[] aa = new String[grantedAuthorities.size()];
        List<String> collect = grantedAuthorities.stream().map(SimpleGrantedAuthority::getAuthority).collect(Collectors.toList());
        System.out.println("HAHA "+ collect);
        for (int i = 0, collectSize = collect.size(); i < collectSize; i++) {
            String s = collect.get(i);
            aa[i] = s;
        }

        return aa;
    }
}
