package tk.jingzing;

/**
 * Created by Louis Wang on 2016/5/27.
 */

public class KafkaConsumerProducerDemo {

    public static void main(String[] args)
    {
        KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic);
        producerThread.start();
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic);
        consumerThread.start();
    }
}
