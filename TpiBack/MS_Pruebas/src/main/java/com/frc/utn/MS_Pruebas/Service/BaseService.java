package com.frc.utn.MS_Pruebas.Service;

import java.util.List;

public interface BaseService<C> {
    public C save(C c);
    public C update(C c, Long id);
    public void delete(Long id);
    public List<C> findAll();
    public C findById(Long id);
}
