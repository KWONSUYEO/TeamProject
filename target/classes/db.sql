create table member(
	m_id varchar2(10 char) primary key, -- id
	m_password varchar2(20 char) not null, -- pw
	m_nickname varchar2(10 char) not null, -- 닉네임
	m_category varchar2(15 char), -- 선호하는 카테고리
	m_email varchar2(30 char)
)
select * from member

drop table member

insert into MEMBER values()

-- 맛집리스트(찜/방문 겸용)
create table restaurants(
	r_level varchar2(1 char) primary key, -- 맛집유형(1:찜 / 2:방문) 
	r_restName varchar2(50 char) primary key, -- 맛집이름
	r_m_id varchar2(10 char) primary key, -- (회원)ID
	r_addr varchar2(100 char), -- 맛집주소
	r_tel varchar2(20 char), -- 전화번호
	r_category varchar2(15 char), -- 음식 종류(가게 분류)
	r_priceRange varchar2(10 char), -- 가격대
	r_parking varchar2(15 char), -- 주차
	r_openHours varchar2(20 char), -- 엽엉시간
	r_lastOrder varchar2(10 char), -- 마지막 주문
	r_holiday varchar2(5 char) -- 휴일
)





