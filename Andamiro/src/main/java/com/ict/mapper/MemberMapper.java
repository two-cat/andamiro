package com.ict.mapper;

import java.util.List;

import com.ict.domain.MemberVO;
import com.ict.domain.NotMemberException;

public interface MemberMapper {

	public int insertMember(MemberVO user);
	public MemberVO loginCheck(MemberVO user) throws NotMemberException;
	
	/** [회원가입 관련]-아이디 중복 여부를 체크하는 메소드 */
	
	//선생님이 주신건 boolean 타입이었는데 내거에 맞춰서 MemberVO로 바꿈(2월9일)
	   public MemberVO idCheck(String userid);
	   public List<MemberVO> getAllMembers();

	   public MemberVO findMemberByUserid(String userid) throws NotMemberException;

	   /** 회원 번호로 회원정보를 가져오는 메소드 */
	   public MemberVO findMemberByIdx(Integer idx);

	   /** 회원 정보를 검색하는 메소드(아이디,이름,이메일,주소 검색 관련) */
	   public List<MemberVO> findMember(String colType, String keyword);

	   /** 회원 정보를 수정하는 메소드 */
	   public int editMember(MemberVO user);

	   /** 회원 번호로 회원정보를 삭제하는 메소드 */
	   public int deleteMember(Integer idx);
}
