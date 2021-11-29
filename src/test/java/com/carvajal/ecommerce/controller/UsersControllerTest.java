package com.carvajal.ecommerce.controller;

import com.carvajal.ecommerce.model.Users;
import com.carvajal.ecommerce.repository.IUsersRepository;
import com.carvajal.ecommerce.service.UsersService;
import com.carvajal.common.GenericResponse;
import com.carvajal.common.error.CoreException;
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

class UsersControllerTest {
    IUsersRepository _repositoryMock = Mockito.mock(IUsersRepository.class);

    @Autowired
    UsersService _service = new UsersService(_repositoryMock);

    @Autowired
    UsersController _controller = new UsersController(_service);

    @BeforeEach
    void setUp() throws CoreException {
        Users data = new Users();
        data.setId(1L);
        data.setIdRol(1L);
        data.setUser("jarvis");
        data.setPwd("Abc3$5&");
        data.setNameUser("Jarvis Stark");
        data.setEMail("jarvis@stark.com");
        data.setState(true);

        List<Users> list = new ArrayList<>();
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
        Users data = new Users();
        data.setId(1L);
        data.setIdRol(1L);
        data.setUser("jarvis");
        data.setPwd("Abc3$5&");
        data.setNameUser("Jarvis Stark");
        data.setEMail("jarvis@stark.com");
        data.setState(true);

        GenericResponse response = _controller.save(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void saveFailed() {
        Users data = new Users();
        data.setId(1L);
        data.setIdRol(1L);
        data.setUser("jarvis");
        data.setPwd("Abc3$5&");
        data.setNameUser("Jarvis Stark");
        data.setEMail("jarvis@stark.com");
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Users.class))).thenThrow(NullPointerException.class);

        GenericResponse response = _controller.save(data);
        Assertions.assertEquals(500, response.getErrorCode());
    }

    @Test
    void edit() {
        Users data = new Users();
        data.setId(1L);
        data.setIdRol(1L);
        data.setUser("jarvis");
        data.setPwd("Abc3$5&");
        data.setNameUser("Jarvis Stark");
        data.setEMail("jarvis@stark.com");
        data.setState(true);

        GenericResponse response = _controller.edit(data);
        Assertions.assertNotNull(response);
    }

    @Test
    void editFailed() {
        Users data = new Users();
        data.setId(1L);
        data.setIdRol(1L);
        data.setUser("jarvis");
        data.setPwd("Abc3$5&");
        data.setNameUser("Jarvis Stark");
        data.setEMail("jarvis@stark.com");
        data.setState(true);

        Mockito.when(_repositoryMock.save(any(Users.class))).thenThrow(NullPointerException.class);

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