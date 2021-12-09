create database johngameSDAproject;
use johngameSDAp;



Create Table Grid_Table
(
  GridID nvarchar(20),
  ColNo int ,
  RowNo int,
  MaxColNo int,
  MaxRowNo int,
  Life BIT, -- 1 0r 0, mar gya ya zinda
  primary key(GridID,ColNo,RowNo), --

);
Drop procedure SaveState

go
Create procedure SaveState
@GridID nvarchar(20),
@ColNo int,
@RowNo int,
@MaxColNo int,
@MaxRowNo int,
@Life BIT
--@print
AS
BEGIN
  Insert into Grid_Table(GridId,RowNo,ColNo,MaxColNo,MaxRowNo,Life) values (@GridID,@RowNo,@ColNo,@MaxColNo,@MaxRowNo,@Life);
End;

--call SaveState('Wab',1,1,20,20,1);
exec SaveState @GridID = 'ibrahim', @ColNo = 1, @RowNo = 1, @MaxColNo = 20, @MaxRowNo = 20, @Life = 1;

select * from Grid_Table

go
 Create procedure ViewState
 As 
 Begin

 Select GridID from Grid_Table;

 end;
 
 exec ViewState;
select * from Grid_Table

 --Call ViewState;


 Create procedure LoadS
 (
 @GridId nvarchar(20)

 )
 As 
 Begin
 if exists( select Grid_Table.RowNo , Grid_Table.ColNo,Grid_Table.MaxColNo,Grid_Table.MaxRowNo,Grid_Table.Life from Grid_Table
         where Grid_Table.GridID = @GridId)

  begin
    
	( select Grid_Table.RowNo , Grid_Table.ColNo,Grid_Table.MaxColNo,Grid_Table.MaxRowNo,Grid_Table.Life from Grid_Table
         where Grid_Table.GridID = @GridId)
   end ;
	
end;
exec LoadS @GridID = 'Wab1f';
--Call LoadS( ' watoo9 ' );
  

  Create procedure DeleteState
  (
   @GridId nvarchar(20)
  )
  As 
  Begin 
  if exists (Select * from Grid_Table
              where Grid_Table.GridID = @GridId
			  )
	Begin
	 
	   delete from Grid_Table where Grid_Table.GridID = @GridId

	end;
end;
exec DeleteState @GridID = 'ibrahim';
select * from Grid_Table
--call DeleteState('wattoo9')
