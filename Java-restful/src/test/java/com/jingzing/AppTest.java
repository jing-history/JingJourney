package com.jingzing;

import com.jingzing.core.LinkRelation;
import com.jingzing.response.Success;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Created by Louis Wang on 2016/5/20.
 */

public class AppTest {
    @Test
    public void test() {
        Response response = Success.Created.builder("", "", new Date()).link("http://bb.c", LinkRelation.SELF).build();
        assert response.getHeaders().containsKey("Link");
    }
}
