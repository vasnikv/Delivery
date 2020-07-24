package ru.iv.delivery.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import petrov.delivery.webapi.ParamRespCompanyInfo;
import petrov.delivery.webapi.ParamRespProduct;
import petrov.delivery.webapi.api.IMobileClientApi;
import org.springframework.web.bind.annotation.RestController;
import ru.iv.utils.MockMobileClientApiResponse;

@RestController
public class MobileRestController  implements IMobileClientApi {

    @NotNull
    @Override
    @GetMapping("/getcompanyinfo")
    public ParamRespCompanyInfo getCompanyInfo() {
        return MockMobileClientApiResponse.INSTANCE.getCompanyInfo();
    }

    @NotNull
    @Override
    @GetMapping("/getallproducts")
    public ParamRespProduct getProducts() {
        return MockMobileClientApiResponse.INSTANCE.getProducts();
    }
}
