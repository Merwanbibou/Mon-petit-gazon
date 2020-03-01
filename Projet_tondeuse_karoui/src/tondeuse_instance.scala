/* On instancie nos tondeuses */
/* La position initiale d'une tondeuse est définit par trois paramètres deux chiffres qui correspondent aux coordonées
* de la tondeuse sur la pelouse (ici de dimension 5*5) suivi d'une lettre définissant son orientation (N, E, W, S)  */
/* Par exemple notre première tondeuse a pour position de départ 1 2 N */

/* On définit la classe ci-dessous avec X et Y des entier et O définit comme chaine de caractère qui correspond à la
* lettre donnant l'orientation de départ de notre tondeuse */

class tondeuse_instance (val coordinates: Coordinates, var X: Int, var Y: Int, var O: String) {
/* X, abscisse de la position initiale de la tondeuse. Pour la première tondeuse par exemple  X=1*/
    def locationX(x: Int): Unit ={
      this.X = x
    }

/* Y, ordonnées de la position initiale de la tondeuse. Y=2 pour la première. */
    def locationY(y: Int): Unit ={
      this.Y = y
    }

/* O, orientation initiale de la tondeuse  */  
    def orientation(o: String, d: String): Unit ={
      this.O = o
      this.O = d
    }

/* Si la position après mouvement est en dehors de la pelouse, la tondeuse ne bouge pas, conserve son orientation
* et traite la commande suivante. 
* C'est pourquoi nous avons définit bord un booleen   */
    def bord(): Boolean = {
      return (0 <= this.X && this.X <= this.coordinates.crdX && 0 <= this.Y && this.Y <= this.coordinates.crdY)
    }

/* Pour commander la tondeuse on lui envoie une séquence de lettres. Les lettres possibles sont "D", "G" et "A"
* "D" et "G" font pivoter de 90degrés la tondeuse à droite ou à gauche sans déplacement.
* "A" signifie que l'on fait avancer la tondeuse d'une unité dans la direction de son orientation */

    def orientation(deplacement: String): Unit = {
      deplacement match {
/* Dans le cas où la tondeuse doit A son déplacement dépend de son orientation ce dont nous tenons compte dans les
* cas ci-dessous :*/
        case "A" => this.O match {
/* La tondeuse est orientée vers le Nord lorsqu'elle avance son ordonnée Y augmente d'une unité.
* Inversement, si elle est orientée vers le Sud son ordonnée Y diminue d'une unité on a donc :  */
          case "N" => this.locationY(this.Y + 1)
          case "S" => this.locationY(this.Y - 1)

/* De même si elle est orientée vers l'Est et avance c'est son abscisse X augmente d'une unité
* Inversement, si elle est orientée vers l'Ouest (W) son abscisse diminue d'une unité d'où : */
          case "E" => this.locationX(this.X + 1)
          case "W" => this.locationX(this.X - 1)
          case _ => ()
        }

/* Si la commande est G ou D en fonction de l'orientation de la tondeuse on a :  */
        case ("G" | "D" )=> this.O match {
          case "N" => this.orientation("W", "E")
          case "S" => this.orientation("E", "W")
          case "E" => this.orientation("N", "S")
          case "W" => this.orientation("S", "N")
          case _ => ()
        }
        case _ => ()
      }
    }

    def parcours(deplacement: String): Boolean = {
      assert(List("A", "G", "D") contains (deplacement))
      var tondeuse_fin = new tondeuse_instance(this.coordinates, this.X, this.Y, this.O)
      tondeuse_fin.orientation(deplacement)
      return tondeuse_fin.bord()
    }

    def motion(orientation: String): Unit = {
      for (deplacement <- orientation){
        if (this.parcours(deplacement.toString)){
          this.orientation(deplacement.toString)
        }
      }
    }
}
