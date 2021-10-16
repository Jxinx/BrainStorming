package tech.jxinx.brainstorming.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jxinx.brainstorming.entity.ApiResult;
import tech.jxinx.brainstorming.entity.Payment;

@RestController
public class PaymentController {

    @GetMapping("/payment/get/{id}")
    public ApiResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return new ApiResult(0, "获取成功，id：" + id, null);
    }

}
