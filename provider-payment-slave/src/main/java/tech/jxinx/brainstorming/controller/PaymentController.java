package tech.jxinx.brainstorming.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.jxinx.brainstorming.entity.ApiResult;
import tech.jxinx.brainstorming.entity.Payment;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public ApiResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return new ApiResult(0, "获取成功，id：" + id + "，serverPort：" + serverPort, null);
    }

}
