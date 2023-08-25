package com.example.spring.dto;

import lombok.*;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
    private String id;
    private String name;
    private int age;
    private String addr;
}