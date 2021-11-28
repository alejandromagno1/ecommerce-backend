package com.carvajal.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    private Long id;
    private Long idRol;
    private String user;
    private String pwd;
    private String nameUser;
    private String eMail;
    private Boolean admin;
    private Boolean state;
}
