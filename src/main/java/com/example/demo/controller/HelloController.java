package com.example.demo.controller;

import com.example.demo.domain.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


//    html만 return
//    메서드+html
    @GetMapping("/hello-spring-html")
    public String helloSpringHtml(){
        return "hello_bin";
    }

//    html + data
//    responseBody 어노테이션이 없고, Return 타입이 String이면,
//    templates/xxxx.html 을 찾으러 간다.
//    Model을 주입받지 않고, html만을 리턴하면, 정적인 html을 return하게 된다.
//    RequestParam이란 url의 ?을 통해 데이터를 서버로 넘어온 데이터를 꺼내는 것.
    @GetMapping("/hello-spring-html-data")
    public String helloSpringHtmlData(@RequestParam(value="input_name", required = false)String name, Model model){
        model.addAttribute("html_name", name);
        return "hello";
    }

//    frontend / backend 구분 controller
    @GetMapping("/hello-spring-frontend")
    public String helloSpringFrontend(){
        return "hello_frontend";
    }

//    이름(data)만을 return해주는 api
    @GetMapping("/hello-string")
    @ResponseBody
//    text타입
    public String helloString(){
        return "kimseonguk";
    }

//    return하는 데이터 타입은 현재 JSON이 웹서버에서 표준이 되어가고 있다.
//    json은 key:value로 이루어진 데이터 타입으로서, 자바의 객체와 유사하다.
//    객체를 만들어서, 객체를 return하면 json타입으로 자동 return이 된다.
    @GetMapping("/hello-json")
    @ResponseBody
//    json타입
    public Hello helloJson(){
        Hello h1 = new Hello();
        h1.setName("kimseonguk");
        h1.setAge(20);
        return h1;
    }

    @PostMapping("hello-post-form")
    @ResponseBody
    public String helloPostForm(@RequestParam(value="a1")String a1, @RequestParam(value="a2")String a2, @RequestParam(value="a3")String a3){
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        return "ok";
    }


    @PostMapping("hello-post")
    @ResponseBody
    public String helloPost(Hello hello){
        System.out.println(hello.getName());
        System.out.println(hello.getAge());
        return "ok";
    }

//요청방식에는 크게 2가지가 있다.
//1)get요청
//url을 통해 요청하는 것
//url에 필요한 데이터도 넣어서 요청하는 것
//@RequestParam
//2)post요청
//2-1)form-data에 넣어서 요청하는 방식
//@RequestParam
//회원가입
//2-2)body에 넣어서 보내는 방식(raw-json)
//@RequestBody

}
