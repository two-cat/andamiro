package com.ict.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ict.domain.ProductVO;

@Repository
public class ProductDAOMyBatis implements ProductDAO {
	
	private final String NS="com.ict.persistence.ProductMapper";
	
	//SqlSessionTemplate프로퍼티 선언하고 주입받기
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate ses;
	//datasource-context.xml 에 빈으로 등록됨
	

	@Override
	public int productInsert(ProductVO item) {
		return ses.insert(NS+".productInsert", item);
	}

	@Override
	public List<ProductVO> productList() {
		return ses.selectList(NS+".productList");
	}

	@Override
	public List<ProductVO>  selectByCgnum(int cg_num_fk) {	
		return ses.selectList(NS+".selectBycgnum", cg_num_fk);
	}
	@Override
	public List<ProductVO> selectByPspec(String pspec) {	
		return ses.selectList(NS+".selectByPspec", pspec);
	}

	@Override
	public ProductVO selectByPnum(Integer pnum) {
		return ses.selectOne(NS+".selectByPnum", pnum);
	}

}
