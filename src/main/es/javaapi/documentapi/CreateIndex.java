package javaapi.documentapi;

import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;

/**
 * @Description TODO
 * @Date 2020/8/5  16:38
 **/
public class CreateIndex {
    public static void main(String[] args) {
        CreateIndexRequest createIndex = new CreateIndexRequest("twitter");
        createIndex.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );
    }
}
