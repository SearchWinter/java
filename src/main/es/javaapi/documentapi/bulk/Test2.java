package javaapi.documentapi.bulk;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
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
}
