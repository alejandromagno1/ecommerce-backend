package com.carvajal.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="roles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Roles implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String nameRol;

    @Column(name = "admin")
    private Boolean admin;

    @Column(name = "state")
    private Boolean state;
}