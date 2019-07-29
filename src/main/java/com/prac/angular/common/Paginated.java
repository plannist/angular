package com.prac.angular.common;

import java.util.List;

public interface Paginated<TItem> {
    
	/**
     *  토탈 카운트를 반환한다.
     */
	long getTotalCount();
	
    /**
     *  조회된 아이템 리스트를 반환한다.
     */
	List<TItem> getItems();
	
    /**
     *  아이템 리스트를 할당한다.
     */
	void setItems(List<TItem> list);
	
    /**
     *  페이지 사이즈를 반환한다.
     */
	int getPageSize();
	
    /**
     *  페이지 단위 사이즈를 반환한다.
     */
	int getPageUnitSize();
	
    /**
     *  현재 페이지를 반환한다.
     */
	int getCurrentPage();
	
    /**
     *  리스트 시작 번호를 반환한다.
     */
	long getNo();
	
    /**
     *  리스트 시작번호를 반환한다. 단 역방향으로 순번을 매긴다.
     */
	long getReversNo();
	
    /**
     *  첫번째 페이지를 반환한다.
     */
	int getFirstPage();
	
    /**
     *  마지막 페이지를 반환한다.
     */
	int getLastPage();
	
    /**
     *  페이지 단위의 시작페이지를 반환한다.
     */
	int getBeginPage();
	
    /**
     *  페이지 단위의 종료 페이지를 반환한다.
     */
	int getEndPage();
	
    /**
     *  이전 페이지 단위의 시작 페이지를 반환한다.
     */
	int getBeginPageOfPrevUnit();
	
    /**
     *  이전 페이지 단위의 종료 페이지를 반환한다.
     */
	int getEndPageOfPrevUnit();
	
	/**
     * 다음 페이지 단위의 시작 페이지를 반환한다.
     */
    int getBeginPageOfNextUnit();

    /**
     * 다음 페이지 단위의 종료 페이지를 반환한다.
     */
    int getEndPageOfNextUnit();

    /**
     * 첫 페이지 이동 가능 여부를 확인한다.
     */
    boolean isNotFirstPage();

    /**
     * 마지막 페이지 이동 가능 여부를 확인한다.
     */
    boolean isNotLastPage();

    /**
     * 이전 페이지 단위가 있는지 여부.
     */
    boolean isHasPrevUnit();

    /**
     * 다음 페이지 단위가 있는지 여부.
     */
    boolean isHasNextUnit();
	
	
}
