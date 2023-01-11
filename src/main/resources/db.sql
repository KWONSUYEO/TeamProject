create table member(
	m_id varchar2(10 char) primary key, -- id
	m_password varchar2(20 char) not null, -- pw
	m_nickname varchar2(10 char) not null, -- 닉네임
	m_location varchar2(30 char) not null -- 지역
)

select * from member

drop table member

insert into MEMBER values('ksy','1','kwon','경기도')