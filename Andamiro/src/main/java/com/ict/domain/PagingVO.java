package com.ict.domain;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PagingVO {
	// ����¡ ó�� ���� ������Ƽ
	private int cpage;// ���� ������ ������ ��ȣ
	private int pageSize;// �� ������ �� ������ ��� ����
	private int totalCount;// �� �Խñ� ��
	private int pageCount;// ������ ��

	// DB���� ���ڵ带 ������� ���� ������Ƽ
	private int start;
	private int end;

	// ����¡ �� ó���� ���� ������Ƽ
	private int pagingBlock = 5;// �� �� �� ������ ������ ��
	private int prevBlock;// ���� 5��
	private int nextBlock;// ���� 5��

	// �˻� ���� ������Ƽ
	private String findType;// �˻� ����
	private String findKeyword;// �˻� Ű����
	public int getCg_num_fk() {
		return cg_num_fk;
	}


	public void setCg_num_fk(int cg_num_fk) {
		this.cg_num_fk = cg_num_fk;
	}

	private int cg_num_fk;
	
	//����¡������ ������ �����ϴ� �޼ҵ�
	public void init() {
		pageCount = (totalCount-1)/pageSize +1;
		if(cpage<1) {
			cpage=1; //1�������� ����Ʈ��
		}
		
		if(cpage>pageCount) {
			cpage=pageCount;//������ �������� ����
		}
		//[1] where rn between A and B�� �̿��� ���
		end = this.cpage * this.pageSize;
		start = end -(pageSize-1);
		
		//[2] where rn > A and rn < B
		
		//����¡ �� ó�� ����
		/*cpage
		 * [1][2][3][4][5]| [6][7][8][9][10]| [11][12][13][14][15] |[16]...
		 * 
		 * cpage		pagingBlock		prevBlock(����5��)		nextBlock(����5��)
		 * 1 ~ 5			5				0					6
		 * 6 ~ 10							5					11	
		 * 11 ~15							10					16
		 * 
		 * 	prevBlock=(cpage-1)/pagingBlock * pagingBlock
		 *  nextBlock= prevBlock  + (pagingBlock+1)
		 * */
		prevBlock=(cpage-1)/pagingBlock * pagingBlock;
		nextBlock= prevBlock  + (pagingBlock+1); 
		
	}
	
	
	public int getCpage() {
		return cpage;
	}
	public void setCpage(int cpage) {
		this.cpage = cpage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPagingBlock() {
		return pagingBlock;
	}
	public void setPagingBlock(int pagingBlock) {
		this.pagingBlock = pagingBlock;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
	public String getFindType() {
		return findType;
	}
	public void setFindType(String findType) {
		this.findType = findType;
	}
	public String getFindKeyword() {
		return findKeyword;
	}
	public void setFindKeyword(String findKeyword) {
		this.findKeyword = findKeyword;
	}
	@Override
	public String toString() {
		return "PagingVO [cpage=" + cpage + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", pageCount="
				+ pageCount + ", start=" + start + ", end=" + end + ", pagingBlock=" + pagingBlock + ", prevBlock="
				+ prevBlock + ", nextBlock=" + nextBlock + ", findType=" + findType + ", findKeyword=" + findKeyword
				+ "]";
	}
	
	//������ �׺���̼� ���ڿ� �����
	public String getPageNavi(String myctx, String loc, String userAgent) {
		
		findType=(findType==null)?"":findType;
		if(findKeyword==null) {
			findKeyword="";
		}else {
			//�������� IE�� ��� �˻��� �ѱ� ó���ϱ�
			if(userAgent.indexOf("MSIE")>-1 || userAgent.indexOf("Trident")>-1) {
				try {
					findKeyword =URLEncoder.encode(findKeyword,"UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		String qStr="?findType="+findType+"&findKeyword="+findKeyword;
		String link=myctx+"/"+loc+qStr;
		
		StringBuilder buf=new StringBuilder();		
		buf.append("<ul class='pagination' style='content-align:center'> ");
		if(prevBlock>0) {
			buf.append("<li>");
			buf.append("<a href='"+link+"&cpage="+prevBlock+"'>");
			buf.append("Prev");
			buf.append("</a>");
			buf.append("</li>");
		}
		for(int i=prevBlock+1;i<=nextBlock-1 && i<=pageCount;i++) {
			String css="";
			if(i==cpage) {
				css="active";
			}
			
			buf.append("<li class='"+css+"'>");
			buf.append("<a href='"+link+"&cpage="+i+"'>");
			buf.append(i);
			buf.append("</a>");
			buf.append("</li>");
		}
		if(nextBlock <= pageCount) {
			buf.append("<li>");
			buf.append("<a href='"+link+"&cpage="+nextBlock+"'>");
			buf.append("Next");
			buf.append("</a>");
			buf.append("</li>");
		}
		buf.append("</ul>");
		
		return buf.toString();
	}
	

}////////////////////////////////////////
