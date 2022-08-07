package jpabook.jpashop.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberApiController {
	private final MemberService memberService;
	
	
	@GetMapping("/api/v1/members")
	public List<Member> getMemberV1() {
		return memberService.findMembers();
	}
	@GetMapping("/api/v2/members")
	public Result getMemberV2() {
		List<Member> members = memberService.findMembers();
		
		List<MemberDto> memberDtos = members.stream().map(m -> new MemberDto(m.getId(),m.getName())).collect(Collectors.toList());
		
		return new Result(memberDtos.size(),memberDtos);
	}
	
	@PostMapping("/api/v1/members")
	public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
		log.info(member.toString());
		Long retId = memberService.join(member);
		return new CreateMemberResponse(retId);
	}
	
	//엔티티를 변경해도 api스팩이 변하지 않는다. #중요!!!
	@PostMapping("/api/v2/members")
	public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
		Member member = new Member();
		member.setName(request.getName());
		log.info(member.toString());
		Long retId = memberService.join(member);
		
		return new CreateMemberResponse(retId);
	}
	
	@PutMapping("/api/v2/members/{id}")
	public UpdateMemberResponse updateMemberV2(
			@PathVariable("id") Long id,
			@RequestBody @Valid UpdateMemberRequest request) {
	
		Long retId = memberService.update(id,request.getName());
		
		return new UpdateMemberResponse(retId);
	}
	
	
	@Data
	@AllArgsConstructor
	static class Result<T>{
		private int count;
		private T data;
	}
	
	@Data
	@AllArgsConstructor
	static class MemberDto{
		private Long id;
		private String name;
	}
	
	
	@Data
	static class CreateMemberRequest{
		@NotEmpty
		private String name;
	}
	
	@Data
	@AllArgsConstructor
	static class CreateMemberResponse{
		private Long id;
	}
	
	@Data
	static class UpdateMemberRequest{
		@NotEmpty
		private String name;
	}
	
	@Data
	@AllArgsConstructor
	static class UpdateMemberResponse{
		private Long id;
	}
}
