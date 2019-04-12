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

    // Arreglos

    // "Estáticos"

    val arregloCumpleaños = arrayOf(1, 2, 3, 4, 5)
    val arregloTodo: Any = arrayOf(true, 1, "asd", 5.0)

    arregloCumpleaños[0] = 5
    arregloCumpleaños.set(0, 5)

    //La variable no se puede reasignar cuando es val, SOLO la variable
    arregloCumpleaños = arrayOf(5, 2, 3, 4)

    val fecha = Date()
    fecha.time = 112231231
    fecha.year = 2000

    //

    val notas = arrayListOf(1, 2, 3, 4, 5)

    //FOR EACH -> Itera el arreglo

    notas.forEachIndexed {indice, nota ->
        println("Índice: $indice")
        println("Nota: $nota")
    }

    //MAP -> Itera y modifica

    val notasDos = notas.map(nota -> {
        nota + 1
    })

    //Impares + 1 Pares +2

    notasDos.forEach(
        if(nota % 2 == 0) nota + 2 else nota + 1
    )

    val novias = arrayListOf(1, 2, 3, 4, 5)

    val respuesta = novias.any(
            it < 2
    )

    val tazos = arrayListOf(1, 2, 3, 4, 5)

    val valorAcumulado = tazos.all(
        i > 1
    )

    val respuestaTazos.reduce(
        valorAcumulado,
        tazo -> {
            valorAcumulado + tazo
        }
    )
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

fun holaMundo(mensaje: String):Unit {
    println("Mensaje $mensaje.")
}

fun holaMundoAvanzado(mensaje: any):Unit {
    println("Mensaje $mensaje.")
}

fun sumarDosNumeros(a: Int, b: Int):Int {
    return a + b
}

fun paraImpar(nota: Int) {
    val modulo = nota

    when(modulo) {
        0 -> {
            nota + 2
        } else -> {
         nota + 1
        }
    }
}