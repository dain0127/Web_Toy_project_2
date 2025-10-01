package study.changin.toy;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.changin.toy.contoller.MemberContoller;
import study.changin.toy.repository.*;
import study.changin.toy.service.MemberService;

import javax.sql.DataSource;

//@Configuration 클래스 자체는 스프링이 관리하고,
//그 안에서 @Bean 메서드를 호출해서 '리턴 객체'를 컨테이너에 집어넣는 것입니다.
@Configuration
public class SpringConfig {

    /*
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource ds){
        this.dataSource=ds;
    }
    */

    private EntityManager em;

    @Autowired
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    //@Bean은 클래스가 아니라 메서드에 붙여서
    //“이 메서드가 리턴하는 객체를 빈으로 등록해라” 라는 의미
    //빈이라는 뜻은, 만약에 컴포넌트가 빈으로 등록된 객체가 필요하면,
    //Spring에서 알아서 주입한다는 의미이다.
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
