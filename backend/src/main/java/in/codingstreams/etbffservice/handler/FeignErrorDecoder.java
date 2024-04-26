package in.codingstreams.etbffservice.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import in.codingstreams.etbffservice.constant.LoggingConstants;
import in.codingstreams.etbffservice.controller.dto.ErrorResponse;
import in.codingstreams.etbffservice.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {

        log.error(LoggingConstants.ERROR_METHOD_LOG,"FeignErrorDecoder:Decode", "Error from feign client");

//        methodKey = FeignClientName:method
        var errorResponse = Optional.ofNullable(response.body())
                .map(body -> {
                    try {
                        return new String(body.asInputStream().readAllBytes());
                    } catch (IOException e) {
                        return null;
                    }
                })
                .map(json -> {
                    try {
                        return new ObjectMapper().readValue(json, ErrorResponse.class);
                    } catch (JsonProcessingException e) {
                        return null;
                    }
                })
                .orElse(
                        ErrorResponse.builder()
                                .errorCode("500")
                                .errorMessage("Something Went Wrong!")
                                .build()
                );

        return new  ApiException(
            errorResponse.getErrorMessage(),
                response.status(),
                errorResponse.getErrorCode()
        );
    }
}
