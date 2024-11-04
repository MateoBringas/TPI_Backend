package com.frc.utn.MS_Empleados.Service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<E> {
    public E save(E entity) throws Exception;
    public List<E> findAll() throws Exception;
    public E findById(Long id) throws Exception;
    public boolean delete(Long id) throws Exception;
    public E update(Long id, E entity) throws Exception;
}

