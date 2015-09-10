package com.hcc.riab.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcc.riab.model.WellIndex;
import com.hcc.riab.repositories.WellIndexRepository;
import com.hcc.riab.service.WellService;

@Service
public class WellServiceImpl implements WellService {

	@Autowired
	WellIndexRepository wellRepository;
	
	@Override
	public List<WellIndex> getDetails(BigDecimal  pWellID) {		
		WellIndex wi = wellRepository.findOne(pWellID);
		List<WellIndex> wells = new ArrayList<WellIndex>();
		wells.add(wi);
		return wells;
	}

}
