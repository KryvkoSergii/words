package ua.ksa.words.lambda.model;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.HashMap;
import java.util.Map;

public class ReadListFromTable implements Command {
    @Override
    public CommandResponse execute(CommandRequest request) {

        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();

        Map<String, AttributeValue> val = new HashMap<>();
        val.put("Name", new AttributeValue("hello"));

        GetItemRequest getItemRequest = new GetItemRequest()
                .withKey(val)
                .withTableName("words");

        GetItemResult s = ddb.getItem(getItemRequest);
        return new CommandResponse(s.getItem());
    }
}
