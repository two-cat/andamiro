package com.ict.service;

import java.util.List;

import com.ict.domain.MemberVO;
import com.ict.domain.NotMemberException;

public interface UserService {
	
	public int insertMember(MemberVO user);
	public MemberVO loginCheck(MemberVO user) throws NotMemberException;
	
	/** [ȸ������ ����]-���̵� �ߺ� ���θ� üũ�ϴ� �޼ҵ� */
	   public boolean idCheck(String userid);

	   public List<MemberVO> getAllMembers();

	   public MemberVO findMemberByUserid(String userid) throws NotMemberException;

	   /** ȸ�� ��ȣ�� ȸ�������� �������� �޼ҵ� */
	   public MemberVO findMemberByIdx(Integer idx);

	   /** ȸ�� ������ �˻��ϴ� �޼ҵ�(���̵�,�̸�,�̸���,�ּ� �˻� ����) */
	   public List<MemberVO> findMember(String colType, String keyword);

	   /** ȸ�� ������ �����ϴ� �޼ҵ� */
	   public int editMember(MemberVO user);

	   /** ȸ�� ��ȣ�� ȸ�������� �����ϴ� �޼ҵ� */
	   public int deleteMember(Integer idx);
}
