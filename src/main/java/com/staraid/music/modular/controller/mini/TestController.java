package com.staraid.music.modular.controller.mini;

import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiResource(name = "test")
public class TestController {
    @GetResource(name = "添加", path = "/test", requiredPermission = false, requiredLogin = false)
    public ResponseData<Boolean> add() {
        return new SuccessResponseData<>();
    }
}
