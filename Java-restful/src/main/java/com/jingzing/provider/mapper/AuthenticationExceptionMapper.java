package com.jingzing.provider.mapper;


import com.jingzing.exception.AuthenticationException;
import com.jingzing.response.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Component:
 * Description:
 * Date: 14-4-30
 *
 * @author Andy Ai
 */
public class AuthenticationExceptionMapper implements ExceptionMapper<AuthenticationException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationExceptionMapper.class);

    @Override
    public Response toResponse(AuthenticationException exception) {
        LOGGER.error(exception.getLocalizedMessage(), exception);
        AuthenticationException.Code code = exception.code();
        return ErrorBuilder.newBuilder().message(code.message())
                .error(code.code(), code.message()).build(code.status());
    }

}
