fun main() {
    //Variables

    // 1. Mutables

    var nombre = "Andrés"
    nombre = "Bryan"

    // 2. Inmutables

    val nombreI = "Andrés"
    // nombreI = "Bryan"

    //Tipos de datos

    val apellido: String = "Torres"
    val edad: Int = 23
    val sueldo: Double = 2.7
    val casado: Boolean = false
    val hijos: Nothing? = null

    // Condicionales

    if(apellido == "Torres") {
        println("Verdadero")
    }

    else {
        println("Falso")
    }

    val tieneNombreYApellido = if(apellido != null && nombre != null) "ok" else "not ok :'v"
    println(tieneNombreYApellido)

    estaJalado(1.0)
    estaJalado(5.5)
    estaJalado(7.0)
    estaJalado(10.00)
    estaJalado(0.00)

}

fun estaJalado(nota: Double) {
    when (nota) {
        7.0 -> {
            println("Pasas con las justas chamo")
        }

        10.0 -> {
            println("¡Felicitaciones!")
        }

        0.00 -> {
            println("¡Dios mio!")
        }

        else -> {
            println("Tu nota es: ${nota}")
        }
    }
}

