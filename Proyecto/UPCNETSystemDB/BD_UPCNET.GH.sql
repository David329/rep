use master
go

IF DB_ID('IntranetUPC') IS NOT NULL DROP DATABASE IntranetUPC;

CREATE DATABASE IntranetUPC
go
use IntranetUPC
go

create table Administrador(IDAdministrador varchar(30)not null,Pass varchar(30),Nombre varchar(30),Apellido varchar(30),Correo varchar(30))
create table Apoderado(IDApoderado varchar(30)not null,Pass varchar(30),Nombre varchar(30),Apellido varchar(30),DNI int,Edad int,Correo varchar(30),Direccion varchar(30),Condicion varchar(30));
create table Categoria(IDCategoria varchar(30)not null ,Monto decimal(18,2));--definido x el sistema
create table Alumno(IDAlumno varchar(30) not null,Pass varchar(30),Nombre varchar(30),Apellido varchar(30),DNI int,Edad int,Correo varchar(30),Direccion varchar(30),IDCategoria varchar(30),IDApoderado varchar(30))
create table Ciclo(IDCiclo varchar(30) not null,IDAlumno varchar(30) not null,Boleta1 bit,Boleta2 bit,Boleta3 bit)
create table Incidencia(IDIncidencia varchar(30) not null,Asunto varchar(100),IDAlumno varchar(30),IDProfesor varchar(30))--allow nulls
create table Recurso(IDRecurso varchar(30)not null,NombreRecurso varchar(30),FechaPedido date,CantidadHoras int,Reservado bit,IDAlumno varchar(30),IDProfesor varchar(30))--allow nulls
create table Profesor(IDProfesor varchar(30)not null,Pass varchar(30),Nombre varchar(30),Apellido varchar(30),DNI int,Edad int,Correo varchar(30),Direccion varchar(30),Sueldo decimal(18,2))
create table Curso(IDCurso varchar(30) not null,Nombre varchar(30), CicloDeCurso int,MaxInasistencia int,IDProfesor varchar(30))
create table Curso_Alumno(IDAlumno varchar(30) not null,IDCurso varchar(30) not null,PC1 decimal(10,2),PC2 decimal(10,2),EP decimal(10,2),EF decimal(10,2),Retirado bit,Inasistencias int,Delegado bit)
create table Curso_Clase(IDClase varchar(30)not null,IDCurso varchar(30)not null,Dia varchar(30),HoraIni varchar(10),HoraFin varchar(10))
create table Documento(IDDocumento varchar(30) not null,IDCurso varchar(30)not null,NomDocumento varchar(30),Documento varbinary(MAX))

alter table Administrador add constraint PK_Administrador primary key(IDAdministrador)
alter table Apoderado add constraint PK_Apoderado primary key(IDApoderado)
alter table Categoria add constraint PK_Categoria primary key(IDCategoria)
alter table Alumno add constraint PK_Alumno primary key(IDAlumno)
alter table Ciclo add constraint PK_Ciclo primary key(IDCiclo,IDAlumno)
alter table Incidencia add constraint PK_Incidencia primary key(IDIncidencia)
alter table Recurso add constraint PK_Recurso primary key(IDRecurso)
alter table Profesor add constraint PK_Profesor primary key(IDProfesor)
alter table Curso add constraint PK_Curso primary key(IDCurso)
alter table Curso_Alumno add constraint PK_Curso_Alumno primary key(IDAlumno,IDCurso)
alter table Curso_Clase add constraint PK_SecClase primary key(IDClase,IDCurso)
alter table Documento add constraint PK_Documento primary key(IDDocumento,IDCurso)

---FKs
alter table Alumno add constraint FK_Alumno_Categoria  foreign key(IDCategoria) references Categoria(IDCategoria)
alter table Alumno add constraint FK_Alumno_Apoderado foreign key(IDApoderado)references Apoderado(IDApoderado)

alter table Ciclo add constraint FK_Ciclo_Alumno foreign key(IDAlumno) references Alumno(IDAlumno)

alter table Incidencia add constraint FK_Incidencia_Alumno foreign key(IDAlumno) references Alumno(IDAlumno)
alter table Incidencia add constraint FK_Incidencia_Profesor foreign key(IDProfesor) references Profesor(IDProfesor)

alter table Curso add constraint FK_Curso_Profesor foreign key(IDProfesor)references Profesor(IDPRofesor)

alter table Recurso add constraint FK_Recurso_Alumno foreign key(IDAlumno) references Alumno(IDAlumno)
alter table Recurso add constraint FK_Recurso_Profesor foreign key(IDProfesor) references Profesor(IDProfesor)

alter table Curso_Alumno add constraint FK_Seccion_Curso_Alumno1 foreign key(IDAlumno) references Alumno(IDAlumno)
alter table Curso_Alumno add constraint FK_Seccion_Curso_Alumno2 foreign key(IDCurso) references Curso(IDCurso)

alter table Curso_Clase add constraint FK_Curso_Clase foreign key(IDCurso)references Curso(IDCurso)

alter table Documento add constraint FK_Documento_Curso foreign key(IDCurso) references Curso(IDCurso)

IF NOT EXISTS 
    (SELECT name FROM master.sys.server_principals WHERE name = 'AdminEvolucion')
BEGIN
    CREATE LOGIN [AdminEvolucion] WITH PASSWORD=N'12345', DEFAULT_DATABASE=[IntranetUPC], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
    EXEC master..sp_addsrvrolemember @loginame = N'AdminEvolucion', @rolename = N'sysadmin'
END

-------------DATOS DE PRUEBA--------------
insert into Administrador values('AD101','ad101ad','David','Silva','davidsilva3290@gmail.com')
insert into Administrador values('a','a','Ian','Maquinia','ian_forever@gmail.com')

insert into Categoria values('Q',2300.70)
insert into Categoria values('R',1800.60)
insert into Categoria values('S',1500.50)
insert into Categoria values('U',800.00)

insert into Apoderado values('AP101','ap101ap','Julian','Kaori',92921311,33,'julian@gmail.com','Carlos leon Delgado 140','Padre')
insert into Apoderado values('AP102','ap102ap','Ernesto','Silva',92343311,50,'ernesto@gmail.com','Usares de Junin 220','Tio')
insert into Apoderado values('AP103','ap103ap','Luis','Veliz',12344411,34,'luis@hotmail.com','las trincheras 143','Abuelo')
insert into Apoderado values('AP104','ap104ap','Vincenzo','Espartano',2221311,33,'vint@gmail.com','Gamarra 222, La victoria','Padre')
insert into Apoderado values('AP105','ap105ap','Madeleine','Osterling',44421311,80,'rick@yahoo.com','Las piedritas 352','Madre')


insert into Alumno values('AL101','al101al','Alex','Espino',828216,50,'ianelzukulemtho@gmail.com','Las orquideas140','Q','AP101')
insert into Alumno values('AL102','al102al','Victor','Parassi',777621,22,'JuanPablo@gmail.com','School Street Grayslake 5563','Q','AP102')
insert into Alumno values('AL103','al103al','Ale','Mendoza',2342162,23,'AleM@Ez.com','Avenue Bayonne 544','R','AP103')
insert into Alumno values('AL104','al104al','Maricarmen','Peralta',31622,12,'MariP@Ez.com','Lincoln Street 8522','S','AP104')
insert into Alumno values('AL105','al105al','Carolina','Herrera',456622,18,'CarolinaH@yahoo.com','Lincoln Street 1403','U','AP105')


insert into Profesor values('P0001','1234','Victor', 'De la Cruz', 99999999,20,'ianfollower@gmail.com','Av. Evergreen 123',1500)
insert into Profesor values('P0002','1234','Vincenzo', 'Delacrois', 99999998,20,'ianfollower2@gmail.com','Av. Evergreen 123',1500)
insert into Profesor values('P0003','1234','Gregorio', 'Ian', 91239938,20,'wowforever@gmail.com','Av. Neverever 123',3500)
insert into Profesor values('P0004','1234','Richi', 'Kina', 99999938,20,'foreverian@gmail.com','Av. Always Yours 123',3000)
insert into Profesor values('P0005','1234','David', 'Brancacho', 99999123,20,'foreverian@gmail.com','Av. Always Yours 1231',3000)

insert into Curso values('curso','nombre',1,10,'P0001')