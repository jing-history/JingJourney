package com.jingzing.response.status;

import javax.ws.rs.core.Response;

/**
 * Created by Louis Wang on 2016/5/20.
 */

public interface StatusBuilder {
    Response build(Object... parameters);

    Response.ResponseBuilder builder(Object... parameters);
}
