package com.prac.angular.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PaginatedList<TItem> implements Paginated<TItem>, Collection<TItem>, Serializable{
	
	 private static final long serialVersionUID = -4590879607779544965L;
	 
	 private Paginated<TItem> paginatedInfo;
	 
    /**
     * 생성자.
     * 
     * @param items
     *            조회된 아이템 리스트
     * @param pageable
     *            페이지 요청 정보
     * @param totalCount
     *            토탈 카운트
     */
	 public PaginatedList (List<TItem> items, Pageable pageable, long totalCount) {
		 this.paginatedInfo = new PaginatedInfo<TItem>(items, pageable, totalCount);
	 }
	 
    /**
     * 페이지 매김 정보를 반환한다.
     */
	 public Paginated<TItem> getPaginatedInfo() {
		 return this.paginatedInfo;
	 }
	 
	@Override
	public int size() {
		return this.paginatedInfo.getPageSize();
	}

	@Override
	public boolean isEmpty() {
		return getItems().isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return getItems().contains(o);
	}

	@Override
	public Iterator<TItem> iterator() {
		return getItems().iterator();
	}

	@Override
	public Object[] toArray() {
		return getItems().toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return getItems().toArray(a);
	}

	@Override
	public boolean add(TItem e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return getItems().contains(c);
	}

	@Override
	public boolean addAll(Collection<? extends TItem> c) {
		 throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		 throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		 throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		 throw new UnsupportedOperationException();	
	}

	@Override
	public long getTotalCount() {
		return this.paginatedInfo.getTotalCount();
	}

	@Override
	public List<TItem> getItems() {
		return getItems();
	}

	@Override
	public void setItems(List<TItem> list) {
		this.paginatedInfo.setItems(list);
		
	}

	@Override
	public int getPageSize() {
		return this.paginatedInfo.getPageSize();
	}

	@Override
	public int getPageUnitSize() {
		return this.paginatedInfo.getPageUnitSize();
	}

	@Override
	public int getCurrentPage() {
		return this.paginatedInfo.getCurrentPage();
	}

	@Override
	public long getNo() {
		return this.paginatedInfo.getNo();
	}

	@Override
	public long getReversNo() {
		return this.paginatedInfo.getReversNo();
	}

	@Override
	public int getFirstPage() {
		return this.paginatedInfo.getFirstPage();
	}

	@Override
	public int getLastPage() {
		return this.paginatedInfo.getLastPage();
	}

	@Override
	public int getBeginPage() {
		return this.paginatedInfo.getBeginPage();
	}

	@Override
	public int getEndPage() {
		return this.paginatedInfo.getEndPage();
	}

	@Override
	public int getBeginPageOfPrevUnit() {
		return this.paginatedInfo.getBeginPageOfPrevUnit();
	}

	@Override
	public int getEndPageOfPrevUnit() {
		return this.paginatedInfo.getEndPageOfPrevUnit();
	}

	@Override
	public int getBeginPageOfNextUnit() {
		return this.paginatedInfo.getBeginPageOfNextUnit();
	}

	@Override
	public int getEndPageOfNextUnit() {
		return this.paginatedInfo.getEndPageOfNextUnit();
	}

	@Override
	public boolean isNotFirstPage() {
		return this.paginatedInfo.isNotFirstPage();
	}

	@Override
	public boolean isNotLastPage() {
		return this.paginatedInfo.isNotLastPage();
	}

	@Override
	public boolean isHasPrevUnit() {
		return this.paginatedInfo.isHasPrevUnit();
	}

	@Override
	public boolean isHasNextUnit() {
		return this.paginatedInfo.isHasNextUnit();
	}

}
