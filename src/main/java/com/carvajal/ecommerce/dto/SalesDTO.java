package com.carvajal.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesDTO {
    private String name;
    private String description;
    private Long price;
    private String picture;
    private Long quantity;
    private Date dateSale;
    private Boolean state;
}
