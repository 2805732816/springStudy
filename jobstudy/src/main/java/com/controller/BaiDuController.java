package com.controller;


import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.interfaces.BaiDuService;
import com.utils.JsonUtils;
import com.utils.RetrofitUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class BaiDuController  {

    public void get() throws IOException {
        Map<String,String> param = new HashMap<>();
        Map<String,String> header = new HashMap<>();
        param.put("name","caoxiaoying");
        BaiDuService service = RetrofitUtils.getService(BaiDuService.class, "https://www.baidu.com");
        Call<ResponseBody> call = service.get(param, header);
        Response<ResponseBody> response=call.execute();
        String result=response.body().string();
        log.info("\n\n学习retrofit库的get请求(BaiDuController.get)\nrequest={}\nresponse={}",
                JsonUtils.transferObjectToString(param),JsonUtils.transferObjectToString(result));
    }

}
