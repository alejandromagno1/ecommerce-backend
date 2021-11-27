package com.carvajal.ecommerce.service;

import com.carvajal.common.ResponseEnum;
import com.carvajal.common.error.CoreException;
import com.carvajal.ecommerce.model.Products;
import com.carvajal.ecommerce.repository.IProductsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductsService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final IProductsRepository _repository;
    private String msjErrFnd = "Ocurrio un error al momento de consultar el registro";
    private String msjErrSave = "Ocurrio un error al momento de guardar el registro";
    private String msjErrDel = "Ocurrio un error al momento de eliminar el registro";

    @Autowired
    public ProductsService(IProductsRepository rep){
        this._repository = rep;
    }

    public List<Products> getAll() throws CoreException{
    	try {
    		return _repository.findAll();
        } catch (Exception e){
            logger.error(msjErrFnd, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }
        
    public Products getOne(Long id) throws CoreException{
    	try {
    		return _repository.getById(id);
        } catch (Exception e){
            logger.error(msjErrFnd, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }
    
    public void save(Products data) throws CoreException {
    	try {
            _repository.save(data);
        } catch (Exception e) {
            logger.error(msjErrSave, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        } 
    }
    
    public void update(Products data) throws CoreException{
        try {
            _repository.save(data);
        } catch (Exception e) {
            logger.error(msjErrSave, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }
    
    public void delete(Long id) throws CoreException{
        try {
            _repository.deleteById(id);
        } catch (Exception e) {
            logger.error(msjErrDel, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }
}