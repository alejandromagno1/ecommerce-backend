package com.carvajal.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Products implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_line")
    private long idLine;

    @Column(name = "name")
    private String nameProd;

    @Column(name = "description")
    private String descProd;

    @Column(name = "price")
    private Long price;

    @Column(name = "stock")
    private Long stock;

    @Column(name = "minimum")
    private Long minimum;

    @Column(name = "picture")
    private String urlPicture;

    @Column(name = "state")
    private Boolean state;
}