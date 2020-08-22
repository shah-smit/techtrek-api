package com.techtrek.customerservice.config.user_security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.techtrek.customerservice.config.user_security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    PARTICIPANT(Sets.newHashSet(CUSTOMER_READ,CUSTOMER_WRITE, TRANSACTION_READ, TRANSACTION_WRITE)),
    ADMIN(Sets.newHashSet(CUSTOMER_READ,CUSTOMER_WRITE, TRANSACTION_READ, TRANSACTION_WRITE, PARTICIPANT_READ, PARTICIPANT_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
