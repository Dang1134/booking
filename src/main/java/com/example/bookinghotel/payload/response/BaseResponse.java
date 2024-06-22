package com.example.bookinghotel.payload.response;

import lombok.Data;

@Data
public class BaseResponse {
    private int statusCode ;
    private String message;
    private Object data ;

    public static BaseResponse successBaseResponse (Object data , String message ){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage(message);
        baseResponse.setData(data);
        return baseResponse;
    }
    public static BaseResponse errorBaseResponse (String message){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(200);
        baseResponse.setMessage(message);
        baseResponse.setData(null);
        return baseResponse ;
    }
}
