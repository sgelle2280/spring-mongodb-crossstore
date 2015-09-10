package com.hcc.riab.repositories;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcc.riab.model.WellIndex;

/**
 * Specifies methods used to obtain and modify well index related information
 * which is stored in the database.
 * @author sgelle
 *
 */
@Repository
public interface WellIndexRepository extends CrudRepository<WellIndex, BigDecimal>{
	
}
