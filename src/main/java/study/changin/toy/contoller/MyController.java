package study.changin.toy.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
        //자동으로 의존성이 주입된 model에 의해서,
        //data를 키로 하고, hello를 value로 하는 데이터베이스의 row값이 들어감.
        //이는 resource/template/hello.html 에 반영이 되어있음.
        return "hello";
        //해당 contoller의 String return값은
        //html의 문서의 제목이 된다.
        //이는 Template engine dependency (여기서는 Thymeleaf)
        //에서 model이라는 아키텍처 영역에서, 데이터를 가지고 와,
        //html template를 완성하고 html을 클라이언트에게 보낸다.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}
