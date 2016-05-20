package com.jingzing.response.status;

import javax.ws.rs.core.Response;

/**
 * Created by Louis Wang on 2016/5/20.
 */

public class Deleted implements StatusBuilder {
    @Override
    public Response build(Object... parameters) {
        return builder(parameters).build();
    }

    @Override
    public Response.ResponseBuilder builder(Object... parameters) {
        return Response.status(Response.Status.NO_CONTENT);
    }
}
