-- drop procedure  if exists pro1; 
-- delimiter $
-- create procedure pro1()
-- begin
-- select "Hello World" ;
-- end $
-- delimiter ;

-- drop procedure  if exists pro1; 
-- delimiter $
-- create procedure pro1()
-- begin
-- select "Hello World" ;
-- end $
-- delimiter ;

drop procedure if exists getcnt;
delimiter $
CREATE PROCEDURE getcnt (in p_input  int, out p_output  int ) 
BEGIN
   set p_output := p_input + 1;
END $
delimiter ;
