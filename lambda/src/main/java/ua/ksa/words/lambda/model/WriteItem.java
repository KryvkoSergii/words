package ua.ksa.words.lambda.model;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

import java.util.HashMap;
import java.util.Map;

public class WriteItem implements Command {
    @Override
    public CommandResponse execute(CommandRequest request) {
        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();

        Map<String, AttributeValue> val = new HashMap<>();
        val.put("Name", new AttributeValue("hello"));
        val.put("translate", new AttributeValue("привіт"));

        PutItemRequest putItemRequest = new PutItemRequest()
                .withItem(val)
                .withTableName("words");

        PutItemResult result = ddb.putItem(putItemRequest);
        return null;
    }
}
