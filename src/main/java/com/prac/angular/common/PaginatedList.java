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
	    public PaginatedList(List<TItem> items, Pageable pageable, long totalCount)
	    {
	        this.paginatedInfo = new PaginatedInfo<TItem>(items, pageable, totalCount);

	    }





	    /**
	     * 페이지 매김 정보를 반환한다.
	     */
	    public Paginated<TItem> getPaginatedInfo()
	    {
	        return paginatedInfo;
	    }





	    @Override
	    public long getTotalCount()
	    {
	        return paginatedInfo.getTotalCount();
	    }





	    @Override
	    public List<TItem> getItems()
	    {
	        return paginatedInfo.getItems();
	    }





	    @Override
	    public void setItems(List<TItem> list)
	    {
	        this.paginatedInfo.setItems(list);
	    }





	    @Override
	    public int getPageSize()
	    {
	        return paginatedInfo.getPageSize();
	    }





	    @Override
	    public int getPageUnitSize()
	    {
	        return paginatedInfo.getPageUnitSize();
	    }





	    @Override
	    public int getCurrentPage()
	    {
	        return paginatedInfo.getCurrentPage();
	    }





	    @Override
	    public long getNo()
	    {
	        return paginatedInfo.getNo();
	    }





	    @Override
	    public long getReverseNo()
	    {
	        return paginatedInfo.getReverseNo();
	    }





	    @Override
	    public int getFirstPage()
	    {
	        return paginatedInfo.getFirstPage();
	    }





	    @Override
	    public int getLastPage()
	    {
	        return paginatedInfo.getLastPage();
	    }





	    @Override
	    public int getBeginPage()
	    {
	        return paginatedInfo.getBeginPage();
	    }





	    @Override
	    public int getEndPage()
	    {
	        return paginatedInfo.getEndPage();
	    }





	    @Override
	    public int getBeginPageOfPrevUnit()
	    {
	        return paginatedInfo.getBeginPageOfPrevUnit();
	    }





	    @Override
	    public int getEndPageOfPrevUnit()
	    {
	        return paginatedInfo.getEndPageOfPrevUnit();
	    }





	    @Override
	    public int getBeginPageOfNextUnit()
	    {
	        return paginatedInfo.getBeginPageOfNextUnit();
	    }





	    @Override
	    public int getEndPageOfNextUnit()
	    {
	        return paginatedInfo.getEndPageOfNextUnit();
	    }





	    @Override
	    public boolean isNotFirstPage()
	    {
	        return paginatedInfo.isNotFirstPage();
	    }





	    @Override
	    public boolean isNotLastPage()
	    {
	        return paginatedInfo.isNotLastPage();
	    }





	    @Override
	    public boolean isHasPrevUnit()
	    {
	        return paginatedInfo.isHasPrevUnit();
	    }





	    @Override
	    public boolean isHasNextUnit()
	    {
	        return paginatedInfo.isHasNextUnit();
	    }





	    // Override Object

	    @Override
	    public String toString()
	    {
	        return paginatedInfo.toString();
	    }





	    // Collection implementations

	    @Override
	    public int size()
	    {
	        return getItems().size();
	    }





	    @Override
	    public boolean isEmpty()
	    {
	        return getItems().isEmpty();
	    }





	    @Override
	    public boolean contains(Object o)
	    {
	        return getItems().contains(o);
	    }





	    @Override
	    public Iterator<TItem> iterator()
	    {
	        return getItems().iterator();
	    }





	    @Override
	    public Object[] toArray()
	    {
	        return getItems().toArray();
	    }





	    @Override
	    public <T> T[] toArray(T[] a)
	    {
	        return getItems().toArray(a);
	    }





	    @Override
	    public boolean add(TItem e)
	    {
	        throw new UnsupportedOperationException();
	    }





	    @Override
	    public boolean remove(Object o)
	    {
	        throw new UnsupportedOperationException();
	    }





	    @Override
	    public boolean containsAll(Collection<?> c)
	    {
	        return getItems().contains(c);
	    }





	    @Override
	    public boolean addAll(Collection<? extends TItem> c)
	    {
	        throw new UnsupportedOperationException();
	    }





	    @Override
	    public boolean removeAll(Collection<?> c)
	    {
	        throw new UnsupportedOperationException();
	    }





	    @Override
	    public boolean retainAll(Collection<?> c)
	    {
	        throw new UnsupportedOperationException();
	    }





	    @Override
	    public void clear()
	    {
	        throw new UnsupportedOperationException();
	    }

}
