package study.changin.toy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.changin.toy.domain.Member;

import java.util.Optional;

//JpaRepository 인터페이스를 상속 받은 SpringDataJpaMemberRepository는.
//자동적으로 spring 컨테이너에서 해당 인터페이스의 추상메소드를 구현한 객체를
//Bean으로서 관리를 한다.
interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    Optional<Member> findByName(String name);
}
