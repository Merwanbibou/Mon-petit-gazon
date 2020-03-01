 # Projet Scala MoSEF 2019 - Merwan Amar Chelouah


Ce repository inclut un dossier qui contient les scripts en language Scala du projet, notamment :
- Deux classes, l'une permettant d'instancier les tondeuses, l'autre le gazon
 - Le code principal permettant de déterminer les positions d'arrivées des tondeuses instanciées sur le gazon
## Intro
Il s'agit de mettre en pratique les connaissances générales en programmation sous Scala notamment la création d'objet et de classes, l'utilisation d'input via des sources externes ou encore l'utilisation des fonctions.

## Explication du code
Nous avons crée deux classes Scala, la première classe nommée "Coordonnées" permet :
- D'instancier notre environnement, c'est à dire notre gazon, cette classe prend en input deux variables Integer correspondant à la surface de notre pelouse, respectivement la longueur (crdX) et la largeur (crdY)

Nous avons crée une seconde classe, nommée tondeuse_instance qui permet :
- D'instancier nos tondeuses, on peut instancier le nombre de tondeuses que l'on souhaite, c'est l'avantage des classes, il faut pour cela deux d'integer qui correspondent à sa position initiale sur le gazon ainsi que son orientation initiale.
- De construire les possibilités de mouvement, notamment la possibilités de changer de direction (Gauche ou Droite) ou d'avancer (Avancer)
- Pour lui donner l'ordre d'avancer, la tondeuse doit recevoir l'instruction A, elle avance alors dans la direction vers laquelle elle est orientée 
- Pour lui donner l'ordre de modifier son orientation à 90° vers la gauche et vers la droite, elle doit recevoir respectivement les instructions G et D.

Nous avons créé un code principal permettant d'effectuer un traitement sur nos tondeuse :
- Le code principal nommé "Code" permet le traitement sur nos tondeuses, il nécéssite un input contenant : 
  - En première ligne les paramètres de notre gazon c'est à dire sa longueur et sa largeur sous forme de nombre entiers
  - Les positions initiales de nos tondeuses c'est à dire 2 Integer suivit de l'orientation initale de nos tondeuses
  - Chaque ligne correspondant à chaque tondeuse doit être suivie d'une ligne correspondant aux instructions qu'on lui donne
- Le code execute alors en boucle les instructions fournit par l'input sur les tondeuses respectives

## Exemple
Voici un exemple d'usage du script: 
```
On entre comme input :
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
En executant le script principal, on obtient comme sortie :
Position finale de la tondeuse 1 : 1 3 N
Position finale de la tondeuse 2 : 5 1 E
```
Merci pour votre confiance, ce fichier n'est pas un virus !!!

Je tiens à remercier Github ainsi que mes plus grands fans, sans oubliez Mourad Karoui.

Merci Monsieur K !

