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