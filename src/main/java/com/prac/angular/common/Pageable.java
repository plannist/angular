package com.prac.angular.common;

public interface Pageable {
	/**
	 * 기본 페이지 사이즈.
	 * */
	int DEFAULT_SIZE = 10;
	
	/**
	 * 기본 페이지 단위 사이즈.
	 * */
	int DEFAULT_UNIT_SIZE = 10;
	
    /**
     * 페이지 인덱스를 반환한다. 0 부터 시작한다.
     */
	int getPage();
	
    /**
     * 페이지 사이즈를 반환한다. (기본값 {@value #DEFAULT_SIZE})
     */
	int getSize();
	
    /**
     * 페이지 단위 사이즈를 반환한다. (기본값 {@value #DEFAULT_UNIT_SIZE})
     */
	int getUnitSize();
	
    /**
     *  페이지 오프셋 값을 반환한다.
     */
	int getOffset();
	
    /**
     *  정렬 파라메터를 반환한다.
     */
	Sort getSort();
}
