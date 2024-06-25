package com.manthan.manthanauthserver.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String phone;
    private String otp;
}
