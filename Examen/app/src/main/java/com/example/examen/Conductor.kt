package com.example.examen

class Conductor(var nombres: String,
                var apellidos: String,
                var fechaNacimiento: String,
                var numeroAutos: Int,
                var licenciaValida: Boolean) {

    companion object {
        var listaConductores = arrayListOf<Conductor>(
            Conductor(
                "Elon Reeve",
                "Musk",
                "28/06/1978",
                1,
                true
            )
        )
    }

    fun editarConductor(
        nombresAEditar: String,
        apellidosAEditar: String,
        fechaNacimientoAEditar: String,
        numeroAutosAEditar: Int,
        licenciaValidaAEditar: Boolean
    ) {
        this.nombres = nombresAEditar
        this.apellidos = apellidosAEditar
        this.fechaNacimiento = fechaNacimientoAEditar
        this.numeroAutos = numeroAutosAEditar
        this.licenciaValida = licenciaValidaAEditar
    }
}