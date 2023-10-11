package com.brijframework.production.cust.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.production.cust.dto.UICustUnit;
import com.brijframework.production.cust.entities.EOCustProductionApp;
import com.brijframework.production.cust.entities.EOCustUnit;
import com.brijframework.production.cust.mapper.CustUnitMapper;
import com.brijframework.production.cust.repository.CustProductionAppRepository;
import com.brijframework.production.cust.repository.CustUnitRepository;
import com.brijframework.production.cust.service.CustUnitService;

@Service
public class CustUnitServiceImpl implements CustUnitService {
	
	@Autowired
	CustProductionAppRepository custProductionAppRepository;
	
	@Autowired
	CustUnitRepository custUnitRepository;
	
	@Autowired
	CustUnitMapper custUnitMapper;

	@Override
	public UICustUnit saveUnit(long custAppId, UICustUnit uiCustUnit) {
		Optional<EOCustProductionApp> findById = custProductionAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustProductionApp eoCustProductionApp = findById.get();
		EOCustUnit eoCustUnit = custUnitMapper.mapToDAO(uiCustUnit);
		eoCustUnit.setCustProductionApp(eoCustProductionApp);
		eoCustUnit = custUnitRepository.save(eoCustUnit);
		return custUnitMapper.mapToDTO(eoCustUnit);
	}

	@Override
	public UICustUnit updateUnit(long custAppId, Long id, UICustUnit uiCustUnit) {
		Optional<EOCustProductionApp> findById = custProductionAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustProductionApp eoCustProductionApp = findById.get();
		EOCustUnit eoCustUnit = custUnitMapper.mapToDAO(uiCustUnit);
		eoCustUnit.setCustProductionApp(eoCustProductionApp);
		eoCustUnit = custUnitRepository.save(eoCustUnit);
		return custUnitMapper.mapToDTO(eoCustUnit);
	}

	@Override
	public List<UICustUnit> getUnitList(long custAppId) {
		return custUnitMapper.mapToDTO(custUnitRepository.findByCustAppId(custAppId));
	}

}