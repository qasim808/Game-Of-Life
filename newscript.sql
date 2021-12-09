create database johngameSDAproject;
use johngameSDAproject;



Create Table Grid_Table
(
  GridID nvarchar(20),
  ColNo int ,
  RowNo int,
  MaxColNo int,
  MaxRowNo int,
  Life BIT,
  primary key(GridID,ColNo,RowNo)
);


DELIMITER $$
use johngameSDAproject $$
Create procedure SaveS
(

IN GridID varchar(20),
IN ColNo int,
IN RowNo int,
IN MaxColNo int,
IN MaxRowNo int,
IN Life BIT

)
BEGIN
  Insert into Grid_Table(GridId,RowNo,ColNo,MaxColNo,MaxRowNo,Life) values (GridID,RowNo,ColNo,MaxColNo,MaxRowNo,Life);
End $$


call SaveS('ibbiq',1,1,20,20,1);
call SaveS('wattoo',10,10,30,30,0);
select * from Grid_Table

DELIMITER $$
use johngameSDAproject $$
 Create procedure ViewState
()
 Begin

 Select GridID from Grid_Table;

 end;
 
 call ViewState;
select * from Grid_Table

DELIMITER $$
use johngameSDAproject $$

 Create procedure LoadS
 (
 In GridId varchar(20)

 )
 Begin
 if exists(select Grid_Table.RowNo , Grid_Table.ColNo,Grid_Table.MaxColNo,Grid_Table.MaxRowNo,Grid_Table.Life from Grid_Table
         where Grid_Table.GridID = GridId)

  then
    
	select Grid_Table.RowNo , Grid_Table.ColNo,Grid_Table.MaxColNo,Grid_Table.MaxRowNo,Grid_Table.Life 
      from Grid_Table
         where Grid_Table.GridID = GridId;
   end if ;
	
end;
call LoadS('ibbiq');
Call LoadS('watoo9');
Call LoadS('wato9'); 


DELIMITER $$
use johngameSDAproject $$

  Create procedure DeleteS
  (
   IN GridId varchar(20)
  )
  Begin 
  if exists (Select * from Grid_Table
              where Grid_Table.GridID = GridId
			  )
   then 
	 
	   delete from Grid_Table where Grid_Table.GridID = GridId;

	end if ;
end;

select * from Grid_Table
call DeleteS('ibbiq')
