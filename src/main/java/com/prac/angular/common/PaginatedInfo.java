package com.prac.angular.common;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PaginatedInfo<TItem> implements Paginated<TItem>, Serializable {
	private long 		no;						//리스트 시작행 번호
	private long 		reversNo;				//리스트 시작행 번호(역순)
	private int 		firstPage;				//첫 페이지
	private int 		lastPage;				//마지막 페이지
	private int 		beginPage;				//페이지 단위의 시작 페이지
	private int 		endPage;				//페이지 단위의 종료 페이지
	private int 		beginPageOfPrevUnit;	//이전 페이지 단위의 시작 페이지
	private int 		endPageOfPrevUnit;		//이전 페이지 단위의 종료 페이지
	private int 		beginPageOfNextUnit;		//다음 페이지 단위의 시작 페이지
	private int 		endPageOfNextUnit;		//다음 페이지 단위의 종료 페이지
	
	private List<TItem> items;					//조회된 아이템 리스트
	private Pageable 	pageable;				//페이지 요청 정보
	private long		totalCount;				//토탈 카운트 
	
	public PaginatedInfo(List<TItem> items, Pageable pageable, long totalCount) {
		if(items == null) {
			throw new IllegalArgumentException("[item] must not be null");
		}
		if(pageable == null) {
			throw new IllegalArgumentException("[pageable] must not be null");
		}
		if(totalCount < 0) {
			throw new IllegalArgumentException("[totalCount] must not be null");
		}
		
		this.items = items;
		this.pageable = pageable;
		this.totalCount = totalCount;
		
		this.no = 0;
		this.reversNo = 0;
		this.firstPage = 0;
		this.lastPage = 0;
		this.beginPage = 0;
		this.endPage = 0;
		this.beginPageOfPrevUnit = 0;
		this.endPageOfPrevUnit = 0;
		this.beginPageOfNextUnit = 0;
		this.endPageOfNextUnit = 0;
		
		if(this.totalCount > 0) {
			int size = this.pageable.getSize();
			int unitSize = this.pageable.getUnitSize();
			
			int page = this.pageable.getPage();
			
			if(size > 0) {
				//첫 페이지
				this.firstPage = 1;
				
				//  totalCount / 한페이지 표시 사이즈 -> 10.2 나와도 11로 올림
				this.lastPage = (int) Math.ceil(this.totalCount / (double) size );
				
				if(page > this.lastPage) {
					return;
				}
				
				//블럭의 시작페이지
				this.beginPage = (page / unitSize) * unitSize + 1;
				if(this.beginPage > this.lastPage) {
					this.beginPage = this.lastPage;
				}
				
				//블럭의 종료 페이지
				this.endPage = (page / unitSize) * unitSize + unitSize;
				if(this.endPage > this.lastPage) {
					this.endPage  = this.lastPage;
				}
				
				//이전 블럭의 시작 페이지
				this.beginPageOfPrevUnit = ( (page / unitSize) - 1 ) * unitSize + 1;
				if(this.beginPageOfPrevUnit < 1) {
					this.beginPageOfPrevUnit = 0;
				}else {
					//이전 블럭의 종료 페이지
					this.endPageOfPrevUnit = (page / unitSize) * unitSize;
					if(this.endPageOfPrevUnit < 1) {
						this.endPageOfPrevUnit = 0;
					}
				}
				
				//다음 블럭의 시작 페이지
				this.beginPageOfNextUnit = ((page / unitSize) + 1) * unitSize + 1;
				if(this.beginPageOfNextUnit > this.lastPage) {
					this.beginPageOfNextUnit = 0;
				}else {
					//다음 블럭의 종료 페이지
					this.endPageOfNextUnit = ((page / unitSize) + 2) * unitSize;
					if(this.endPageOfNextUnit > this.lastPage) {
						this.endPageOfNextUnit = this.lastPage;
					}
				}
			}else {
				page = 0;
			}
			
			//시작 행 번호
			this.no = page * size + 1;
			
			//시작 행 번호 (역방향)
			this.reversNo = this.totalCount - page * size;
		}
	}
	
	@Override
	public long getTotalCount() {
		// TODO Auto-generated method stub
		return this.totalCount;
	}

	@Override
	public List<TItem> getItems() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(this.items);
	}

	@Override
	public void setItems(List<TItem> list) {
		this.items = list;
		
	}

	@Override
	public int getPageSize() {
		return this.pageable.getSize();
	}

	@Override
	public int getPageUnitSize() {
		return this.pageable.getUnitSize();
	}

	@Override
	public int getCurrentPage() {
		return (this.pageable.getPage() + 1);
	}

	@Override
	public long getNo() {
		return this.no;
	}

	@Override
	public long getReverseNo() {
		return this.reversNo;
	}

	@Override
	public int getFirstPage() {
		return this.firstPage;
	}

	@Override
	public int getLastPage() {
		return this.lastPage;
	}

	@Override
	public int getBeginPage() {
		return this.beginPage;
	}

	@Override
	public int getEndPage() {
		return this.endPage;
	}

	@Override
	public int getBeginPageOfPrevUnit() {
		return this.beginPageOfPrevUnit;
	}

	@Override
	public int getEndPageOfPrevUnit() {
		return this.endPageOfPrevUnit;
	}

	@Override
	public int getBeginPageOfNextUnit() {
		return this.beginPageOfNextUnit;
	}

	@Override
	public int getEndPageOfNextUnit() {
		return this.endPageOfNextUnit;
	}

	@Override
	public boolean isNotFirstPage() {
		return getCurrentPage() > getFirstPage();
	}

	@Override
	public boolean isNotLastPage() {
		return getCurrentPage() < getLastPage();
	}

	@Override
	public boolean isHasPrevUnit() {
		return getBeginPageOfPrevUnit() > 0;
	}

	@Override
	public boolean isHasNextUnit() {
		return getBeginPageOfNextUnit() > 0;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
