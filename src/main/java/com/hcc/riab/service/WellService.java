package com.hcc.riab.service;

import java.math.BigDecimal;
import java.util.List;

import com.hcc.riab.model.WellIndex;

public interface WellService {

	public List<WellIndex> getDetails(BigDecimal pWellID);
}
