package com.response;

import com.alibaba.fastjson.JSONObject;
import com.enums.RespCodeEnum;
import lombok.*;
import com.utils.JsonUtils;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonResponse<T> {
    private Boolean success;
    /**
     * @see com.enums.RespCodeEnum
     */
    private Integer code;

    private T data;

    @Builder.Default
    private String message = "";

    public static <T> CommonResponse<T> successResp(T data){
        //注意没有new
        return  CommonResponse.<T>builder().code(RespCodeEnum.SUCCESS.getCode())
                .message("success").data(data).build();
    }

    public static <T> CommonResponse<T> failResp(String msg){
        return CommonResponse.<T>builder().code(RespCodeEnum.FAIL.getCode()).message(msg).build();
    }




    public static void main(String[] args) {
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("试试","试试就试试");
        CommonResponse<JSONObject> json = CommonResponse.successResp(jsonObject);
        System.out.println(json.toString());
        System.out.println(json.toString());
        CommonResponse<Object> resp = CommonResponse.failResp("测试一下失败");
        System.out.println(resp.toString());
    }
}
