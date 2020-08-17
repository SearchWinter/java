package javaapi;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Description 可以连接多个Elasticsearch
 * @Date 2020/7/20  17:29
 **/
public class Utils {
    //得到Es的客户端
    public static RestHighLevelClient getClient(){
        HttpHost httpHost = new HttpHost("172.16.8.124", 9200);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(
                        /** 可以有多个ES连接*/
//                        new HttpHost("172.16.8.124", 9200, "http"),
                        httpHost
                )
        );
        return restHighLevelClient;
    }
}
