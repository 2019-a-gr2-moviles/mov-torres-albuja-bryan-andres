import crud.crearComic
import crud.editarComic
import crud.eliminarComic
import crud.listarComics
import interfaces.mostrarOpcionesComic
import interfaces.mostrarOpcionesEditorial
import javax.swing.JOptionPane
import javax.swing.JPanel
import javax.swing.JTable
import javax.swing.ListSelectionModel
import javax.swing.table.DefaultTableModel

fun main(args: Array<String>) {
    try {
        var indice = -1
        var opcionesMenu = -1
        do {
            opcionesMenu = opcionesMenuGeneral()

            when(opcionesMenu) {
                1 -> mostrarOpcionesComic()
                2 -> mostrarOpcionesEditorial()
            }
        } while(opcionesMenu != 2)
    }

    catch (e: IllegalStateException) {
        print("No existen datos almacenados")
    }
}

fun opcionesMenuGeneral(): Int {
    val panel = JPanel()
    val modeloTabla = DefaultTableModel(arrayOf(arrayOf("Índice", "Opción"),
        arrayOf("1.", "Comics"), arrayOf("2.", "Editoriales")),
        arrayOf("Names", "In"))

    val tabla = JTable(modeloTabla)
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
    tabla.createDefaultColumnsFromModel()

    panel.add(tabla)

    JOptionPane.showConfirmDialog(null, panel, "Menú general", 2)

    return tabla.selectedRow
}
