import scala.io.Source

/* D'abord on importe les données de notre fichier txt qui nous permet de tester notre code */
object Code extends App {
  val fichier = "direct/exemple.txt"
  var input = {
    val src = Source.fromFile(fichier).getLines().toList
    src
  }

  /* on recupère depuis notre fichier les coordonnées séparées par des espaces */
  val crd = input(0).split(" ")

/* la première ligne correspond aux coordonnées du coin supérieur droit de la pelouse */
  val mon_gazon = new Coordinates(crd(0).toInt, crd(1).toInt)
  input = input.patch(0, Nil, 1)
  var mower = 0

/* Boucle while permet d'utiliser les séquences d'instruction envoyer aux tondeuses pour calculer
  * leur position finale à l'aide de la classe tondeuse_instance*/

  while (input.length > 1){
    mower += 1
    var location = input(0).toString.split(" ")
    var orientation = input(1).toString
    input = input.drop(2)
    var tondeuse_fin = new tondeuse_instance(mon_gazon, location(0).toInt, location(1).toInt, location(2))
    tondeuse_fin.motion(orientation)
    println(s"Position finale de la tondeuse numéro $mower : ${tondeuse_fin.X} ${tondeuse_fin.Y} ${tondeuse_fin.O}")

  }
}

