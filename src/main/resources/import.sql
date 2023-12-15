insert into tb_contatos (id, nome, email, fone)values(1, 'rafael', 'rafael@gmail.com', 11111111111);
insert into tb_contatos(id,nome,email,fone)values(3,'Maria','maria@gmail.com',489965432212);
insert into tb_contatos(id,nome,email,fone)values(2,'Gui','gui@gmail.com',489965432212);


insert into tb_local(id,nome,rua,numero,bairro,cidade,estado,cep)values(1,'casa','casarua',222,'casabairro','cidadecasa','sc',90909000);

insert into tb_compromissos(id,descricao, data, hora, contato_id, local_id)values(1, 'jogar','2023-12-11','15:00:00',1,1);
insert into tb_compromissos(id,descricao, data, hora, contato_id, local_id)values(2, 'pescar','2023-12-11','15:00:00',2,1);