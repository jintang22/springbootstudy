package examples.boot.springboard.repository;

import examples.boot.springboard.domain.Member;
import examples.boot.springboard.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void test1(){
        Member member = memberRepository.getMemberByEmail("abc@gamil.com");
        System.out.println(member.getName());

        Set<Role> roleSet = member.getRoleSet();    // 이때 roles 조회가 일어나지 않는다.
        //for(Role role : member.getRoleSet()){

        System.out.println(roleSet.getClass().getName());
        System.out.println(roleSet.size());

        for(Role role : roleSet) {                  // 이때 role 조회가 일어난다.

            System.out.println(role.getId() + role.getName());
        }

    }

    @Test
    public void test2(){
        Member member = memberRepository.getMemberAndRolesByEmail("abc@gamil.com"); // 이때 role 테이블까지 join해서 한번에 가져온다.
        System.out.println(member.getName());

        Set<Role> roleSet = member.getRoleSet();
        //for(Role role : member.getRoleSet()){

        System.out.println(roleSet.getClass().getName());
        System.out.println(roleSet.size());

        for(Role role : roleSet) {

            System.out.println(role.getId() + role.getName());
        }

    }
}
