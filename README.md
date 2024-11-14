# dojo-poker-23-24-ps5-23-24-poker-l

### Explication du code :
Notre code permet la saisie de mains de poker et la comparaison entre deux main poker déterminer laquelle des deux et la plus puissante. Il est constitué de différentes classes pour réaliser cette tâche toutes rangées dans le répertoire src
* Carte : Permet de créer un objet de type carte qui possède une valeur et une couleur et la comparaison avec une autre carte.
* Valeur : Un énumérateur qui permet de sélectionner une valeur entre 2 et As qui pourra être assigné à un carte
* Couleur : Un énumérateur qui permet de sélectionner une couleur entre Cœur, Carreaux, Pic et Trèfle qui pourra être assigné à un carte
* Main : Permet la création d’une main de poker composée de 1 à 5 carte et la comparaison avec une autre main pour savoir laquelle est la plus puissante. Ceci est bien sûr impossible dans le cas où les deux mains sont de taille différentes. Si les deux mains sont de même taille, la puissance des deux mains sera déterminé et la main la plus puissante sera donnée avec le détail de sa puissance.
* Input : Permet la saisie de deux mains de poker sur l’entrée standard et effectue une comparaison entre les deux mains et renvoie la main gagnante avec le détail de sa victoire. Les deux mains peuvent être constituée de 1 à 5 cartes.


* CarteTest : ce sont les tests sur la comparaison et l'équivalence des cartes
* MainTest : ce sont tous les tests pour les mains pour tous les types de victoires avec un maximum de cas possibles pour chacune d'entre elles afin de délecter tous les problèmes
### Stucture des fichiers :
Notre projet contient un dossier "src" initial. Dans celui-ci il y a deux dossiers : un autre dossier "src" qui contient les classes JAVA décrites plus haut et un dossier "test" qui possède les tests décrits plus haut.

Pour pouvoir ainsi tester notre projet vous pouvez créer un projet vierge avec intellij puis remplacer le dossier "src" créé par défaut par le grand dossier "src" qui contient les deux dossiers "src" et "test".

### Exécution :
Afin d’exécuter notre programme, il suffit d’exécuter le fichier Input.java puis de saisir les mains de poker sur l’entrée standard de la façon suivante.
Les cartes constituant les mains doivent être saisie sous la forme : valeur (majuscule si c'est une tête) + couleur (première lettre en majuscule et deuxième en minuscule)
* Exemple : RPi pour le Roi de Pique, 3Co pour le 3 de Cœur
* Les cartes doivent être espacé par un espace
* Exemple de main valide : Vco 2Ca 5Tr 2Tr 10Pi

### Auteurs :
* Cholewa Théo SI3 à Polytech Nice Sophia, France
* Bottero Adam SI3 à Polytech Nice Sophia, France
* Roques Maxence SI3 à Polytech Nice Sophia, France
* Heilmann Hugo SI3 à Polytech Nice Sophia, France
