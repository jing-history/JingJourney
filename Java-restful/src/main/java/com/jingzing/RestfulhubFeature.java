package com.jingzing;

import com.jingzing.provider.mapper.*;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Created by Louis Wang on 2016/5/20.
 */

public class RestfulhubFeature implements Feature {

    @Override
    public boolean configure(FeatureContext featureContext) {
        featureContext.register(ThrowableMapper.class);
        featureContext.register(NotFoundExceptionMapper.class);
        featureContext.register(ForbiddenExceptionMapper.class);
        featureContext.register(NotAllowedExceptionMapper.class);
        featureContext.register(EntityExistsExceptionMapper.class);
        featureContext.register(NotAuthorizedExceptionMapper.class);
        featureContext.register(EntityNotFoundExceptionMapper.class);
        featureContext.register(WebApplicationExceptionMapper.class);
        featureContext.register(NotImplementedExceptionMapper.class);
        featureContext.register(AuthenticationExceptionMapper.class);
        featureContext.register(IllegalArgumentExceptionMapper.class);
        featureContext.register(ConstraintViolationExceptionMapper.class);
        return true;
    }
}
