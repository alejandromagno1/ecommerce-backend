package com.carvajal.ecommerce.controller;

import com.carvajal.common.GenericResponse;
import com.carvajal.common.error.CoreException;
import com.carvajal.ecommerce.model.Wishes;
import com.carvajal.ecommerce.repository.IWishesRepository;
import com.carvajal.ecommerce.service.WishesService;
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

class WishesControllerTest {
    IWishesRepository _repositoryMock = Mockito.mock(IWishesRepository.class);

    @Autowired
    WishesService _service = new WishesService(_repositoryMock);

    @Autowired
    WishesController _controller = new WishesController(_service);

    @BeforeEach
    void setUp() throws CoreException {
        Wishes data = new Wishes();
        data.setId(1L);
        data.setIdUser(1L);
        data.setIdProduct(1L);
        data.setState(true);

        List<Wishes> list = new ArrayList<>();
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
        Wishes data = new Wishes();
        data.setId(1L);
        data.setIdUser(1L);
        data.setIdProduct(1L);
        data.setState(true);

        GenericResponse response = _controller.save(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void saveFailed() {
        Wishes data = new Wishes();
        data.setId(1L);
        data.setIdUser(1L);
        data.setIdProduct(1L);
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Wishes.class))).thenThrow(NullPointerException.class);

        GenericResponse response = _controller.save(data);
        Assertions.assertEquals(500, response.getErrorCode());
    }

    @Test
    void edit() {
        Wishes data = new Wishes();
        data.setId(1L);
        data.setIdUser(1L);
        data.setIdProduct(1L);
        data.setState(true);

        GenericResponse response = _controller.edit(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void editFailed() {
        Wishes data = new Wishes();
        data.setId(1L);
        data.setIdUser(1L);
        data.setIdProduct(1L);
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Wishes.class))).thenThrow(NullPointerException.class);

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