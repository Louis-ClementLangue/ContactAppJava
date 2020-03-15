# ContactAppJava

## Informations principales

Ce projet a été réalisé par Florentin Dehooghe et Louis-Clément Langue

Ce projet a été dévelopé sous intelij

Les dépendances sont intégrées par maven

Pour démarer le projet, utiliser la fonction main de la classe Main

## Connexion Base de donnés
La base de donné utilisé est la même que celle fourni par le sujet du projet, mais elle est aussi disponible dans le repository (person.sql)
Pour se connecter, nous avons utiliser un serveur virtuel (localhost) géré par phpMyAdmin, il suffit d'importer la table
La connexion se fait par la méthode getConnetion de la classe DataSourceFactory. 
Pour se connecter modifiez la ligne 10 sous ce format :
```{java}
Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:[N°de port]/[dataBaseName]", "[user]", "[password]");
```

## Fonctionnalités disponibles
L'affichage de tous les contacts dans un tableau avec à coté, le détail pour un contact sélectioné
L'ajout de contact
La modification de contact
La suppression de contact
L'export de tous les contacts en format v-card

La recherche de contact

## Test
Toute la partie qui gère la base de donné a été développé en test unitaires avec assertJ et Junits, la classe de test PersonDAOTest se trouve dans le package test 
