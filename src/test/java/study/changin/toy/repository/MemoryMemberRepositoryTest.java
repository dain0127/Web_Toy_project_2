package study.changin.toy.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import study.changin.toy.domain.Member;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {
    MemberRepository memberRepository = new MemoryMemberRepository();

    //@AfterEach의 경우
    //class단에서 실행을 하는 경우, 각각의 test 메소드가 실행된 직후.
    //해당 어노테이션의 메소드가 실행된다.
    //해당 afterEach 메소드 같은 경우에는, test환경을 원래대로 되돌리는 기능을 넣어주면 된다.
    @AfterEach
    public void afterEach() {
        memberRepository.clean();
    }

    //Test 어노테이션은, junit 프레임워크에 의해서 Test의 대상이 되는 메소드를 명시한다.
    @Test
    void save(){
        Member member1 = new Member();
        member1.setName("changin");

        memberRepository.save(member1);

        Member result = memberRepository.findById(member1.getId()).get();
        assertThat(member1).isEqualTo(result);
    }

    @Test
    void findByName(){
        Member member1 = new Member();
        member1.setName("changin");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("dongin");
        memberRepository.save(member2);

        Member result = memberRepository.findByName(member1.getName()).get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll(){
        Member[] members = {new Member(), new Member(), new Member()};
        for(int i=0 ; i<members.length ; i++){
            members[i].setName("changin : "+i);
            memberRepository.save(members[i]);
        }

        List<Member> result = memberRepository.findAll();
        result.forEach(m -> System.out.println(m.getName()));
    }
}
