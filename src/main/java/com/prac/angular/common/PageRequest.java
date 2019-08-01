package com.prac.angular.common;

import java.util.List;

import javax.validation.constraints.Min;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.prac.angular.common.Sort.Order;

public class PageRequest implements Pageable{
	
	@Min(0)
	private int page;
	
	@Min(0)
	private int size;
	
	@Min(0)
	private int unitSize;
	
	private Sort sort;
	
    /**
     * 기본 생성자
     */
    public PageRequest(){
        this((Sort) null);
    }
	
    /**
     * 생성자.
     * @param orders
     * 		정렬식 리스트
     */
	public PageRequest(String... orders) {
		this(new Sort(orders));
	}
	
    /**
     * 생성자.
     * @param orders
     * 		정렬식 리스트
     */
	public PageRequest(Order... orders) {
		this(new Sort(orders));
	}
	
    /**
     * 생성자.
     * @param orders
     * 		정렬식 리스트
     */
	public PageRequest(List<Order> orders) {
		this(new Sort(orders));
	}
	
	/**
	 *생성자. 
	 * @param sort
	 * 		정렬
	 */
	public PageRequest(Sort sort) {
		this(0, DEFAULT_SIZE, DEFAULT_UNIT_SIZE, sort);
	}
	
	/**
	 * 생성자.
	 * @param page
	 * 		페이지
	 */
	public PageRequest(int page) {
		this(page, (Sort)null);
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param orders
     *            정렬식 리스트
     */
	public PageRequest(int page, String...orders) {
		this(page, new Sort(orders));
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param orders
     *            정렬식 리스트
     */
	public PageRequest(int page, Order... orders) {
		this(page, new Sort(orders));
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param orders
     *            정렬식 리스트
     */
	public PageRequest(int page, List<Order> orders) {
		this(page, new Sort(orders));
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param sort
     *            정렬
     */
	public PageRequest(int page, Sort sort) {
		this(page, DEFAULT_SIZE, DEFAULT_UNIT_SIZE, sort);
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param size
     *            페이지 사이즈
     */
	public PageRequest(int page, int size) {
		this(page, size, (Sort)null);
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param size
     *            페이지 사이즈
     * @param orders
     *            정렬식 리스트
     */
	public PageRequest(int page, int size, String ...orders) {
		this(page, size, new Sort(orders));
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param size
     *            페이지 사이즈
     * @param orders
     *            정렬식 리스트
     */
	public PageRequest(int page, int size, Order... orders) {
		this(page, size, new Sort(orders));
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param size
     *            페이지 사이즈
     * @param orders
     *            정렬식 리스트
     */
	public PageRequest(int page, int size, List<Order>orders) {
		this(page, size, new Sort(orders));
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param size
     *            페이지 사이즈
     * @param sort
     *            정렬
     */
	public PageRequest(int page, int size, Sort sort) {
		this(page, size, DEFAULT_UNIT_SIZE, sort);
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param size
     *            페이지 사이즈
     * @param unitSize
     *            페이지 단위 사이즈
     */
	public PageRequest(int page, int size, int unitSize) {
		this(page, size, unitSize, (Sort)null);
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param size
     *            페이지 사이즈
     * @param unitSize
     *            페이지 단위 사이즈
     * @param orders
     *            정렬식 리스트
     */
	public PageRequest(int page, int size, int unitSize, String... orders) {
		this(page, size, unitSize, new Sort(orders));
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param size
     *            페이지 사이즈
     * @param unitSize
     *            페이지 단위 사이즈
     * @param orders
     *            정렬식 리스트
     */
	public PageRequest(int page, int size, int unitSize, Order orders) {
		this(page, size, unitSize, new Sort(orders));
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param size
     *            페이지 사이즈
     * @param unitSize
     *            페이지 단위 사이즈
     * @param orders
     *            정렬식 리스트
     */
	public PageRequest(int page, int size, int unitSize, List<Order>orders) {
		this(page, size, unitSize, new Sort(orders));
	}
	
    /**
     * 생성자.
     * 
     * @param page
     *            페이지
     * @param size
     *            페이지 사이즈
     * @param unitSize
     *            페이지 단위 사이즈
     * @param sort
     *            정렬
     */
	public PageRequest(int page, int size, int unitSize, Sort sort) {
		this.setPage(page);
		this.setSize(size);
		this.setUnitSize(unitSize);
		this.setSort(sort);
	}
	


	@Override
	public int getPage() {
		// TODO Auto-generated method stub
		return page;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getUnitSize() {
		// TODO Auto-generated method stub
		return unitSize;
	}

	@Override
	public int getOffset() {
		// TODO Auto-generated method stub
		return (page * size);
	}

	@Override
	public Sort getSort() {
		// TODO Auto-generated method stub
		return sort;
	}
	
	
	
	///////////////////////////// setter ///////////////////////////
	public void setPage(int page) {
		if(page < 0) {
			throw new IllegalArgumentException("[page] must not be negative");
		}
		this.page = page;
	}

	public void setSize(int size) {
		if(size < 0) {
			throw new IllegalArgumentException("[size] must not be negative");
		}
		this.size = size;
	}

	public void setUnitSize(int unitSize) {
		if(unitSize < 0) {
			throw new IllegalArgumentException("[unitSize] must not be negative");
		}
		this.unitSize = unitSize;
	}
	
	
	public void setSort(Sort sort) {
		this.sort = sort;
	}
	
	public void setSort(String... orders) {
		setSort(new Sort(orders));
	}
	
	public void setSort(Order...orders) {
		setSort(new Sort(orders));
	}
	
	public void setSort(List<Order> orders) {
		setSort(new Sort(orders));
	}
	
    /**
     * 정렬 파라미터가 없을경우 설정한다.
     */
	public void setSortIfNull(Sort sort) {
		if(this.sort == null) {
			this.sort = sort;
		}
	}
	
	public void setSortIfNull(String... orders) {
		setSortIfNull(new Sort(orders));
	}
	
	public void setSortIfNull(Order orders) {
		setSortIfNull(new Sort(orders));
	}
	
	public void setSortIfNull(List<Order> orders) {
		setSortIfNull(new Sort(orders));
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
