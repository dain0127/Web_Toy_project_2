package study.changin.toy.contoller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    //GetMapping(string)같은 경우에는
    //URL에서 localhost:8080/string 따위로 get method방식으로 접근했을때.
    //자동으로 해당 메소드를 spring에서 호출하도록 알리는 annotaion이다.
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
        //자동으로 의존성이 주입된 model에 의해서,
        //data를 키로 하고, hello를 value로 하는 데이터베이스의 row값이 들어감.
        //이는 resource/template/hello.html 에 반영이 되어있음.

        return "hello";
        //해당 contoller의 String return값은
        //html의 문서의 제목을 의미한다.
        //이는 Template engine dependency (여기서는 Thymeleaf)
        //에서 model이라는 아키텍처 영역에서, 데이터를 가지고 와,
        //html template를 완성하고 html을 클라이언트에게 보낸다.
    }


    /* ========= 2. MVC를 이용한, template 엔진 방식 =========== */
    @GetMapping("hello-mvc")
    //@RequestParam같은 경우 url에서 쿼리 스트링을 통해 넘어온 것을
    //method의 paramater로 받을 수 있게 한다.
    //예를 들어 http://localhost:8080?name=hello 로 request에서의 url이 이렇다면
    //@RequestParam(key)가 붙은 paramater는 key에 알맞는 value값을 받는다.
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        //Model model같은 경우에는 @Controller가 선언된 class의 경우
        //spring에서 자동적으로 객체를 생성(또는 재사용)하여 메서드에 주입을 한다.

        //model의 경우에는 일종의 java 코드로 다룰 수 있는 database의 개념이다.
        //즉, SQL을 대체하는 addAttribute()따위의 메소드 호출로 INSERT문을
        //대체할 수 있다.

        return "hello-template";
        //마찬가지로, spring이 보낼 자원의 이름을 가리킨다.
        //hello-template.html에는 템플릿 엔진 문법에 의해,
        //model에 있는 data와 조합해 생성된 html 문서를 클라이언트에게 보낸다.
    }

    /* ========= 3. api를 이용한, 데이터 전송 방식 =========== */
    @GetMapping("hello-response_body")
    @ResponseBody //얘 같은 경우에는, return값이
                    // response의 body데이터에 그대로 들어간다.
    public String helloString(@RequestParam("name") String name){
        return "it's response body data : " + name;
    }


    @GetMapping("hello-api")
    @ResponseBody
    //기본적으로 객체를 반환할시, json방식으로 전달됨.
    public MyClass helloApi(@RequestParam("name") String name){
        MyClass myClass = new MyClass();
        myClass.setName(name);
        return myClass;
    }

    @Getter
    @Setter
    static class MyClass{
        private String name;
    }
}
