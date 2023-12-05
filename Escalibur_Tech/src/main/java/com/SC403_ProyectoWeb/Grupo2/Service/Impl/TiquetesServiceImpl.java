/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SC403_ProyectoWeb.Grupo2.Service.Impl;
import com.SC403_ProyectoWeb.Grupo2.Dao.TiquetesDao;
import com.SC403_ProyectoWeb.Grupo2.Domain.Tiquetes;
import com.SC403_ProyectoWeb.Grupo2.Service.TiquetesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TiquetesServiceImpl implements TiquetesService {
    
    @Autowired
    private TiquetesDao categoriaDao;
    @Override
    @Transactional(readOnly=true)
    public List<Tiquetes> getTiquetes(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Tiquetes getTiquetes(Tiquetes categoria) {
        return categoriaDao.findById(categoria.getId_tiquete()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Tiquetes categoria) {
        categoriaDao.save(categoria);
    }
    
    @Override
    @Transactional
    public void delete(Tiquetes categoria) {
        categoriaDao.delete(categoria);
    }
       
}
