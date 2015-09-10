package com.hcc.riab.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcc.riab.model.ClientDetails;

/**
 * Specifies methods used to obtain and modify client details related information
 * which is stored in the database.
 * @author sgelle
 *
 */

@Repository
public interface ClientDetailsRepository extends CrudRepository<ClientDetails, String>{
	/**
	 * Finds client details by using the client_id as a search criteria.
	 * @param clientId
	 * @return A list of clients which client id is an exact match with the given clientId.
     *          If no records is found, this method returns an empty list.
	 */
	
	ClientDetails findByClientId(String clientId);
}
