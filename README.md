# Framework-BAUDVIN-CASSAGNES-LAVILLE

Ce projet est un framework de gestion de logs en Java.
Affichage dans la console, lecture/écriture des logs dans un ou plusieurs fichiers créés automatiquement si vous activez l'option.

Il y a 3 niveaux de logs :

  - Debug
  - Info
  - Error

**Installation :** 
  
  Télécharger le projet GitHub pour le code source du projet.
  
  Pour l'installation, rendez-vous sur http://uploaded.net/file/e37p0rgx pour télécharger la JAR correspondante.
  
  Dans Eclipse, importer la JAR que vous venez de télécharger en faisant un clic droit sur votre projet -> Build-Path -> Add External Archives puis en choisissant le bon fichier (LogsFramework.jar).
  
  
**Utilisation :**

  Créez un objet Logger logger = LoggerFactory.getLogger(name_of_class.class);
  
  Ensuite appelez le logger comme suit en fonction du niveau souhaité :

  - logger.debug("string");
  - logger.info("string");
  - logger.error("string");  
  "string" sera le log que vous souhaitez faire apparaître en sortie (console et/ou fichier(s)).


  *Exemple de sortie (sans les tirets) :*

    - DEBUG class : baudvincassagneslaville.com.Main - test debug - 21:13:25.287 26/02/15
    - INFO class : baudvincassagneslaville.com.Main - test info - 21:13:25.287 26/02/15
    - ERROR class : baudvincassagneslaville.com.Main - test error - 21:13:25.287 26/02/15

**NOTES IMPORTANTES :**

  Il est possible de changer le niveau de priorité dans le fichier "config.properties" ou directement dans le programme avec la méthode *setLevel(DEBUG/INFO/ERROR)*.
  
  Il est possible d'activer ou de désactiver les cibles (la sortie des logs), mais UNIQUEMENT dans le fichier "config.properties" (TRUE ou FALSE en fonction de ce que vous préférez).
  
  Il est possible d'activer la sortie sur plusieurs fichiers (200 lignes par fichier).
  
  Il est possible de changer le path/nom du fichier de sortie dans le fichier "config.properties" ou dans le programme directement avec la méthode *setLogFileName("filename")*.
