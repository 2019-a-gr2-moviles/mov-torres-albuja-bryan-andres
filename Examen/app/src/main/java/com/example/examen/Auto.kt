package com.example.examen

class Auto(var chasis: Int,
           var nombreMarca: String,
           var colorUno: String,
           var colorDos: String,
           var nombreModelo: String,
           var anio: Int,
           var idConductor: Conductor) {

    companion object {
        val listaAutos = arrayListOf<Auto>(
            Auto(
                123,
                "Tesla",
                "negro",
                "blanco",
                "Tesla S",
                2014,
                Conductor.listaConductores[0]
            ),
            Auto(
                456,
                "Tesla",
                "rojo",
                "azul",
                "Tesla X",
                2016,
                Conductor.listaConductores[0]
            )
        )

        fun autoPorConductor(idConductor: Conductor): List<Auto> {
            val autos = listaAutos.filter {
                it.idConductor == idConductor
            }

            return autos
        }
    }

    fun editarAuto(
        chasisAEditar: Int,
        nombreMarcaAEditar: String,
        colorUnoAEditar: String,
        colorDosAEditar: String,
        nombreModeloAEditar: String,
        anioAEditar: Int
    ) {
        this.chasis = chasisAEditar
        this.nombreMarca = nombreMarcaAEditar
        this.colorUno = colorUnoAEditar
        this.colorDos = colorDosAEditar
        this.nombreModelo = nombreModeloAEditar
        this.anio = anioAEditar
    }
}