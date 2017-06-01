
**Nom/Prénom Etudiant 1 :** DIAB Nicolas

**Nom/Prénom Etudiant 2 :** PIAT Grégoire

# Rapport PROJET FLOCKING

## Structure
Voici ci-dessous un aperçu de notre diagramme de classe sur lequel n'apparaissent que les entités sans leurs attributs et fonctions.
![diagram](/images/ClassDiagram.png)

## Pattern observer

## Algorithme de flocking
Notre algorithme de flocking est disponible dans la classe [FlockingAgent.java](/src/main/java/tortue/model/agent/FlockingAgent.java).

Cet algorithme fonctionne de la manière suivante
 * Itération sur chaque tortue
 * Recherche de toutes les tortues dans un espace de x pixels autour de la tortue courante
 * Calcul de la direction moyenne de toutes les tortues de l'espace
 * Assignation de la direction moyenne à la tortue courrante

## Algorithme d'évitement d'obstacle
