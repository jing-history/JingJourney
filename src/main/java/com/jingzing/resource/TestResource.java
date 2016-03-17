package com.jingzing.resource;

import cn.dreampie.common.http.result.HttpStatus;
import cn.dreampie.common.http.result.WebResult;
import cn.dreampie.common.util.Maper;
import cn.dreampie.route.core.annotation.API;
import cn.dreampie.route.core.annotation.GET;
import cn.dreampie.route.core.annotation.POST;

import java.util.Map;

/**
 * Created by wangyunjing on 16/3/17.
 * 上面说到@API会被拼接，那么TestResource的api就是 /api/v1.0/tests
 */
@API("/tests")
public class TestResource extends ApiResource {

    /**
     * @GET 没有指定url时，访问改方法的api为 GET /api/v1.0/tests
     */
    @GET
    public WebResult get() {
        //如果需要返回请求状态  使用new WebResult
        return new WebResult(HttpStatus.OK, Maper.of("a", "1", "b", "2"));
    }
    /**
     * @GET("/:name") 或 @GET("/{name}") 来设置url参数
     */
    @GET("/:name")
    public WebResult get(String name) {
        //如果需要返回请求状态  使用new WebResult
        return new WebResult(HttpStatus.OK, Maper.of("a", "1", "b", "2"));
    }
    /**
     * 访问改方法的api为 POST /api/v1.0/tests/post
     * 传入参数时 test＝json字符串
     */
    @POST("/post")
    public Map post(Map<String, String> test) {
        return test;
    }
}
