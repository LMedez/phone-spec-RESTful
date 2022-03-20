package com.luc.phonespecs.auth;

import com.luc.phonespecs.auth.models.SecurityProperties;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SecurityFeignRequestInterceptor implements RequestInterceptor {

    @Autowired
    SecurityProperties securityProps;

    private static final String AUTHENTICATION_HEADER = "X-BLOBR-KEY";
 
	@Override
    public void apply(RequestTemplate template) {
        propagateAuthorizationHeader(template);
	}
 
	private void propagateAuthorizationHeader(RequestTemplate template) {
		if (template.headers().containsKey(AUTHENTICATION_HEADER)) {
            log.info("the authorization {} token has been already set", AUTHENTICATION_HEADER);
        } else {
        	log.info("setting the authorization token {}", AUTHENTICATION_HEADER);
            template.header(AUTHENTICATION_HEADER, securityProps.getTechSpecsApiKey());
        }
	}
	
}