package com.carvajal.ecommerce.service;

import com.carvajal.common.ResponseEnum;
import com.carvajal.common.error.CoreException;
import com.carvajal.ecommerce.model.Lines;
import com.carvajal.ecommerce.repository.ILinesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LinesService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ILinesRepository _repository;
    private String msjErrFnd = "Ocurrio un error al momento de consultar el registro";
    private String msjErrSave = "Ocurrio un error al momento de guardar el registro";
    private String msjErrDel = "Ocurrio un error al momento de eliminar el registro";

    @Autowired
    public LinesService(ILinesRepository rep){
        this._repository = rep;
    }

    public List<Lines> getAll() throws CoreException{
    	try {
    		return _repository.findAll();
        } catch (Exception e){
            logger.error(msjErrFnd, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }

    public List<Lines> getAllActives() throws CoreException{
        try {
            return _repository.getAllActives();
        } catch (Exception e){
            logger.error(msjErrFnd, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }
        
    public Lines getOne(Long id) throws CoreException{
    	try {
    		return _repository.getById(id);
        } catch (Exception e){
            logger.error(msjErrFnd, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        }
    }
    
    public void save(Lines data) throws CoreException {
    	try {
            _repository.save(data);
        } catch (Exception e) {
            logger.error(msjErrSave, e);
            throw new CoreException(ResponseEnum.REQUEST_EXIST);
        } 
    }
    
    public void update(Lines data) throws CoreException{
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