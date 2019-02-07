package ua.ksa.words.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import ua.ksa.words.lambda.model.*;

public class ApiGateWayListener implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        String method = input.getHttpMethod();
//        if (method.equals(HttpMethod.GET.getVal())) {
            APIGatewayProxyResponseEvent resp = new APIGatewayProxyResponseEvent();
            new CreateTable().execute(null);
            new WriteItem().execute(null);
            CommandResponse response = new ReadListFromTable().execute(null);
            return new APIGatewayProxyResponseEvent()
                    .withBody(response.getAttributes().get("translation").toString())
                    .withStatusCode(200);
//        }
//
//        return null;
    }
}
