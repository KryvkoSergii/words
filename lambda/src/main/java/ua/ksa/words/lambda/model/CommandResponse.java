package ua.ksa.words.lambda.model;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@AllArgsConstructor
@Data
public class CommandResponse {
    private Map<String, AttributeValue> attributes;
}
