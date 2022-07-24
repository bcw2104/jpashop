package com.jpashop.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.jpashop.entity.Member;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
@Rollback(false)
public class MemberRepositoryTest {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void testSave() {
		Member member = new Member();
		
		member.setUsername("bcw");
		
		Long savedId = memberRepository.save(member);	
		
		System.out.println("====================================");
		
		em.flush();
		em.clear();
		
		Member findMember = memberRepository.find(savedId);
		
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		Assertions.assertThat(findMember).isEqualTo(member);
	}

	@Test
	public void testFind() {
		throw new RuntimeException("not yet implemented");
	}

}
