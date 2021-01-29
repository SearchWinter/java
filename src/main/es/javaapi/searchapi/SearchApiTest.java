package javaapi.searchapi;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by anjunli on  2021/1/28
 * 查询之前的数据，添加时间戳字段后，写入新的索引
 * f_tflag 时间 00:00 2360
 **/
public class SearchApiTest {
    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        HttpHost httpHost = new HttpHost("172.16.11.9", 9200);
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(httpHost));
        SearchRequest searchRequest = new SearchRequest("property_default_20210128");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        for(int i=0;i<=2360;i++) {
            searchSourceBuilder.query(QueryBuilders.termQuery("f_tflag", i))
                    .from(0)
                    .size(2000)     //size可以大于查询结果的条数
                    .timeout(new TimeValue(60, TimeUnit.SECONDS));
            searchRequest.source(searchSourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

            List<Map<String, Object>> mapList = new ArrayList<>();
            SearchHit[] hits = searchResponse.getHits().getHits();
            System.out.println("f_tflag: "+i+" hits.length: "+hits.length);
            if(hits.length==0){
                continue;
            }
            for (SearchHit hit : hits) {
                Map<String, Object> map = hit.getSourceAsMap();
                Object f_date = map.get("f_date");
                Object f_tflag = map.get("f_tflag");
                Date parse = format.parse((String) f_date + (String) f_tflag);
                Double aDouble =  Double.valueOf(Math.floor(Math.random() * 50000));
                final long timestamp = aDouble.longValue();
                map.put("timestamp", parse.getTime()+timestamp);
                mapList.add(map);
            }

            BulkRequest bulkRequest = new BulkRequest();
            for (int j = 0; j < mapList.size(); j++) {
                IndexRequest indexRequest = new IndexRequest("property_demo");
                indexRequest.source(mapList.get(j));
                bulkRequest.add(indexRequest);
            }
            client.bulk(bulkRequest, RequestOptions.DEFAULT);
        }
        client.close();
    }
}
