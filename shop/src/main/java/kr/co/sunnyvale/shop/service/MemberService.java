package kr.co.sunnyvale.shop.service;

import kr.co.sunnyvale.shop.domain.Member;
import kr.co.sunnyvale.shop.domain.Role;
import kr.co.sunnyvale.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member getMember(String email){

        return memberRepository.getMember(email);
    }

    @Transactional
    public Member addMember(
            String email,
            String name,
            String password
    ){
        Role role = new Role();
        role.setId(new Long(1));

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        Member member = new Member();
        member.setEmail(email);
        member.setName(name);
        member.setPassword( PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password) );
        member.setRegdate(LocalDateTime.now());
        member.setRoles(roleSet);

        System.out.println(member.getPassword());
        return memberRepository.save(member);
    }

}