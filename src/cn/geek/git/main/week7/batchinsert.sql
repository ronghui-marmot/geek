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
--- 1210seconds