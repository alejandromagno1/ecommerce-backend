package com.carvajal.ecommerce.controller;

import com.carvajal.common.GenericResponse;
import com.carvajal.common.error.CoreException;
import com.carvajal.ecommerce.model.Roles;
import com.carvajal.ecommerce.repository.IRolesRepository;
import com.carvajal.ecommerce.service.RolesService;
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

class RolesControllerTest {
    IRolesRepository _repositoryMock = Mockito.mock(IRolesRepository.class);

    @Autowired
    RolesService _service = new RolesService(_repositoryMock);

    @Autowired
    RolesController _controller = new RolesController(_service);

    @BeforeEach
    void setUp() throws CoreException {
        Roles data = new Roles();
        data.setId(1L);
        data.setNameRol("Auditoria");
        data.setAdmin(true);
        data.setState(true);

        List<Roles> list = new ArrayList<>();
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
        Roles data = new Roles();
        data.setId(1L);
        data.setNameRol("Auditoria");
        data.setAdmin(true);
        data.setState(true);

        GenericResponse response = _controller.save(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void saveFailed() {
        Roles data = new Roles();
        data.setId(1L);
        data.setNameRol("Auditoria");
        data.setAdmin(true);
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Roles.class))).thenThrow(NullPointerException.class);

        GenericResponse response = _controller.save(data);
        Assertions.assertEquals(500, response.getErrorCode());
    }

    @Test
    void edit() {
        Roles data = new Roles();
        data.setId(1L);
        data.setNameRol("Auditoria");
        data.setAdmin(true);
        data.setState(true);

        GenericResponse response = _controller.edit(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void editFailed() {
        Roles data = new Roles();
        data.setId(1L);
        data.setNameRol("Auditoria");
        data.setAdmin(true);
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Roles.class))).thenThrow(NullPointerException.class);

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