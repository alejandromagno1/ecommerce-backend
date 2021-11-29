package com.carvajal.ecommerce.controller;

import com.carvajal.common.GenericResponse;
import com.carvajal.common.error.CoreException;
import com.carvajal.ecommerce.model.Sales;
import com.carvajal.ecommerce.repository.ISalesRepository;
import com.carvajal.ecommerce.service.SalesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;

class SalesControllerTest {
    ISalesRepository _repositoryMock = Mockito.mock(ISalesRepository.class);

    @Autowired
    SalesService _service = new SalesService(_repositoryMock);

    @Autowired
    SalesController _controller = new SalesController(_service);

    @BeforeEach
    void setUp() throws CoreException {
        Date myDateObj = new Date();

        Sales data = new Sales();
        data.setId(1L);
        data.setIdUser(1L);
        data.setIdProduct(1L);
        data.setQuantity(1L);
        data.setDateSale(myDateObj);
        data.setState(true);

        List<Sales> list = new ArrayList<>();
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
        Date myDateObj = new Date();

        Sales data = new Sales();
        data.setId(1L);
        data.setIdUser(1L);
        data.setIdProduct(1L);
        data.setQuantity(1L);
        data.setDateSale(myDateObj);
        data.setState(true);

        GenericResponse response = _controller.save(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void saveFailed() {
        Date myDateObj = new Date();

        Sales data = new Sales();
        data.setId(1L);
        data.setIdUser(1L);
        data.setIdProduct(1L);
        data.setQuantity(1L);
        data.setDateSale(myDateObj);
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Sales.class))).thenThrow(NullPointerException.class);

        GenericResponse response = _controller.save(data);
        Assertions.assertEquals(500, response.getErrorCode());
    }

    @Test
    void edit() {
        Date myDateObj = new Date();

        Sales data = new Sales();
        data.setId(1L);
        data.setIdUser(1L);
        data.setIdProduct(1L);
        data.setQuantity(1L);
        data.setDateSale(myDateObj);
        data.setState(true);

        GenericResponse response = _controller.edit(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void editFailed() {
        Date myDateObj = new Date();

        Sales data = new Sales();
        data.setId(1L);
        data.setIdUser(1L);
        data.setIdProduct(1L);
        data.setQuantity(1L);
        data.setDateSale(myDateObj);
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Sales.class))).thenThrow(NullPointerException.class);

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