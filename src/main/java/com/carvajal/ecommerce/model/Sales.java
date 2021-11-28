package com.carvajal.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="sales")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Sales implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "quantity")
    private Long quantity;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd", timezone="America/Bogota")
    @Column(name = "date")
    private Date dateSale;

    @Column(name = "state")
    private Boolean state;
}