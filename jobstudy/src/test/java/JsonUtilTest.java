import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import com.response.CommonResponse;
import com.utils.JsonUtils;

public class JsonUtilTest extends BaseTest{

    @Test
    public void test1(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("试试","试试就试试");
        CommonResponse<JSONObject> jsonObjectCommonResponse = CommonResponse.successResp(jsonObject);
        System.out.println(jsonObjectCommonResponse.toString());
        String string = JsonUtils.transferObjectToString(jsonObjectCommonResponse);
        System.out.println(string);
        JSONObject jsonObject1 = JsonUtils.transferStringToClass(string,JSONObject.class);
        System.out.println(jsonObject1);
    }

}
