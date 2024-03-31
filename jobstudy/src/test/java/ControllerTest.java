import com.controller.BaiDuController;
import com.interfaces.BaiDuService;
import okhttp3.ResponseBody;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求方式：@GET @HEAD @POST @PUT @DELETE @OPTIONS @HTTP
 * 请求头：@Header @HeaderMap @Headers
 * 查询参数：@Query @QueryMap @QueryName
 * 路径参数：@Path
 * 形式编码参数：@Field @FieldMap @FormUrlEncoded
 * 请求体：@Body
 * 上传文件：@Multipart @Part @PartMap
 * 网址参数：@Url
 * 原文链接：https://blog.csdn.net/Mango_Bin/article/details/122473228
 */
public class ControllerTest extends BaseTest{
    @Autowired
    BaiDuController baiDuController;
    @Test
    public void test1() throws IOException {
        Map<String,String> params = new HashMap<>();
        Map<String,String> header = new HashMap<>();
        baiDuController.get();

    }
}
