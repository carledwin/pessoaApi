drop table tb_pessoa if exists;
create table tb_pessoa (id bigint generated by default as identity, 
						cpf bigint, 
						nome varchar(255), 
						sobrenome varchar(255), 
						primary key (id)
						);