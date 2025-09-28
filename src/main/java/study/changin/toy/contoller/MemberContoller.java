package study.changin.toy.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.changin.toy.domain.Member;
import study.changin.toy.service.MemberService;


@Controller
public class MemberContoller {
    private MemberService memberService;

    //자동으로 다른 'Component'로부터 DI을 해준다.
    @Autowired
    public MemberContoller(MemberService ms){
        this.memberService = ms;
    }

    @GetMapping("join")
    public String joinPage(){
        return "join";
    }

    @GetMapping("join_result")
    public String join_result(@RequestParam String name){
        Member mem1 = new Member();
        mem1.setName(name);
        memberService.join(mem1);

        return "join_result";
    }
}
