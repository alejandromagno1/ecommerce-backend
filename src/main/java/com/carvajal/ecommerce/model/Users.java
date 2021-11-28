package com.carvajal.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_rol")
    private Long idRol;
	
	@Column(name = "usr")
    private String user;

    @Column(name = "passwd")
    private String pwd;

    @Column(name = "name")
    private String nameUser;

    @Column(name = "email")
    private String eMail;

    @Column(name = "state")
    private Boolean state;
}