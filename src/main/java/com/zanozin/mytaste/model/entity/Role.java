package com.zanozin.mytaste.model.entity;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
@NoArgsConstructor
public enum Role implements GrantedAuthority {

    USER("USER")

    ,;

    @NonNull
    private String stringValue;

    @Override
    public String getAuthority() {
        return stringValue;
    }
}
