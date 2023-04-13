CREATE DATABASE Ecomm_Prod_Srv;
CREATE DATABASE Ecomm_Stage_Srv;
CREATE DATABASE Ecomm_Test_Srv;
CREATE DATABASE Ecomm_Dev_Srv;

SHOW DATABASES; -- mysql to list out created databases
USE Ecomm_Dev_Srv; -- mysql to select Ecomm_Dev_Srv database

\list; -- or \l  psql command to list out created databases
\connect Ecomm_Dev_Srv; -- \c Ecomm_Dev_Srv; psql command to select Ecomm_Dev_Srv database

DROP DATABASE Ecomm_Prod_Srv;
DROP DATABASE Ecomm_Stage_Srv;
DROP DATABASE Ecomm_Test_Srv;
DROP DATABASE Ecomm_Dev_Srv;
