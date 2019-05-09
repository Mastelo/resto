/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     8/5/2019 20:33:45                            */
/*==============================================================*/


drop table if exists MESERO;

drop table if exists PEDIDO;

drop table if exists PRODUCTO;

drop table if exists PRODUCTO_PEDIDO;

drop table if exists TAMANO;

/*==============================================================*/
/* Table: MESERO                                                */
/*==============================================================*/
create table MESERO
(
   IDMESERO             int not null,
   NOMBRES              char(15),
   APELLIDOS            char(20),
   FECHANACIMIENTO      date,
   DIRECCION            char(35),
   TELEFONO             int,
   primary key (IDMESERO)
);

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO
(
   IDPEDIDO             int not null,
   IDMESERO             int,
   TOTAL                float(10),
   primary key (IDPEDIDO)
);

/*==============================================================*/
/* Table: PRODUCTO                                              */
/*==============================================================*/
create table PRODUCTO
(
   IDPRODUCTO           int not null,
   NOMBRE               char(20),
   PRECIO               float(10),
   DESCRIPCION          char(50),
   IMAGEN               longblob,
   primary key (IDPRODUCTO)
);

/*==============================================================*/
/* Table: PRODUCTO_PEDIDO                                       */
/*==============================================================*/
create table PRODUCTO_PEDIDO
(
   IDPEDIDO             int,
   IDPRODUCTO           int,
   CANTIDAD             int,
   SUBTOTAL             float(10)
);

/*==============================================================*/
/* Table: TAMANO                                                */
/*==============================================================*/
create table TAMANO
(
   IDTAMANO             int not null,
   IDPRODUCTO           int,
   TAMANO               char(8),
   primary key (IDTAMANO)
);

alter table PEDIDO add constraint FK_RELATIONSHIP_1 foreign key (IDMESERO)
      references MESERO (IDMESERO) on delete restrict on update restrict;

alter table PRODUCTO_PEDIDO add constraint FK_RELATIONSHIP_2 foreign key (IDPEDIDO)
      references PEDIDO (IDPEDIDO) on delete restrict on update restrict;

alter table PRODUCTO_PEDIDO add constraint FK_RELATIONSHIP_3 foreign key (IDPRODUCTO)
      references PRODUCTO (IDPRODUCTO) on delete restrict on update restrict;

alter table TAMANO add constraint FK_RELATIONSHIP_4 foreign key (IDPRODUCTO)
      references PRODUCTO (IDPRODUCTO) on delete restrict on update restrict;

