package com.example.rqchallenge.employees.exception.handler;

import com.example.rqchallenge.employees.constant.RqChallengeConstants;
import com.example.rqchallenge.employees.exception.RqChallengeException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseExceptionHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if(response.getStatusCode().is4xxClientError()){
            throw new RqChallengeException(response.getStatusCode(), RqChallengeConstants.RQ_CALLENGE_EXTERNAL_API_BUSY_ERROR);
        }
        if (response.getStatusCode().is5xxServerError()) {
                throw new RqChallengeException(response.getStatusCode(), RqChallengeConstants.RQ_CALLENGE_EXTERNAL_API_SERVER_ERROR);
        }
    }
}