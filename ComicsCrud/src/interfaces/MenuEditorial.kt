package interfaces

import crud.crearEditorial
import crud.editarEditorial
import crud.eliminarEditorial
import crud.listarEditoriales
import javax.swing.*
import javax.swing.table.DefaultTableModel

fun mostrarOpcionesEditorial() {
    try {
        var indice = -1
        var opcionesMenu = -1
        do {
            opcionesMenu = opcionesTablaEditorial()

            when(opcionesMenu) {
                1 -> listarEditoriales()
                2 -> crearEditorial()
                3 -> {
                    indice = listarEditoriales()
                    editarEditorial(indice)
                }
                4 -> {
                    indice = listarEditoriales()
                    eliminarEditorial(indice)
                }
            }
        } while(opcionesMenu != 4)
    }

    catch (e: IllegalStateException) {
        print("No existen datos almacenados")
    }
}

fun opcionesTablaEditorial(): Int {
    val panel = JPanel()
    val modeloTabla = DefaultTableModel(arrayOf(arrayOf("Índice", "Opción"),
                        arrayOf("1.", "Lista de editoriales"), arrayOf("2.", "Crear editorial"),
                        arrayOf("3.", "Editar editorial"), arrayOf("4.", "Eliminar editorial")),
                        arrayOf("Names", "In"))

    val tabla = JTable(modeloTabla)
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
    tabla.createDefaultColumnsFromModel()

    panel.add(tabla)

    JOptionPane.showConfirmDialog(null, panel, "Menú editorial", 2)

    return tabla.selectedRow
}