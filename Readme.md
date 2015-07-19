##Entrée
fichier de style :<br />

    5 5
    1 2 N
    GAGAGAGAA
    3 3 E
    AADAADADDA

##Sortie

    1 3 N
    5 1 E

##Récupération et lancement de l'application

    git clone https://github.com/mathieuherbert/tondeuse.git
    cd tondeuse
    mvn install
    cd target
    java -jar fr.application-0.0.1-SNAPSHOT-jar-with-dependencies.jar ..\src\test\resources\fichiersTest\deuxTondeuses

##Logging
Le système de logging utilisé est Logback. Par défaut c'est la sortie console qui est utilisée.

##Structure
l'application est découpée avec les packages suivants :

 - tondeuse.fr.application: contient la classe de lancement
 - tondeuse.fr.application.exceptions : les différentes exceptions que peut générer l'application
 - tondeuse.fr.application.fichiers : la gestion des fichiers
 - tondeuse.fr.application.intelligence : toute l'intelligence fonctionnelle de du passage des tondeuses
 - tondeuse.fr.application.model : le modèle de l'application
 - tondeuse.fr.application.utils : des classes utilitaires de l'application (exemple : la sortie console)