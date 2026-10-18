package com.example.jwtrolebased.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static com.example.jwtrolebased.user.Permission.*;


@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_CREATE,
                    ADMIN_DELETE,
                    ADMIN_UPDATE,
                    DOCTOR_CREATE,
                    DOCTOR_UPDATE,
                    DOCTOR_DELETE,
                    DOCTOR_READ,
                    PATIENT_CREATE,
                    PATIENT_UPDATE,
                    PATIENT_DELETE,
                    PATIENT_READ
            )
    ),
    DOCTOR(
            Set.of(
                    DOCTOR_CREATE,
                    DOCTOR_UPDATE,
                    DOCTOR_DELETE,
                    DOCTOR_READ
            )
    ),
    PATIENT(
            Set.of(
                    PATIENT_CREATE,
                    PATIENT_UPDATE,
                    PATIENT_DELETE,
                    PATIENT_READ
            )
    );

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
            var authorities = new ArrayList<>(getPermissions()
                    .stream()
                    .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                    .toList());
            authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
            return authorities;
    }
}
