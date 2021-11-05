package dev.j3c.sofkau.cleanarch.infrastructure.materialize;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import dev.j3c.sofkau.cleanarch.domain.bill.Product;
import dev.j3c.sofkau.cleanarch.domain.bill.event.BillGenerated;
import dev.j3c.sofkau.cleanarch.domain.bill.event.ProductAdded;
import io.quarkus.vertx.ConsumeEvent;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class BillHandle {
    private final MongoClient mongoClient;

    public BillHandle(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }


    @ConsumeEvent(value = "sofkau.bill.billgenerated", blocking = true)
    void consumeBillGenerated(BillGenerated event) {
        System.out.println("materialize bill");
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("customerId", event.customerId());
        document.put("customerName", event.customerName());
        document.put("customerPhoneNumber", event.customerPhoneNumber());
        document.put("name", event.getAggregateId());
        mongoClient.getDatabase("queries").getCollection("bill")
                .insertOne(new Document(document));
    }

    @ConsumeEvent(value = "sofkau.bill.productadded", blocking = true)
    void consumeProductAdded(ProductAdded event) {
        System.out.println("materialize product");
        BasicDBObject document = new BasicDBObject();
        var key = "products."+event.getProductId();
        document.put(key+".name", event.getProductName());
        document.put(key+".price", event.getProductPrice());

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);
        mongoClient.getDatabase("queries").getCollection("bill")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }


}