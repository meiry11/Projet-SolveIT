
INSERT INTO utilisateur (id, email, password, nom, prenom, sex, derniereConnectionDate, derniereConnectionHeure, dateDeNaissance, adresse, codePostal, telephone) VALUES (1,'df@aol.com','df','Fargis','Denis',0,NULL,NULL,'1975-09-19',NULL,78140,NULL);
INSERT INTO utilisateur (id, email, password, nom, prenom, sex, derniereConnectionDate, derniereConnectionHeure, dateDeNaissance, adresse, codePostal, telephone) VALUES (2,'dj@aol.com','dj','Fanael','Julie',1,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO utilisateur (id, email, password, nom, prenom, sex, derniereConnectionDate, derniereConnectionHeure, dateDeNaissance, adresse, codePostal, telephone) VALUES (3,'ip@aol.com','ip','Iaris','Paul',0,NULL,NULL,NULL,NULL,NULL,NULL);

INSERT INTO compte (id, libelle, solde, decouvert, taux, utilisateurId) VALUES (12,'Compte Courant',25000.00,NULL,NULL,1);
INSERT INTO compte (id, libelle, solde, decouvert, taux, utilisateurId) VALUES (13,'Compte Courant',150000.00,100.00,NULL,2);
INSERT INTO compte (id, libelle, solde, decouvert, taux, utilisateurId) VALUES (14,'Compte Courant',35000.00,50.00,NULL,3);
INSERT INTO compte (id, libelle, solde, decouvert, taux, utilisateurId) VALUES (15,'Livret A',99500.00,NULL,0.10,1);
INSERT INTO compte (id, libelle, solde, decouvert, taux, utilisateurId) VALUES (16,'Compte Remunéré',50000.00,NULL,0.30,2);

INSERT INTO operation (id, libelle, montant, `dateOp`, heureOp, compteId) VALUES (1,'Virement',500,'2014-12-31', '23:00:00',15);
INSERT INTO operation (id, libelle, montant, `dateOp`, heureOp, compteId) VALUES (2,'Retrait',-500,'2014-12-31', '23:00:00',12);
INSERT INTO operation (id, libelle, montant, `dateOp`, heureOp, compteId) VALUES (3,'Transaction avec le comte 12',-50,'2015-02-13', '13:10:52',15);
INSERT INTO operation (id, libelle, montant, `dateOp`, heureOp, compteId) VALUES (4,'Transaction avec le comte 15',50,'2015-02-13', '13:10:52',12);