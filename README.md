# Framework-BAUDVIN-CASSAGNES-LAVILLE

Ce projet est un framework de gestion de logs en Java avec lecture d'un fichier properties.

Il y a 3 niveaux de logs :

  - Debug
  - Info
  - Error

**Installation :** 
  
  Télécharger le projet GitHub et le dézipper dans le répertoire de votre choix.
  Dans Eclipse, importer la JAR contenue dans le dossier du Framework que vous venez de dézipper en faisant un clic droit sur votre projet -> Build-Path -> Add External Archives puis en choisissant le bon fichier (LogsFramework.jar).
  
  
**Utilisation :**

  Il suffit de l'appeler de cette manière : 

  - logger.debug("string");
  - logger.info("string");
  - logger.error("string"); avec "string" qui sera ce que vous souhaitez écrire

**NOTES :**

  Il est possible de changer le niveau de priorité dans le fichier config.properties ou directement dans le programme.
  
  Il est possible d'activer ou de désactiver les cibles (la sortie des logs), mais UNIQUEMENT dans le fichier config.properties (TRUE ou FALSE en fonction de ce que vous désirez).
