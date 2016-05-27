package tk.jingzing;

/**
 * http://www.aboutyun.com/thread-12882-1-1.html
 * http://www.jikexueyuan.com/course/kafka/ (视频教程E)
 * Created by Louis Wang on 2016/5/27.
 */

public interface KafkaProperties {
    final static String zkConnect = "45.32.12.187:2181";
    final static String groupId = "group1";
    final static String topic = "test";
    final static String kafkaServerURL = "45.32.12.187";
    final static int kafkaServerPort = 9092;
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String topic2 = "topic2";
    final static String topic3 = "topic3";
    final static String clientId = "SimpleConsumerDemoClient";
}
