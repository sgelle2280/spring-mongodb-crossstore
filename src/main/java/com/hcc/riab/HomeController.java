package com.hcc.riab;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcc.riab.model.WellIndex;
import com.hcc.riab.service.impl.WellServiceImpl;

/**
 * Handles requests for the application riab.
 */
@Controller
@RequestMapping("/rest")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	WellServiceImpl wellService;
	
	/**
	 * 
	 * @param pWellID
	 * @Returns the well details by well id.
	 */
	@RequestMapping(value = "/getWellInfo", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	List<WellIndex> getDetails(BigDecimal pWellID) {
		logger.info("In getDetails() method"); 		
		List<WellIndex> ls = wellService.getDetails(pWellID);
		return ls;
	}
}
