DROP  SCHEMA IF EXISTS projet-personnel;
CREATE SCHEMA projet-personnel;

CREATE TABLE projet-personnel.recette (
  `id_recette` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `Text` LONGTEXT NOT NULL,
  `Ingredients` MEDIUMTEXT NOT NULL,
  `Difficulte` VARCHAR(50),
  `image` VARCHAR(50),
  `Type` VARCHAR(50),
  `deleted` BIT(1),
  PRIMARY KEY (`id_recette`));

CREATE TABLE projet-personnel.profil (
  `id_profil` INT NOT NULL AUTO_INCREMENT,
  `Prenom` VARCHAR(45) NOT NULL,
  `Nom` VARCHAR(45) NOT NULL,
  `Age` INT(11) NOT NULL,
  `Ecole` VARCHAR(45) NOT NULL,
  `Pseudo` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id_profil`));

INSERT INTO `recette`(`id_recette`,`Nom`,`Text`,`Ingredients`,`Difficulte`,`image`,`Type`,`deleted`) VALUES (1,'croque monsieur','Etape 1
        Beurrez les 8 tranches de pain de mie sur une seule face. Posez 1 tranche de fromage sur chaque tranche de pain de mie. Posez 1 tranche de jambon plié en deux sur 4 tranches de pain de mie. Recouvrez avec les autres tartines (face non beurrée au dessus).</li>
        Etape 2:Dans un bol mélanger le fromage râpé avec le lait, le sel, le poivre et la muscade.
        Etape 3:Répartissez le mélange sur les croque-monsieur.
        Etape 4:Placez sur une plaque au four sous le grill pendant 10 mn.','Ingrédients : 8 tranches de pain de mie complet ,1 carotte ,1 petit oignon, 100 g de cheddar, 1 blanc de poulet effiloché,  10 cl de crème, Sel & Poivre','Facile',NULL,'Entrée',0);

INSERT INTO `recette`(`id_recette`,`Nom`,`Text`,`Ingredients`,`Difficulte`,`image`,`Type`,`deleted`) VALUES (2,'Wrap au poulet','Étape 1
          Coupez la tomate en fines tranches. Épépinez-les et faites-les dégorger en les plaçant dans une passoire et en les recouvrant de sel.
        Étape 2:Faites cuire les filets de poulet à la poêle avec lhuile dolive. Lorsquils sont cuits, coupez-les en fines lamelles.
        Étape 3:Tartinez les tortillas de moutarde ou de mayonnaise selon vos goûts. Disposez ensuite la laitue, les morceaux de poulet et les rondelles de tomate dégorgées que vous aurez pris soin de bien rincer. Salez et poivrez à votre convenance. Enroulez ensuite fermement et placez le tout au réfrigérateur dans du film alimentaire pour garder le wrap bien compact.
        Étape 4:Lorsque vos wraps sont bien frais, coupez-les en 2 en diagonal. Dégustez bien frais.','2 grands wraps ou 4 petits (galettes ou tortillas de blé), 1 filet de poulet ,1 carotte, 1/2 concombre, 4 feuilles de salade, Gruyère râpé, 100 g de fromage blanc, 1 c. à café de curry, Sel, poivre','Facile',NULL,'Plat',0);

INSERT INTO `recette`(`id_recette`,`Nom`,`Text`,`Ingredients`,`Difficulte`,`image`,`Type`,`deleted`) VALUES (3,'Feullete','Dérouler la pâte feuilleté et la couper en lanières (5cm de largeur environ)
      Découper le jambon sec de la même façon
      Sur chaque lanière déposer du jambon sec et parsemer de comté râpé puis torsader le tout. Répéter lopération pour lensemble de la pâte et badigeonner les torsades de jaune doeuf
      Cuisson : 10 minutes a 180 degré','1 rouleau de pâte feuilleté, 3-4 tranches de jambon sec, Comté râpé, 1 jaune doeuf','Facile',NULL,'Entrée',0);

INSERT INTO `projet-personnel`.`profil` (`id_profil`, `Prenom`, `Nom`, `Age`, `Ecole`, `Pseudo`) VALUES ('4', 'Jean', 'François', '17', 'HEI', 'JF');

INSERT INTO `projet-personnel`.`profil` (`id_profil`, `Prenom`, `Nom`, `Age`, `Ecole`, `Pseudo`) VALUES ('4', 'Henri', 'Delesquin', '20', 'ASSAS', 'HDE');

INSERT INTO `projet-personnel`.`profil` (`id_profil`, `Prenom`, `Nom`, `Age`, `Ecole`, `Pseudo`) VALUES ('4', 'Jon', 'Snow', '25', 'GOT', 'JS');