package com.teamdev.opticacheguigo.opticacheguigo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.teamdev.opticacheguigo.opticacheguigo.model.Insumo;


public interface IInsumoService {
	
	public List<Insumo> findAll();

	public Page<Insumo> findAll(Pageable pageable);

	public void save(Insumo cliente);

	public Insumo findOne(Long id);

	public void delete(Long id);

}
