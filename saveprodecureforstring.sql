create database dbsda;
use dbsda;
 


Create Table Grid_Table
(
 GridId varchar(20),
 Grid varchar(2000),
  primary key(GridID)
);


Delimiter $$
use dbsda $$

create procedure savegrid
(
IN grid_id varchar(20),
In grid_string varchar(2000)

)
begin 
insert into Grid_Table(GridId,Grid) values (grid_id, grid_string);
end $$

call savegrid(2,'lol|hujidueidiuewd|jnjkndkjed|jnjendjend')

select [grid_string] from [Your_Table_Name]

create procedure getgrid
(



)
