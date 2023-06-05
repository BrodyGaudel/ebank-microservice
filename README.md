# Application e-Bank

L'application e-Bank est une application bancaire basée sur une architecture à microservices. Elle offre des fonctionnalités de gestion des clients, des comptes bancaires et des opérations (crédit, débit, transfert). Elle est développée en utilisant Java 17, Spring Boot, Spring Cloud et Maven.

<p  align="center">
<img src="https://raw.githubusercontent.com/BrodyGaudel/ebank-cqrs-es-microservice/cf3bb833abbdc7e9b9db83d8d40c1bc73ad9de85/microservice.jpg?token=GHSAT0AAAAAAB54F5TFIUPWQBBQA4IYIPN6ZDMBLWQ">             
<br>

## Microservice : Gestion des clients
Service de gestion des clients : Ce microservice est responsable de la gestion des informations relatives aux clients. Il permet de créer, mettre à jour, récupérer et supprimer des données de clients. Il est accessible via http://localhost:8801/swagger-ui.html

## Microservice : Gestion des comptes
Service de gestion des comptes bancaires : Ce microservice gère les comptes bancaires des clients. Il permet de créer de nouveaux comptes, de consulter les soldes, d'effectuer des dépôts et des retraits. Il est accessible via http://localhost:8802/swagger-ui.html

## Microservice : Gestion des opérations
Service de gestion des opérations : Ce microservice gère les différentes opérations bancaires, telles que les crédits, les débits et les transferts entre comptes. Il est accessible via http://localhost:8803/swagger-ui.html

## Discovery Service
Service de découverte (Discovery) : Ce service permet aux microservices de s'enregistrer auprès de lui, afin de faciliter la découverte des services par les autres microservices. Il est accessible via http://localhost:8761

## Gateway
La Gateway est responsable du routage des requêtes provenant des clients vers les microservices appropriés. Elle agit comme point d'entrée unique pour l'application. Il est accessible via http://localhost:8888


## Prérequis
Avant de démarrer l'application e-Bank, assurez-vous d'avoir les éléments suivants installés :
1. Java 17
2. Maven
3. MySQL

## Configuration
1. cloner le projet
2. allez sous chaque projet pour modifier le fichier application.properties pour qu'il corresponde à votre configuration de MySQL
3. Sous chaque projet, executer la commande **mvn clean install**
4. Démarer tous les services avec la commande **mvn spring-boot:run** dans l'ordre suivant: Discovery-Service, Gateway-Service, Customer-Service, Account-Service, Operation-Service.

## Contribution
Les contributions à cette application sont les bienvenues. Si vous souhaitez contribuer, veuillez suivre les étapes suivantes :

1. Fork ce référentiel.
2. Créez une branche pour votre fonctionnalité ou votre correctif.
3. Effectuez les modifications nécessaires.
4. Soumettez une demande d'extraction. Nous apprécions vos commentaires et vos suggestions pour améliorer cette application.

## Architecture Microservice
L'architecture à microservices est un style d'architecture logicielle qui structure une application en un ensemble de services indépendants et hautement spécialisés. Au lieu de construire une seule application monolithique, l'application est décomposée en petites unités autonomes appelées microservices. Chaque microservice est responsable d'une fonctionnalité spécifique de l'application et communique avec les autres microservices par le biais de mécanismes légers tels que les API REST ou les messages.

Voici les principales caractéristiques de l'architecture à microservices :

1. **Découpage en services autonomes :** Chaque microservice est une unité logique autonome qui peut être développée, déployée et mise à l'échelle indépendamment des autres. Cela permet aux équipes de développement de travailler de manière isolée sur un service spécifique, en utilisant les technologies et les langages de programmation qui conviennent le mieux.

2. **Communication via des interfaces :** Les microservices communiquent entre eux en utilisant des interfaces bien définies, telles que les API REST. Cela permet une intégration souple et modulaire des services, facilitant ainsi l'évolution et la maintenance de l'application.

3. **Distribution et scalabilité :** Les microservices peuvent être déployés et exécutés de manière distribuée sur différents serveurs ou conteneurs. Cela permet une meilleure utilisation des ressources et facilite la mise à l'échelle individuelle des services en fonction de la demande.

4. **Indépendance technologique :** Chaque microservice peut être développé en utilisant des technologies et des frameworks différents, selon les besoins spécifiques du service. Cela permet de choisir la technologie la plus adaptée à chaque tâche, sans être contraint par une technologie unique pour toute l'application.

5. **Gestion décentralisée des données :** Chaque microservice peut avoir sa propre base de données ou utiliser des mécanismes de stockage appropriés pour ses besoins. Les services peuvent gérer leurs propres données de manière indépendante, en garantissant une isolation des données entre les services.

L'architecture à microservices offre plusieurs avantages, tels que la **flexibilité**, **la facilité de déploiement et de mise à l'échelle**, la **résilience et la résistance aux pannes**, ainsi qu'une **meilleure évolutivité**. Cependant, elle introduit également des défis tels que la gestion de la communication inter-services, la coordination des transactions distribuées et le suivi de la cohérence des données à travers les services. Ces défis nécessitent une bonne conception et une architecture adaptée pour tirer pleinement parti des avantages des microservices.

## Auteur
Brody Gaudel MOUNANGA BOUKA

N'hésitez pas à me contacter si vous avez des questions ou des commentaires sur cette application e-Bank.

