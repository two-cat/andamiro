package com.ict.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ict.domain.CategoryVO;

@Repository
public class CategoryDAOMyBatis implements CategoryDAO {
	
	private final String NS="com.ict.persistence.CategoryMapper";
	//datasource-context.xml에 빈 등록 되어 있음
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate ses;

	@Override
	public List<CategoryVO> categoryAll() {

		return ses.selectList(NS+".categoryAll");
	}

	@Override
	public int insertCategory(CategoryVO cvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategory(int cg_num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
