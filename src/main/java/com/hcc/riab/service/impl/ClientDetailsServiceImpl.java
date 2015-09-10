package com.hcc.riab.service.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.hcc.riab.repositories.ClientDetailsRepository;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Autowired
	ClientDetailsRepository clientDetailsRepository;
	
	public ClientDetailsServiceImpl(DataSource datasource) {

	}
	public ClientDetailsServiceImpl(){
		
	}
	
	@Override
	public ClientDetails loadClientByClientId(String clientId)
			throws ClientRegistrationException {
		com.hcc.riab.model.ClientDetails clientDetails;
		BaseClientDetails details = null;
		try{
			clientDetails = clientDetailsRepository.findByClientId(clientId);
			details = new BaseClientDetails(clientDetails.getClientId(), clientDetails.getResourceIds(), clientDetails.getScope(),
					clientDetails.getAuthorizedGrantTypes(), clientDetails.getAuthorities(), clientDetails.getRegisteredRedirectUris());
			details.setClientSecret(clientDetails.getClientSecret());
			if(clientDetails.getAccessTokenValiditySeconds() != null)
				details.setAccessTokenValiditySeconds(clientDetails.getAccessTokenValiditySeconds());
			if(clientDetails.getRefreshTokenValiditySeconds() != null)
				details.setRefreshTokenValiditySeconds(clientDetails.getRefreshTokenValiditySeconds());
				
		}catch (EmptyResultDataAccessException e) {
			throw new NoSuchClientException("No client with requested id: " + clientId);
		}
		return details;
	}

}
