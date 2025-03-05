package com.market.agasale.common.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.market.agasale.common.elasticsearch.model.ElasticProduct;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope()
public class ElasticClientConfig {
    private final ElasticsearchClient esClient;

    public ElasticClientConfig() {
        String serverUrl = "http://localhost:9200";
        String loginAndPasswordHash = "ZWxhc3RpYzpsR2NDNXRpS1NfZ1ZhX01NMGFUcA";

        RestClient restClient = RestClient
                .builder(HttpHost.create(serverUrl))
                .setDefaultHeaders(new Header[] {
                        new BasicHeader("Authorization", "Basic " + loginAndPasswordHash)
                })
                .build();

        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        esClient = new ElasticsearchClient(transport);
    }

    public void createDocument(ElasticProduct elasticProduct) throws IOException {
        IndexResponse response = esClient.index(i -> i
                .index("products")
                .id(elasticProduct.getId())
                .document(elasticProduct)
        );
    }

    public List<ElasticProduct> searchProductsByQuery(String searchTerm) throws IOException {
        SearchRequest searchRequest = new SearchRequest.Builder()
                .index("products")
                .query(q -> q
                        .simpleQueryString(s -> s
                                .query(searchTerm)
                                .fields("name^3", "category^2", "description")
                        )
                )
                .build();

        SearchResponse<ElasticProduct> response = esClient.search(searchRequest, ElasticProduct.class);
        assert response.hits().total() != null;
        if (response.hits().total().value() > 0) {
            List<Hit<ElasticProduct>> hits = response.hits().hits();
            List<ElasticProduct> elasticProductList = new ArrayList<>();
            for (Hit<ElasticProduct> hit : hits) {
                elasticProductList.add(hit.source());
            }
            return elasticProductList;
        }
        return null;

    }
}
