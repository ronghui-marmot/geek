use marmotec;

DROP PROCEDURE batchinsert;
delimiter //
create procedure batchinsert(IN init INT, IN loop_time INT) 
begin
	declare var INT;
    declare id int;
    set var = 0;
    set id = init;
    while var < loop_time do
		insert into orders_base values(id,current_timestamp()+rand(10),1,"收货人","收货地址",1000,"1","20210617120000",123456789,25,"0",10,"发票抬头",current_timestamp(),current_timestamp());
		set id = id+1;
        set var = var+1;
	end while;
end//
delimiter ;
call batchinsert(1,1000000);
-- 1725.89 seconds
-- load data 17.969 seconds
/**
load data infile 'C:/software/mysql/mysql-5.7.34-winx64/data/order_base_batch_new.csv' into table orders_base
CHARACTER SET utf8mb4 -- 可选，避免中文乱码问题
FIELDS TERMINATED BY ',' -- 字段分隔符，每个字段(列)以什么字符分隔，默认是 \t
	OPTIONALLY ENCLOSED BY '' -- 文本限定符，每个字段被什么字符包围，默认是空字符
	ESCAPED BY '\\' -- 转义符，默认是 \
LINES TERMINATED BY '\n' -- 记录分隔符，如字段本身也含\n，那么应先去除，否则load data 会误将其视作另一行记录进行导入
-- (id, name, age, address, create_date) -- 每一行文本按顺序对应的表字段，建议不要省略
**/