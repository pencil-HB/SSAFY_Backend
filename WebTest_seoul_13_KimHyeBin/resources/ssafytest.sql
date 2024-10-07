create database if not exists `ssafytest`;
use `ssafytest`;

drop table if exists`tmembers`;

create table `tmembers`(
    `mid` varchar(45) primary key,		# 사용자 아이디
    `mpass` varchar(45) not null,		# 사용자 비밀번호
    `mname` varchar(45) not null		# 사용자 이름
);


insert into `tmembers` (mid, mpass, mname) values('ssafy','1234','싸피인'),('admin','5678','관리자');

drop table if exists`tproducts`;
create table `tproducts`(
    `pcode` varchar(45) primary key,		# 제품 코드
    `pname` varchar(45) not null,		# 제품 이름
    `pquantity` int not null,			# 제품 수량
    `pcategory` varchar(45) not null	# 제품 분류
);
insert into `tproducts` (pcode, pname, pquantity, pcategory) values('book1', '자바책', 10, 'book'),
('book2','DB책', 4, 'book'), ('keyboard1','ssafy키보드',2,'keyboard'), ('mouse1','ssafy마우스',2,'mouse');
commit;
select * from tproducts;
