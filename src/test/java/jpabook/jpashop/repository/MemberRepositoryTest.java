package jpabook.jpashop.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.repository.MemberRepository;

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
	}

	@Test
	public void testFind() {
		throw new RuntimeException("not yet implemented");
	}

}
