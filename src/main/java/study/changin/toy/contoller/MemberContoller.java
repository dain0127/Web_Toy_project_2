package study.changin.toy.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.changin.toy.domain.Member;
import study.changin.toy.service.MemberService;

import java.util.List;


@Controller
public class MemberContoller {
    private MemberService memberService;

    //자동으로 다른 'Component'로부터 DI을 해준다.
    public MemberContoller(MemberService ms){
        this.memberService = ms;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }


    @PostMapping("/members/new")
    //MemberForm form이라는 파라미터에 어떻게 데이터를 복사한건지 모르겠어.
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }


    @GetMapping("/members")
    public String showMember(Model model){
        List<Member> members = memberService.findAllMemers();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}
