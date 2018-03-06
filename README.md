# Projet Architecture Logiciel

Badge travis :

[![Build Status](https://travis-ci.org/thomastmts/gilded-rose.svg?branch=master)](https://travis-ci.org/thomastmts/gilded-rose)

Badge Coverage :

[![Coverage Status](https://coveralls.io/repos/github/thomastmts/gilded-rose/badge.svg?branch=master&service=github)](https://coveralls.io/github/thomastmts/gilded-rose?branch=master)

[![Coverage Status](https://coveralls.io/repos/github/thomastmts/gilded-rose/badge.svg?branch=master)](https://coveralls.io/github/thomastmts/gilded-rose?branch=master)


Groupe composé de :

+ PELTIER Floriane, 
+ HUANG Thomas, 
+ MOHAMED Sanyat, 
+ LEREMON Jordy, 
+ GUEYE Sokhna Diarra.

Notre application Spring est composée de plusieurs fonctions :

+ L'initialisation avec des Items prédéfinis dans le code ainsi que l'affichage de la liste de tous les Items de la base de données sous forme de JSON. Pour profiter de cette fonction, il suffit de Run l'application puis de se rendre à l'adresse [http://localhost:8080/](http://localhost:8080/).
+ La création d'un nouvel Item via l'URL. Par exemple, si vous voulez créer un Item qui s'appelle "bonbon", qui a une qualité de 31 et dont la date de péremption est dans 12 jours, il suffit de taper l'URL suivant : [http://localhost:8080/create_item?name=bonbon&quality=31&sellIn=12](http://localhost:8080/create_item?name=bonbon&quality=31&sellIn=12).
+ L'affichage d'un Item précis grâce à son ID. En précisant l'ID de l'Item qui vous intéresse dans l'URL, vous aurez accès aux informations de cet Item. Exemple : [http://localhost:8080/show_item?id=2](http://localhost:8080/show_item?id=2). Bien entendu, si vous précisez un ID qui ne fait pas partie de la base de données, vous aurez un message d'erreur.

Les attributs sellIn et quality sont mis à jour toutes les 15 minutes.

Pour une raison qui nous échappe, Coveralls ne se met plus à jour depuis quelques temps et reste aux 70% que nous avions obtenus à un commit du 5 mars vers 22h... Mais nous avons bel et bien essayé d'implémenter les tests de toutes les fonctions de l'application.
