package javaapi.documentapi.bulk;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description TODO
 * @Date 2020/10/19  10:35
 **/
public class Test2 {
    public static void main(String[] args) throws IOException {
        long start1 =System.currentTimeMillis();
        HttpHost httpHost = new HttpHost("192.168.8.237", 9200);
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(httpHost)
        );

        List<Map<String, ?>> list = new ArrayList<Map<String, ?>>();
        for (int i = 0; i < 10000; i++) {
            Map<String, String> datas = new HashMap<>();
            datas.put("name", "name_" + i);
            datas.put("age", Integer.toString(new Random().nextInt(50)));
            datas.put("sex", Math.round(Math.random()) == 1 ? "男" : "女");
            list.add(datas);
        }
        System.gc();

        BulkRequest bulkRequest = new BulkRequest();
        for (int i = 0; i < list.size(); i++) {
            IndexRequest indexRequest = new IndexRequest("es_test");
            indexRequest.source(list.get(i));
            bulkRequest.add(indexRequest);
        }

        long start2=System.currentTimeMillis();
        client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println("程序执行时间："+(System.currentTimeMillis()-start2));
        client.close();
    }

    /** 复现插入es中的时间少8小时的问题
     * jvm默认使用系统的时区，而es中的时间都是UTC(世界协调时间) 0时区，所以少了8小时
     * java.utils.date可以直接存入es,java.sql.date要先转换为java.utils.date才能存入
     * */
    @Test
    public void timeDemo() throws IOException, ParseException {
        HttpHost httpHost = new HttpHost("172.16.8.156", 9200);
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(httpHost)
        );
        IndexRequest indexRequest = new IndexRequest("time_demo3");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = dateFormat.parse("2020-12-28");
        indexRequest.source("date",parse).id("1");
        client.index(indexRequest,RequestOptions.DEFAULT);
        client.close();
    }
    //es中存放的时间，都会转换为下面这种格式
    //2020-12-27T16:00:00.000Z
}
