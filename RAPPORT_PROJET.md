
**Nom/Prénom Etudiant 1 :** DIAB Nicolas

**Nom/Prénom Etudiant 2 :** PIAT Grégoire

# Rapport PROJET FLOCKING

## Structure
Voici ci-dessous un aperçu de notre diagramme de classe sur lequel n'apparaissent que les entités sans leurs attributs et fonctions.

![diagram](/images/ClassDiagram.png)

## Pattern observer

## Algorithme de flocking
Notre algorithme de flocking est disponible dans la classe [FlockingAgent.java](/src/main/java/tortue/model/agent/FlockingAgent.java).

Cet algorithme fonctionne de la manière suivante :
 * Itération sur chaque tortue
 * Recherche de toutes les tortues dans un espace de x pixels autour de la tortue courante
 * Calcul de la direction moyenne de toutes les tortues de l'espace
 * Assignation de la direction moyenne à la tortue courrante (dans la limite de MAX_COLLISION_AVOIDANCE_DIR)
 * Assignation de la vitesse TURTLE_LOW_SPEED si la tortue n'a pas de voisin et TURTLE_SPEED si la tortue appartient à un groupe

## Algorithme d'évitement d'obstacle
Notre algorithme d'évitement d'obstacle est disponible dans la classe [FlockingAgent.java](/src/main/java/tortue/model/agent/FlockingAgent.java).

Cet algorithme fonctionne de la manière suivante :
 * Itération sur chaque tortue
 * Estimation des prochains x et y si l'on suit la direction à la vitesse calculée précédemment
    * Pour cela nous estimons les x et y en avançant de 1 à la vitesse de la tortue
    * Si nous rencontrons un obstacle, nous ajoutons aléatoirement 1 à 5 degrés à la direction de la tortue à droite. Si nous rencontrons encore un obstacle, nous rajoutons 1 à 5 degrés et nous recommençons jusqu'à la limite MAX_COLLISION_AVOIDANCE_DIR, puis nous faisons la même chose à gauche.