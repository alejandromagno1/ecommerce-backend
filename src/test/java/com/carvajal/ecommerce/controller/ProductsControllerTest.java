package com.carvajal.ecommerce.controller;

import com.carvajal.common.GenericResponse;
import com.carvajal.common.error.CoreException;
import com.carvajal.ecommerce.model.Products;
import com.carvajal.ecommerce.repository.IProductsRepository;
import com.carvajal.ecommerce.service.ProductsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;

class ProductsControllerTest {
    IProductsRepository _repositoryMock = Mockito.mock(IProductsRepository.class);

    @Autowired
    ProductsService _service = new ProductsService(_repositoryMock);

    @Autowired
    ProductsController _controller = new ProductsController(_service);

    @BeforeEach
    void setUp() throws CoreException {
        Products data = new Products();
        data.setId(1L);
        data.setIdLine(1L);
        data.setNameProd("Chaqueta corta vientos");
        data.setDescProd("Chaqueta en poliester, impermeable");
        data.setPrice(230000L);
        data.setStock(33L);
        data.setMinimum(5L);
        data.setUrlPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-TrRs7BlgRAMnXGaacbOOonuA5muxHCTASA&usqp=CAU");
        data.setState(true);

        List<Products> list = new ArrayList<>();
        list.add(data);

        Mockito.when(_repositoryMock.findAll()).thenReturn(list);
    }

    @Test
    void get() {
        GenericResponse response = _controller.get();
        Assertions.assertNotNull(response);
    }

    @Test
    void getFailed() {
        Mockito.when(_repositoryMock.findAll()).thenThrow(NullPointerException.class);

        GenericResponse response = _controller.get();
        Assertions.assertEquals(500, response.getErrorCode());
    }

    @Test
    void getOne() {
        GenericResponse response = _controller.get(1L);
        Assertions.assertNotNull(response);
    }

    @Test
    void getOneFailed() {
        Mockito.when(_repositoryMock.getById(anyLong())).thenThrow(NullPointerException.class);

        GenericResponse response = _controller.get(1L);
        Assertions.assertEquals(500, response.getErrorCode());
    }

    @Test
    void save() {
        Products data = new Products();
        data.setId(1L);
        data.setIdLine(1L);
        data.setNameProd("Chaqueta corta vientos");
        data.setDescProd("Chaqueta en poliester, impermeable");
        data.setPrice(230000L);
        data.setStock(33L);
        data.setMinimum(5L);
        data.setUrlPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-TrRs7BlgRAMnXGaacbOOonuA5muxHCTASA&usqp=CAU");
        data.setState(true);

        GenericResponse response = _controller.save(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void saveFailed() {
        Products data = new Products();
        data.setId(1L);
        data.setIdLine(1L);
        data.setNameProd("Chaqueta corta vientos");
        data.setDescProd("Chaqueta en poliester, impermeable");
        data.setPrice(230000L);
        data.setStock(33L);
        data.setMinimum(5L);
        data.setUrlPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-TrRs7BlgRAMnXGaacbOOonuA5muxHCTASA&usqp=CAU");
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Products.class))).thenThrow(NullPointerException.class);

        GenericResponse response = _controller.save(data);
        Assertions.assertEquals(500, response.getErrorCode());
    }

    @Test
    void edit() {
        Products data = new Products();
        data.setId(1L);
        data.setIdLine(1L);
        data.setNameProd("Chaqueta corta vientos");
        data.setDescProd("Chaqueta en poliester, impermeable");
        data.setPrice(230000L);
        data.setStock(33L);
        data.setMinimum(5L);
        data.setUrlPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-TrRs7BlgRAMnXGaacbOOonuA5muxHCTASA&usqp=CAU");
        data.setState(true);

        GenericResponse response = _controller.edit(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void editFailed() {
        Products data = new Products();
        data.setId(1L);
        data.setIdLine(1L);
        data.setNameProd("Chaqueta corta vientos");
        data.setDescProd("Chaqueta en poliester, impermeable");
        data.setPrice(230000L);
        data.setStock(33L);
        data.setMinimum(5L);
        data.setUrlPicture("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-TrRs7BlgRAMnXGaacbOOonuA5muxHCTASA&usqp=CAU");
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Products.class))).thenThrow(NullPointerException.class);

        GenericResponse response = _controller.edit(data);
        Assertions.assertEquals(500, response.getErrorCode());
    }

    @Test
    void delete() {
        GenericResponse response = _controller.delete(1L);
        Assertions.assertNotNull(response);
    }

    @Test
    void deleteFailed() {
        doThrow(NullPointerException.class).when(_repositoryMock).deleteById(anyLong());

        GenericResponse response = _controller.delete(1L);
        Assertions.assertEquals(500, response.getErrorCode());
    }
}