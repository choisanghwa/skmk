create table ordersFoods (
	ordercode varchar2(50) not null,
    orderCount varchar2(50) not null,
    foodCode varchar2(50) not null,
    shopCode varchar2(50) not null,
    constraint ORDERS_FOODS_ORDERS_CODE_FK foreign key(orderCode) references orders(orderCode),
	constraint ORDERS_FOODS_SHOP_CODE_FK foreign key(shopCode) references shop(shopCode),
    constraint ORDERS_FOODS_FOOD_CODE_FK foreign key(foodCode) references food(foodCode)
);