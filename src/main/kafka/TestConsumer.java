import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by anjunli on  2021/1/15
 * org.apache.kafka.clients.consumer.ConsumerConfig
 **/
public class TestConsumer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "172.16.9.82:9092,172.16.9.83:9092");
        properties.put("group.id", "1234");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
/*        TopicPartition topicPartition = new TopicPartition("test", 1);
        ArrayList<TopicPartition> list = new ArrayList<>();
        list.add(topicPartition);
        consumer.assign(list);*/
        consumer.subscribe(Arrays.asList("test"));
        ConsumerRecords<String, String> records = consumer.poll(100);
        for (ConsumerRecord<String, String> record : records) {
            System.out.printf("offset = %d, value = %s", record.offset(), record.value() + "\n");
            System.out.println(record);
        }
    }

    @Test
    public void testConsumer() {

    }
}
