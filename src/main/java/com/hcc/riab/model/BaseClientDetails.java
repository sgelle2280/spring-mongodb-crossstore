package com.hcc.riab.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

/**
 * 
 * @author sgelle
 *
 */

public class BaseClientDetails implements ClientDetails{

	private static final long serialVersionUID = 7446198553727710390L;
	
	
	private String clientId;

	private String clientSecret;

	private Set<String> scopes = Collections.emptySet();
	
	private Set<String> resource_Ids = Collections.emptySet();
	
	private Set<String> authorized_GrantTypes = Collections.emptySet();
	
	private Set<String> registered_RedirectUris;
	
	private Set<String> auto_ApproveScopes;
	
	private List<GrantedAuthority> grant_Authorities = Collections.emptyList();
	
	private Integer accessTokenValiditySeconds;
	
	private Integer refreshTokenValiditySeconds;	
	
	private Map<String, Object> additional_Information = new LinkedHashMap<String, Object>();
	
	@Override
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public Set<String> getResourceIds() {
		return resource_Ids;
	}
	
	public void setResourceIds(Collection<String> resource_Ids) {
		this.resource_Ids = resource_Ids == null ? Collections
				.<String> emptySet() : new LinkedHashSet<String>(resource_Ids);
	}

	@Override
	public boolean isSecretRequired() {
		return this.clientSecret != null;
	}

	@Override
	public String getClientSecret() {
		return clientSecret;
	}
	
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	@Override
	public boolean isScoped() {
		return this.scopes != null && !this.scopes.isEmpty();
	}

	@Override
	public Set<String> getScope() {
		return scopes;
	}
	
	public void setScopes(Collection<String> scopes) {
		this.scopes = scopes == null ? Collections.<String> emptySet()
				: new LinkedHashSet<String>(scopes);
	}
	
	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return authorized_GrantTypes;
	}

	public void setAuthorizedGrantTypes(Collection<String> authorized_GrantTypes) {
		this.authorized_GrantTypes = new LinkedHashSet<String>(authorized_GrantTypes);
	}
	
	@Override
	public Set<String> getRegisteredRedirectUri() {
		return registered_RedirectUris;
	}
	
	public void setRegisteredRedirectUri(Set<String> registered_RedirectUris) {
		this.registered_RedirectUris = registered_RedirectUris == null ? null
				: new LinkedHashSet<String>(registered_RedirectUris);
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return grant_Authorities;
	}
	
	public void setAuthorities(
			Collection<? extends GrantedAuthority> grant_Authorities) {
		this.grant_Authorities = new ArrayList<GrantedAuthority>(grant_Authorities);
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}
	
	public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}
	
	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}
	
	public void setRefreshTokenValiditySeconds(
			Integer refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		if (auto_ApproveScopes == null) {
			return false;
		}
		for (String auto : auto_ApproveScopes) {
			if (auto.equals("true") || scope.matches(auto)) {
				return true;
			}
		}
		return false;
	}

	public void setAutoApproveScopes(Collection<String> auto_ApproveScopes) {
		this.auto_ApproveScopes = new HashSet<String>(auto_ApproveScopes);
	}
	
	@Override
	public Map<String, Object> getAdditionalInformation() {
		return Collections.unmodifiableMap(this.additional_Information);
	}
	
	public void setAdditionalInformation(Map<String, ?> additional_Information) {
		this.additional_Information = new LinkedHashMap<String, Object>(additional_Information);
	}
	
	public BaseClientDetails() {
	}

	public BaseClientDetails(ClientDetails prototype) {
		this();
		setAccessTokenValiditySeconds(prototype.getAccessTokenValiditySeconds());
		setRefreshTokenValiditySeconds(prototype
				.getRefreshTokenValiditySeconds());
		setAuthorities(prototype.getAuthorities());
		setAuthorizedGrantTypes(prototype.getAuthorizedGrantTypes());
		setClientId(prototype.getClientId());
		setClientSecret(prototype.getClientSecret());
		setRegisteredRedirectUri(prototype.getRegisteredRedirectUri());
		setScopes(prototype.getScope());
		setResourceIds(prototype.getResourceIds());
	}
	
	public BaseClientDetails(String clientId, String resourceIds,
			String scopes, String grantTypes, String authorities,
			String redirectUris) {

		this.clientId = clientId;

		if (StringUtils.hasText(resourceIds)) {
			Set<String> resources = StringUtils
					.commaDelimitedListToSet(resourceIds);
			if (!resources.isEmpty()) {
				this.resource_Ids = resources;
			}
		}

		if (StringUtils.hasText(scopes)) {
			Set<String> scopeList = StringUtils.commaDelimitedListToSet(scopes);
			if (!scopeList.isEmpty()) {
				this.scopes = scopeList;
			}
		}

		if (StringUtils.hasText(grantTypes)) {
			this.authorized_GrantTypes = StringUtils.commaDelimitedListToSet(grantTypes);
		} else {
			this.authorized_GrantTypes = new HashSet<String>(Arrays.asList("authorization_code", "refresh_token"));
		}

		if (StringUtils.hasText(authorities)) {
			this.grant_Authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
		}

		if (StringUtils.hasText(redirectUris)) {
			this.registered_RedirectUris = StringUtils.commaDelimitedListToSet(redirectUris);
		}
	}
	
	
}
