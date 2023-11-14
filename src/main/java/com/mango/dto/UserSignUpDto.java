package com.mango.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserSignUpDto {
    String email; // unique id
    String nickName;
    String password;
}
