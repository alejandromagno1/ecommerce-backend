package com.carvajal.ecommerce.service;

import com.carvajal.common.ResponseEnum;
import com.carvajal.common.error.CoreException;
import com.carvajal.ecommerce.model.Wishes;
import com.carvajal.ecommerce.repository.IWishesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WishesService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final IWishesRepository _repository;
    private String msjErrFnd = "Ocurrio un error al momento de consultar el registro";
    private String msjErrSave = "Ocurrio un error al momento de guardar el registro";
    private String msjErrDel = "Ocurrio un error al momento de eliminar el registro";

    @Autowired
    public WishesService(IWishesRepository rep){
        this._repository = rep;
    }

    public List<Wishes> getAll() throws CoreException{
    	try {
    		return _repository.findAll();
        } catch (Exception e){
            logger.error(msjErrFnd, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }
        
    public Wishes getOne(Long id) throws CoreException{
    	try {
    		return _repository.getById(id);
        } catch (Exception e){
            logger.error(msjErrFnd, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }

    public Wishes getWishesByUsrProd(Long idUser, Long idProd) throws CoreException{
        try {
            return _repository.getWishesByUsrProd(idUser, idProd);
        } catch (Exception e){
            logger.error(msjErrFnd, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }
    
    public void save(Wishes data) throws CoreException {
    	try {
            _repository.save(data);
        } catch (Exception e) {
            logger.error(msjErrSave, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        } 
    }
    
    public void update(Wishes data) throws CoreException{
        try {
            _repository.save(data);
        } catch (Exception e) {
            logger.error(msjErrSave, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }
    
    public void deleteByUsrProd(Long idUser, Long idProd) throws CoreException{
        try {
            _repository.deleteByUsrProd(idUser, idProd);
        } catch (Exception e) {
            logger.error(msjErrDel, e);
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