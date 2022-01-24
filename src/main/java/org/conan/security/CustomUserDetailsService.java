package org.conan.security;

import org.conan.domain.MemberVO;
import org.conan.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	//customerUserDetailsService는 스프링 시큐리티의 userDetailsService를 구현하고
	//MemberMapper 타입의 인스턴스를 주입받아서 실제 기능을 구현
	
	@Setter(onMethod_= {@Autowired})
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// MemberVO를 UserDetails 타입으로2
		//CustomUserDetailsService.java 수정 후 로그인 시도
		MemberVO vo=memberMapper.read(userName);
		log.warn("vovovovovovovovovo=============== : "+ vo);
		return vo==null? null : new CustomUser(vo);
	}

}
