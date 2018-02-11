/* Fahem Rabhi et Marais Bastien groupe C */

drop table produit;
drop table client;
drop table ligne_com;
drop table Commande;



create table PRODUIT (
nomP varchar(30) primary key,
descP varchar(50) not null,
prix number not null);

create table CLIENT (
nom varchar(20) not null,
prenom varchar(20) not null,
email varchar(60) primary key,
mdp varchar(20) not null,
adresse varchar(60) not null,
ville varchar(20) not null,
cp number not null);

create table COMMANDE (
idCom number primary key,
email varchar(60) references CLIENT(email),
montant float not null);

create table LIGNE_COM(
idCom number references COMMANDE(idCom),
nomP varchar(20) references PRODUIT(nomP),
qte number not null,
primary key(idCom,nomP)
);

