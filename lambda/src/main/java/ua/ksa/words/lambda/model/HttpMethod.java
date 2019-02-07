package ua.ksa.words.lambda.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum HttpMethod {
    GET("GET"), POST("POST");

    private final String val;

}
