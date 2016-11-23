create table estacionamiento(id integer primary key aouto_increment, tiempo timestamp);

create table cliente(id integer primary key auto_increment, id_estacionamiento integer, pago float, foreign key(id-estacionamiento) references estacionamiento(id));
