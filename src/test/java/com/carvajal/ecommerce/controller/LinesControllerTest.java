package com.carvajal.ecommerce.controller;

import com.carvajal.common.GenericResponse;
import com.carvajal.common.error.CoreException;
import com.carvajal.ecommerce.model.Lines;
import com.carvajal.ecommerce.repository.ILinesRepository;
import com.carvajal.ecommerce.service.LinesService;
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

class LinesControllerTest {
    ILinesRepository _repositoryMock = Mockito.mock(ILinesRepository.class);

    @Autowired
    LinesService _service = new LinesService(_repositoryMock);

    @Autowired
    LinesController _controller = new LinesController(_service);

    @BeforeEach
    void setUp() throws CoreException {
        Lines data = new Lines();
        data.setId(1L);
        data.setNameLine("Ropa deportiva");
        data.setState(true);

        List<Lines> list = new ArrayList<>();
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
        Lines data = new Lines();
        data.setId(1L);
        data.setNameLine("Ropa deportiva");
        data.setState(true);

        GenericResponse response = _controller.save(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void saveFailed() {
        Lines data = new Lines();
        data.setId(1L);
        data.setNameLine("Ropa deportiva");
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Lines.class))).thenThrow(NullPointerException.class);

        GenericResponse response = _controller.save(data);
        Assertions.assertEquals(500, response.getErrorCode());
    }

    @Test
    void edit() {
        Lines data = new Lines();
        data.setId(1L);
        data.setNameLine("Ropa deportiva");
        data.setState(true);

        GenericResponse response = _controller.edit(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void editFailed() {
        Lines data = new Lines();
        data.setId(1L);
        data.setNameLine("Ropa deportiva");
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Lines.class))).thenThrow(NullPointerException.class);

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