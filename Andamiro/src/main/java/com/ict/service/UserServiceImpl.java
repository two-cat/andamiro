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
	//����ڰ� �α����� �� �Է��� id, pwd
	@Override
	public MemberVO loginCheck(MemberVO user) throws NotMemberException {
		MemberVO dbUser = this.findMemberByUserid(user.getUserid());
		if(dbUser!=null) {
			//���̵� �ִٸ�
			if(!user.getPwd().equals(dbUser.getPwd())) {
				throw new NotMemberException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
		}
		return dbUser;
	}
	
	//ȸ�� ���̺� DB�� ����� id, pwd
	@Override
	public MemberVO findMemberByUserid(String userid) throws NotMemberException {
		MemberVO user = this.memberMapper.findMemberByUserid(userid);
		if(user==null) {
			throw new NotMemberException("�������� �ʴ� ���̵��Դϴ�.");
		}
		return user;
	}
	//--------------------------------------------------------------

	@Override
	public boolean idCheck(String userid) {
		MemberVO user = this.memberMapper.idCheck(userid);
		//isUse�� ��������ϱ� user ���̵� ��ġ�°� ���� null�� ���ٸ� ����ص� �ȴٴ� true ����
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
