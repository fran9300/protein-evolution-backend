package com.proteinevolution.backend.dto;


public class HealthResponse {


    private String application;

    private String status;

    private String version;



    public HealthResponse(
            String application,
            String status,
            String version
    ){

        this.application = application;
        this.status = status;
        this.version = version;

    }



    public String getApplication(){

        return application;

    }


    public String getStatus(){

        return status;

    }


    public String getVersion(){

        return version;

    }

}