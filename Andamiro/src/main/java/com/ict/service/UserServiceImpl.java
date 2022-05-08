package com.ict.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ict.domain.MemberVO;
import com.ict.domain.NotMemberException;
import com.ict.mapper.MemberMapper;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Inject
	private MemberMapper memberMapper;
	
	@Override
	public int insertMember(MemberVO user) {
		return memberMapper.insertMember(user);
	}

	//--------------------------------------------------------------
	//사용자가 로그인할 때 입력한 id, pwd
	@Override
	public MemberVO loginCheck(MemberVO user) throws NotMemberException {
		MemberVO dbUser = this.findMemberByUserid(user.getUserid());
		if(dbUser!=null) {
			//아이디가 있다면
			if(!user.getPwd().equals(dbUser.getPwd())) {
				throw new NotMemberException("비밀번호가 일치하지 않습니다.");
			}
		}
		return dbUser;
	}
	
	//회원 테이블 DB에 저장된 id, pwd
	@Override
	public MemberVO findMemberByUserid(String userid) throws NotMemberException {
		MemberVO user = this.memberMapper.findMemberByUserid(userid);
		if(user==null) {
			throw new NotMemberException("존재하지 않는 아이디입니다.");
		}
		return user;
	}
	//--------------------------------------------------------------

	@Override
	public boolean idCheck(String userid) {
		MemberVO user = this.memberMapper.idCheck(userid);
		//isUse로 물어봤으니까 user 아이디가 겹치는게 없고 null과 같다면 사용해도 된다는 true 리턴
		if(user==null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<MemberVO> getAllMembers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MemberVO findMemberByIdx(Integer idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberVO> findMember(String colType, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int editMember(MemberVO user) {
		// TODO Auto-generated method stub
		return memberMapper.editMember(user);
	}

	@Override
	public int deleteMember(Integer idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
