package study.changin.toy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.changin.toy.domain.Member;
import study.changin.toy.repository.MemberRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {
    private final MemberRepository repo;


    //외부(예를 들면 테스트 케이스)에서 참조값 주입
    @Autowired
    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    /**
     * 회원 가입.
     * 1. 이름 중복 여부를 확인한다. 중복시, 예외를 던지고 프로그램을 종료한다.
     * 2. member를 repo에 저장한다.
     * 3. id를 반환한다.
     */
    public Long join(Member member) throws IllegalStateException {
        //같은 이름을 가진 회원 중복 X
        validateDuplicateMember(member);
        repo.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        repo.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findAllMemers() {
        return repo.findAll();
    }

    /**
     * 회원 하나 찾기
     */
    public Optional<Member> findOneById(Long id) {
        return repo.findById(id);
    }
}
