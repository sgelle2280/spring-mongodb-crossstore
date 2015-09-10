package com.hcc.riab.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author sgelle
 * This is used to construct ClientDetails object
 *
 */

@Entity
@Table(name="riab_client_details")
public class ClientDetails {
	
	@Id
	private Integer id;
	
	@Column(name= "client_id")
	private String clientId;
	
	@Column(name= "client_secret")
	private String clientSecret;
	
	@Column(name= "scope")
	private String scope;
	
	@Column(name= "resource_ids")
	private String resourceIds;
	
	@Column(name= "authorized_grant_types")
	private String authorizedGrantTypes;
	
	@Column(name= "redirect_uri")
	private String registeredRedirectUris;
	
	@Column(name= "autoapprove")
	private String autoApproveScopes;
	
	@Column(name= "authorities")
	private String authorities;
	
	@Column(name="access_token_validity")
	private Integer accessTokenValiditySeconds;
	
	@Column(name="refresh_token_validity")
	private Integer refreshTokenValiditySeconds;
	
	@Column(name="additional_information")
	private String additionalInformation;
	
	private String createdBy;
	private Timestamp startDate;
	private Timestamp endDate;
	private Timestamp createdDate;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the clientSecret
	 */
	public String getClientSecret() {
		return clientSecret;
	}

	/**
	 * @param clientSecret the clientSecret to set
	 */
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * @param scope the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * @return the resourceIds
	 */
	public String getResourceIds() {
		return resourceIds;
	}

	/**
	 * @param resourceIds the resourceIds to set
	 */
	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	/**
	 * @return the authorizedGrantTypes
	 */
	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	/**
	 * @param authorizedGrantTypes the authorizedGrantTypes to set
	 */
	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	/**
	 * @return the registeredRedirectUris
	 */
	public String getRegisteredRedirectUris() {
		return registeredRedirectUris;
	}

	/**
	 * @param registeredRedirectUris the registeredRedirectUris to set
	 */
	public void setRegisteredRedirectUris(String registeredRedirectUris) {
		this.registeredRedirectUris = registeredRedirectUris;
	}

	/**
	 * @return the autoApproveScopes
	 */
	public String getAutoApproveScopes() {
		return autoApproveScopes;
	}

	/**
	 * @param autoApproveScopes the autoApproveScopes to set
	 */
	public void setAutoApproveScopes(String autoApproveScopes) {
		this.autoApproveScopes = autoApproveScopes;
	}

	/**
	 * @return the authorities
	 */
	public String getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	/**
	 * @return the accessTokenValiditySeconds
	 */
	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	/**
	 * @param accessTokenValiditySeconds the accessTokenValiditySeconds to set
	 */
	public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	/**
	 * @return the refreshTokenValiditySeconds
	 */
	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}

	/**
	 * @param refreshTokenValiditySeconds the refreshTokenValiditySeconds to set
	 */
	public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}

	/**
	 * @return the additionalInformation
	 */
	public String getAdditionalInformation() {
		return additionalInformation;
	}

	/**
	 * @param additionalInformation the additionalInformation to set
	 */
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the startDate
	 */
	public Timestamp getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Timestamp getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}		
	
}
