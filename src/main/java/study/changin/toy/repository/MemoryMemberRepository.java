package study.changin.toy.repository;

import org.springframework.stereotype.Repository;
import study.changin.toy.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{
    private final static Map<Long, Member> members = new HashMap<Long,Member>();
    private static Long count = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++count);
        members.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(members.get(id));
    }

    @Override
    public Optional<Member> findByName(String name){
        return members.values().stream()
                .filter(member->member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(members.values());
    }

    public void clean(){
        members.clear();
    }
}
