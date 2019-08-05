create table guestBook (
	shopCode varchar2(50) not null primary key,
	guestBookImage varchar2(500),
	guestBookTitle varchar2(300) not null,
	guestBookContent varchar2(3000) not null,
    guestBookTime date not null,
	constraint GUEST_BOOK_SHOP_CODE_FK foreign key(shopCode) references shop(shopCode)
);