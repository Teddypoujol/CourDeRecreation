# CourDeRecreation

Modèle : Cour de récréation
Le projet est un jeu de la vie, programmé en langage objet, suivant les règles de la
modélisation objet. La principale problématique du projet est donc de réaliser un jeu
suivant une modélisation objet bien conçue. Le jeu devra suivre certains critères comme
l’utilisation du polymorphisme, de “Design Patterns” et d’interactions entre objets. Nous
avons choisi de représenter une cour de récréation avec des enfants et des professeurs.
Nous suivrons une méthode agile tout au long du projet.

Règles de fonctionnement
Le jeu est une simulation de la vie des enfants et des professeurs dans une cour de
récréation. Tous ces acteurs évoluent sur une grille de jeu bidimensionnelle de 15x10
cases, au démarrage de la simulation celle-ci est composée exclusivement de cases non
marquées. Puis des acteurs sont placés aléatoirement sur la grille.
Le temps est représenté par des tours de jeu. A chaque tour, les règles de vie du jeu
définies sont les suivantes :
• Au début du jeu les élèves et les professeurs sont répartis aléatoirement dans la
cour.
• Les élèves se déplacent chacun leur tour.
• Les élèves ont des types, ils peuvent être bagarreur, romantique, ou normaux.
• Un élève a une visibilité et une portée de déplacement initialisées en début de jeu,
tous les élèves ont le choix entre 4 directions possibles.
• Un professeur ne se déplace pas, il surveille les élèves.
• Un professeur a initialement en moyenne 100 points de patience.
• Un professeur a une visibilité initialisée en début de jeu.
• Un professeur a initialement un niveau d’ancienneté.

Un tour de jeu est défini par les règles suivantes :
• Un élève est sélectionné dans la collection d’élève, dans l’ordre.
• Un élève peut avoir une stratégie de déplacement : Il se dirige vers l’élève le plus
proche de lui.
• S’il n’a pas de stratégie de déplacement, il choisit une des 4 directions possibles
aléatoirement.
• S’il y a une rencontre, une interaction est définie en fonction de l’élève :
Un élève bagarreur déclenche → une bagarre
→ Un élève romantique fait des bisous
Un élève qui n’est ni l’un ni l’autre choisit une action aléatoirement →
entre bisous, bagarre et jouer, avec une plus haute probabilité pour jouer.
• S’il n’y a pas de rencontre, l’élève pleure car il se sent seul.
• Si l’élève est dans le champ de vision du professeur plusieurs conséquences sont
possibles :
Si l’élève pleure :
le professeur perd 1 point de patience →
Si l’élève fait des bisous :
Le professeur gagne 1 point de patience →
Si l’élève se bagarre :
→ Le professeur perd 10 points de patience
→ Les élèves qui se bagarrent se font punir
• Si la patience d’un professeur atteint 0 il rentre en burnout et démissionne.
• Si un élève se fait trop punir (3 fois maximum) il se fait renvoyer de l’école.
• Si le niveau d’ancienneté d’un professeur atteint 20 il part à la retraite. A chaque
tour de jeu, le niveau d’ancienneté augmente de 1.
• le jeu se termine lorsqu’il n’y a plus d’élèves ou plus de professeurs.
