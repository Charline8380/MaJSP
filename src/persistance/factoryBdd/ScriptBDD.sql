-- Database: majsp

-- DROP DATABASE majsp;

/**
CREATE DATABASE majsp
    WITH 
    OWNER = abuwe
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
**/
   


DROP table achatproduit ;
DROP table achat ;
DROP table utilisateur;
DROP table produit ;



create table utilisateur (
id_utilisateur serial,
nom varchar,
prenom varchar,
adresse varchar,
email varchar,
mot_de_passe varchar,
primary key (id_utilisateur));


create table produit (
id_produit serial,
designation varchar not null,
categorie varchar,
prix float4 not null,
description varchar,
lien_image varchar,
primary key (id_produit));


create table achat (
id_achat serial,
num_achat integer not null,
id_utilisateur integer not null,
designtiaon_achat varchar not null,
date_achat date,
montant float4,
primary key (id_achat));
alter table achat add constraint FK_achat_id_utilisateur foreign key (id_utilisateur) references utilisateur (id_utilisateur);

create table achatproduit (
id_achatproduit serial,
id_produit integer not null,
id_achat integer not null,
quantite integer not null,
primary key (id_achatproduit, id_achat, id_produit));
ALTER TABLE achatproduit ADD CONSTRAINT achatproduit_fk FOREIGN KEY (id_produit) REFERENCES produit(id_produit);
ALTER TABLE achatproduit ADD CONSTRAINT achatproduit_fk_1 FOREIGN KEY (id_achat) REFERENCES achat(id_achat);




/** CREATION DU JEU DE DONNEES POUR TEST**/
--lancer les INSERT achat apres creation de deux utilisateurs au moins

--utilisateur
--les users seront créer en base à leur première connection

--produit
INSERT INTO produit (designation, categorie, prix, description, lien_image) VALUES( 'Blanchard', 'Categorie 1', 65.00, 'Chat blanc de race pure', 'img/chat1.jpeg');
INSERT INTO produit (designation, categorie, prix, description, lien_image) VALUES( 'Minou', 'Categorie 1', 55.00, 'Chat tigre jaune et blanc de race pure', 'img/chat2.jpeg');
INSERT INTO produit (designation, categorie, prix, description, lien_image) VALUES( 'Remus', 'Categorie 1', 23.00, 'Chat tigre  marron et blanc de race pure', 'img/chat3.jpg');
INSERT INTO produit (designation, categorie, prix, description, lien_image) VALUES('Croquette', 'Categorie 2', 15.99, 'Croquettes Friskies boeuf, poulet & légumes, 7,5kg', 'img/croquette.jpg');
INSERT INTO produit (designation, categorie, prix, description, lien_image) VALUES('Arbre à Chat', 'Categorie 3', 169.99, 'Arbre à chat multi niveau, 92 x 50 x 164', 'img/arbre.jpg');
INSERT INTO produit (designation, categorie, prix, description, lien_image) VALUES( 'Pack Jouet pour Chat', 'Categorie 3', 15.99, 'Assortiments De Jouets pour Chat,Pack de 21 Jouets', 'img/jouetChat.png');
commit;

--achat 
INSERT INTO achat (num_achat, id_utilisateur, designtiaon_achat, date_achat, montant) VALUES(01, 1, 'PAN01', '11/04/2020', 55.00);
INSERT INTO achat (num_achat, id_utilisateur, designtiaon_achat, date_achat, montant) VALUES(02, 2, 'PAN02', '02/05/2020', 130.00);
INSERT INTO achat (num_achat, id_utilisateur, designtiaon_achat, date_achat, montant) VALUES(03, 1, 'PAN03', '05/05/2020', 201.97);
commit;


--achatproduit
INSERT INTO public.achatproduit (id_produit, id_achat, quantite) VALUES(2, 1, 1);
INSERT INTO public.achatproduit (id_produit, id_achat, quantite) VALUES(1, 2, 2);
INSERT INTO public.achatproduit (id_produit, id_achat, quantite) VALUES(5, 3, 1);
INSERT INTO public.achatproduit (id_produit, id_achat, quantite) VALUES(4, 3, 2);
commit;




