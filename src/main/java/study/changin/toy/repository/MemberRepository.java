package study.changin.toy.repository;

import study.changin.toy.domain.Member;

import java.util.List;
import java.util.Optional;


//일련의 클래스들에 대해 공통된 규약을 설정
//혹은 언제든지 내용물을 대체할 수 있도록 함.
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
