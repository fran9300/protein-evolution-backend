package com.proteinevolution.backend.client;


import com.proteinevolution.backend.dto.ProteinAnalysisResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;


@Component
public class PythonAnalyzerClient {


    private final RestClient restClient;


    public PythonAnalyzerClient(
            @Value("${analyzer.service.url}") String analyzerUrl
    ){

        this.restClient = RestClient.builder()
                .baseUrl(analyzerUrl)
                .build();

    }


    public ProteinAnalysisResponse analyze(
            MultipartFile file
    ) throws Exception {


        ByteArrayResource resource =
                new ByteArrayResource(file.getBytes()) {

                    @Override
                    public String getFilename(){
                        return file.getOriginalFilename();
                    }

                };


        MultiValueMap<String, Object> body =
                new LinkedMultiValueMap<>();


        body.add(
                "file",
                resource
        );


        return restClient.post()
                .uri("/api/analyze")
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .body(body)
                .retrieve()
                .body(ProteinAnalysisResponse.class);

    }

}