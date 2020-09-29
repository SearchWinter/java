package javaapi.indexapi;

import javaapi.Utils;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;

import java.io.IOException;

/**
 * @Description 创建索引，并配置分片数
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/7.9/java-rest-high-create-index.html#java-rest-high-create-index-sync
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/7.9/java-rest-high-indices-exists.html
 * @Date 2020/8/5  16:38
 **/
public class CreateIndex {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = Utils.getClient();
        //索引名称必须都是小写
        String indexName="twitter";

        //判断索引是否存在
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);

        //不存在就创建索引
        if (!exists) {
            CreateIndexRequest createIndex = new CreateIndexRequest(indexName);
            createIndex.settings(Settings.builder()
                    .put("index.number_of_shards", 10)
                    .put("index.number_of_replicas", 0)
            );
            //连接到es节点的超时时间
            createIndex.setMasterTimeout(TimeValue.timeValueSeconds(30));
            client.indices().create(createIndex, RequestOptions.DEFAULT);
        }
        client.close();
    }
}
