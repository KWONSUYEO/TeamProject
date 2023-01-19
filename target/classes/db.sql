create table member(
	m_id varchar2(10 char) primary key, -- id
	m_password varchar2(20 char) not null, -- pw
	m_nickname varchar2(10 char) not null, -- 닉네임
	m_category varchar2(15 char), -- 선호하는 카테고리
	m_email varchar2(30 char)
)
select * from member

drop table member

insert into MEMBER values('user_1', '1', 'nick_1', '한식', 'user1@gmail.com')

-- 맛집리스트(찜/방문 겸용)
create table restaurants(
	r_level varchar2(1 char) , -- 맛집유형(1:찜 / 2:방문) 
	r_restName varchar2(50 char) , -- 맛집이름
	r_m_id varchar2(10 char) , -- (회원)ID
	r_addr varchar2(100 char), -- 맛집주소
	r_tel varchar2(20 char), -- 전화번호
	r_category varchar2(15 char), -- 음식 종류(가게 분류)
	r_priceRange varchar2(10 char), -- 가격대
	r_parking varchar2(15 char), -- 주차
	r_openHours varchar2(20 char), -- 엽엉시간
	r_lastOrder varchar2(10 char), -- 마지막 주문
	r_holiday varchar2(5 char), -- 휴일
	constraint rest_PK primary key(r_level, r_restName, r_m_id)
)

insert into restaurants values ('1', '테스트맛집_1', 'user_1', 'addr_1', '02-111-1111',
								'한식', '2만원 미만', '주차공간없음', '08:30 - 20:00', '19:00', '일')

insert into restaurants values ('1', '테스트맛집_2', 'user_2', 'addr_2', '02-222-2222',
								'한식', '만원 미만', '유료주차 가능', '17:00 - 01:00', null, null)

select * from RESTAURANTS

delete from RESTAURANTS where r_level = '2' and r_restName = '테스트맛집_2' and r_m_id = 'user_2';

select * from restaurants where r_level = 1






create table member(
	m_id varchar2(10 char) primary key, -- id
	m_password varchar2(20 char) not null, -- pw
	m_nickname varchar2(10 char) not null, -- 닉네임
	m_location varchar2(30 char) not null -- 지역
)

select * from member

drop table member

insert into MEMBER values('ksy','1','kwon','경기도')

