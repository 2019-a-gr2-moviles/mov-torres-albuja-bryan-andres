package interfaces

import crud.*
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.ListSelectionModel
import javax.swing.table.DefaultTableModel

fun mostrarOpcionesComic() {
    try {
        var indice = -1
        var opcionesMenu = -1
        do {
            opcionesMenu = opcionesTablaComic()

            when(opcionesMenu) {
                1 -> listarComics()
                2 -> crearComic()
                3 -> {
                    indice = listarComics()
                    editarComic(indice)
                }
                4 -> {
                    indice = listarComics()
                    eliminarComic(indice)
                }
            }
        } while(opcionesMenu != 4)
    }

    catch (e: IllegalStateException) {
        print("No existen datos almacenados")
    }

}

fun opcionesTablaComic(): Int {
    val panel = JPanel()
    val modeloTabla = DefaultTableModel(arrayOf(arrayOf("Índice", "Opción"),
        arrayOf("1.", "Lista de comics"), arrayOf("2.", "Crear comic"),
        arrayOf("3.", "Editar comic"), arrayOf("4.", "Eliminar comic")),
        arrayOf("Names", "In"))

    val tabla = JTable(modeloTabla)
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
    tabla.createDefaultColumnsFromModel()

    panel.add(tabla)

    JOptionPane.showConfirmDialog(null, panel, "Menú comic", 2)

    return tabla.selectedRow
}