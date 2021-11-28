package com.carvajal.ecommerce.controller;

import com.carvajal.ecommerce.model.Users;
import com.carvajal.ecommerce.service.UsersService;
import com.carvajal.common.GenericResponse;
import com.carvajal.common.error.CoreException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
@Api("This API has a CRUD for Users")
public class UsersController {

    @Autowired
    private UsersService _service;

    public UsersController(UsersService service) {
        this._service = service;
    }

    @ApiOperation(value = "Este método se encarga de retornar todos los usuarios existentes", response = Users.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "You are not authorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping()
    public GenericResponse get() {
        GenericResponse response = new GenericResponse();
        try {
            response.success(_service.getAll());
        } catch (CoreException e) {
            response.failure(e);
        }
        return response;
    }
    
    @ApiOperation(value = "Este método se encarga de retornar el usuario consultado", response = Users.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "You are not authorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping("/{id}")
    public GenericResponse get(@PathVariable Long id) {
        GenericResponse response = new GenericResponse();
        try {
        	response.success(_service.getOne(id));
        } catch (CoreException e) {
            response.failure(e);
        }
        return response;
    }

    @ApiOperation(value = "Este método se encarga de retornar el usuario consultado", response = Users.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @GetMapping("login/{user}/{passwd}")
    public GenericResponse login(@PathVariable String user, @PathVariable String passwd) {
        GenericResponse response = new GenericResponse();
        try {
            response.success(_service.login(user, passwd));
        } catch (CoreException e) {
            response.failure(e);
        }
        return response;
    }

    @ApiOperation(value = "Este método se encarga de crear y/o modificar un usuario", response = Users.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "You are not authorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @PostMapping
    public GenericResponse save(@Validated @RequestBody Users data) {
        GenericResponse response = new GenericResponse();
        try {
            _service.save(data);
            response.success();
        } catch (CoreException e) {
            response.failure(e);
        }
        return response;
    }
    
    @ApiOperation(value = "Este método se encarga de modificar un usuario.", response = Users.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "You are not authorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @PutMapping
    public GenericResponse edit(@Validated @RequestBody Users data) {
        GenericResponse response = new GenericResponse();
        try {
            _service.update(data);
            response.success();
        } catch (CoreException e) {
            response.failure(e);
        }
        return response;
    }

    @ApiOperation(value = "Este método se encarga de eliminar un usuario.", response = Users.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "You are not authorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @DeleteMapping("/{id}")
    public GenericResponse delete(@PathVariable Long id) {
        GenericResponse response = new GenericResponse();
        try {
            _service.delete(id);
            response.success();
        } catch (CoreException e) {
            response.failure(e);
        }
        return response;
    }
}