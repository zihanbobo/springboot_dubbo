package consumer.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import cn.net.health.user.service.ApiDemoService;

@RestController
public class ApiDemoController {


    @Reference(version = "${demo.service.version}")
    private ApiDemoService apiDemoService;


    @GetMapping("/say/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return apiDemoService.sayHello(name);
    }


}
