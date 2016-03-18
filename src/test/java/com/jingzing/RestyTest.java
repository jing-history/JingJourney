package com.jingzing;

import cn.dreampie.client.Client;
import cn.dreampie.client.ClientRequest;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by Louis Wang on 2016/3/18.
 */
@FixMethodOrder(MethodSorters.JVM)
public class RestyTest {

    private Client client;

    @Before
    public void setUp() throws Exception {
        client = new Client("http://localhost:8084/api/v1.0");
    }

    @Test
    public void testGet() {
        ClientRequest request = new ClientRequest("/tests");
 //       request.setJsonParam("2013-03-23 00:00:00");
//    Jsoner.addDeserializer(User.class, ModelDeserializer.instance());
//    System.out.println(Jsoner.toObject(client.build(request).get().getResult(),new TypeReference<List<User>>(){}));
        System.out.println(client.build(request).get());
    }
}
