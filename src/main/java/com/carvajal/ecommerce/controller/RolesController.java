package com.carvajal.ecommerce.controller;

import com.carvajal.common.GenericResponse;
import com.carvajal.common.error.CoreException;
import com.carvajal.ecommerce.model.Roles;
import com.carvajal.ecommerce.service.RolesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/roles")
@Api("This API has a CRUD for Roles")
public class RolesController {

    @Autowired
    private RolesService _service;

    public RolesController(RolesService service) {
        this._service = service;
    }

    @ApiOperation(value = "Este método se encarga de retornar todos los roles existentes", response = Roles.class)
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
    
    @ApiOperation(value = "Este método se encarga de retornar el rol consultado", response = Roles.class)
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

    @ApiOperation(value = "Este método se encarga de crear y/o modificar un rol", response = Roles.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "You are not authorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @PostMapping
    public GenericResponse save(@Validated @RequestBody Roles data) {
        GenericResponse response = new GenericResponse();
        try {
            _service.save(data);
            response.success();
        } catch (CoreException e) {
            response.failure(e);
        }
        return response;
    }
    
    @ApiOperation(value = "Este método se encarga de modificar un rol.", response = Roles.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 401, message = "You are not authorized"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")})
    @PutMapping
    public GenericResponse edit(@Validated @RequestBody Roles data) {
        GenericResponse response = new GenericResponse();
        try {
            _service.update(data);
            response.success();
        } catch (CoreException e) {
            response.failure(e);
        }
        return response;
    }

    @ApiOperation(value = "Este método se encarga de eliminar un rol.", response = Roles.class)
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