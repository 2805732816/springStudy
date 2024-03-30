package response;

import com.alibaba.fastjson.JSONObject;
import enums.RespCodeEnum;
import lombok.*;
import utils.JsonUtils;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {
    private Boolean success;
    /**
     * @see enums.RespCodeEnum
     */
    private Integer code;

    private T data;

    @Builder.Default
    private String message = "";

    private static <T> CommonResponse<T> successResp(T data){
        //注意没有new
        return  CommonResponse.<T>builder().code(RespCodeEnum.SUCCESS.getCode())
                .message("success").data(data).build();
    }

    private static <T> CommonResponse<T> failResp(String msg){
        return CommonResponse.<T>builder().code(RespCodeEnum.FAIL.getCode()).message(msg).build();
    }

    public String toString(){
        return JsonUtils.simpleToString(this);
    }


    public static void main(String[] args) {
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("试试","试试就试试");
        CommonResponse<JSONObject> json = CommonResponse.successResp(jsonObject);
        System.out.println(json.toString());

        CommonResponse<Object> resp = CommonResponse.failResp("测试一下失败");
        System.out.println(resp.toString());
    }






}
