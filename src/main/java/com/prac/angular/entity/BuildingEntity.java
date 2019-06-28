package com.prac.angular.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name="BUILDING")
@Getter
@Setter
@NamedQuery(name="Building.findJoinPrice",
			query="select distinct build from BuildingEntity build join fetch build.price where build.buildNo = 1")
public class BuildingEntity {
	
	@Id
	@GeneratedValue
	@Column(name="BUILD_NO", unique=true, nullable=false)
	private Long buildNo;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="BUILDTYPE")
	private int buildType;
	
	@Column(name="PROTYPE")
	private String proType;
	
	@Column(name="WHOLEFLOOR")
	private int wholeFloor;
	
	@Column(name="FLOOR")
	private int floor;
	
	@Column(name="JAREA")
	private double jArea;
	
	@Column(name="GAREA")
	private double gArea;
	
	@Column(name="VIEW_COUNT")
	private int viewCount;
	
	@Column(name="PICPATH")
	private String picPath;
	
	@Column(name="RESERVATION_TIME")
	private String reservationTime;
	
	@Column(name="LAT")
	private double lat;
	
	@Column(name="LNG")
	private double lng;
	
	@Column(name="ROOMTITLE")
	private String roomTitle;
	
	@Column(name="EXPLAINTEXT")
	private String explainExt;
	
	@Column(name="PRIVATEMEMO")
	private String privateMemo;
	
	@Column(name="BUILDSTATE")
	private int buildState;
	
	@Column(name="BU_RDATE")
	private Timestamp buRdate;
	
	@Column(name="ST_NO")
	private Long stNo;
	
	@Column(name="ESTATE_NO")
	private Long estateNo;
	
	@Column(name="MEM_NO", nullable = true)
	private Long memNo;
	
	/**
	*	1. 실제 테이블에는 해당 컬럼이 존재 하지 않는다.
	*	2. oneToMany란 building 1 row 당 price 여러개를 갖을 수 있다.
	*	3. 2번 설명 처럼 여러개의 price를 갖을 수 있으므로 변수의 타입은 Collection으로 한다.
	*	4. price 테이블에는 foreign key 로 build_no 가 존재한다.
	*	5. price의 BUILD_NO 컬럼명 멤버변수명을 mappedBy = '이곳에 적는다.'
	*/
	@OneToMany(mappedBy="building", fetch = FetchType.LAZY)
	private List<PriceEntity> price;
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
