create table shop (
	shopCode varchar2(50) not null primary key,
	shopName varchar2(50) not null,
	shopAddress varchar2(50) not null,
	shopLogo varchar2(50) not null,
	shopLicense varchar2(50) not null,
	memberMail varchar2(50),
	constraint SHOP_MEMBER_EMAIL_FK foreign key(memberMail) references member(memberMail)
);