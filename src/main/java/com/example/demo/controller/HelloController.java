package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//컨트롤러 어노테이션을 통해 클라이언트(사용자)의 요청을 받아주는 역할
@Controller
public class HelloController {

//    GetMapping은 사용자가 get요청을 했을경우 받아주는 역할
//    Post요청 같은경우엔 PostMapping을 사용
//    GetMapping, PostMapping 뒤에 받아주는 url을 넣어 경로를 잡아준다.
    @GetMapping("/hello-spring")
//    ResponseBody가 있으면 사용자에게 data를 내려주고,
//    ResponseBody가 없으면 사용자에게 화면을 내려준다는 뜻.
    @ResponseBody
    public String helloSpring(){
        return "hello-world-spring";
    }
}
