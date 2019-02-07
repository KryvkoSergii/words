package ua.ksa.words.lambda.model;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.Optional;

public class CreateTable implements Command {

    @Override
    public CommandResponse execute(CommandRequest request) {
        String tableName = "words";

        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.defaultClient();

        Optional<String> table = ddb.listTables()
                .getTableNames().stream()
                .filter(e -> e.equals(tableName))
                .findFirst();

        if (table.isPresent()) {
            return null;
        }

        CreateTableRequest createTableRequest = new CreateTableRequest()
                .withAttributeDefinitions(new AttributeDefinition("Name", ScalarAttributeType.S))
                .withKeySchema(new KeySchemaElement("Name", KeyType.HASH))
                .withProvisionedThroughput(new ProvisionedThroughput(
                        new Long(10), new Long(10)))
                .withTableName(tableName);

        try {
            CreateTableResult result = ddb.createTable(createTableRequest);
            System.out.println(result.getTableDescription().getTableName());
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
        }
        return null;
    }
}
