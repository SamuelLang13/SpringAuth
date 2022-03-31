package com.example.auth.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.auth.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_WRITE,COURSE_READ,STUDENT_READ,STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ,STUDENT_READ));

    private final Set<ApplicationUserPermission> permissionSet;

    ApplicationUserRole(Set<ApplicationUserPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<ApplicationUserPermission> getPermissionSet() {
        return permissionSet;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissionSet().stream()
                .map(permissionSet -> new SimpleGrantedAuthority(permissionSet.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;

    }
}
