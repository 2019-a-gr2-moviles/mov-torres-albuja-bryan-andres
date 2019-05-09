package crud

import entidades.Editorial
import java.io.*
import javax.swing.*
import javax.swing.table.DefaultTableModel

val rutaArchivoEditoriales = "src/archivos/editoriales.txt"
val archivoEditorial = File(rutaArchivoEditoriales)
val lectorArchivoEditorial = FileReader(archivoEditorial)
val bufferReaderEditorial = BufferedReader(lectorArchivoEditorial)

val arregloEditorial = ArrayList<Editorial>()
var lecturaDatosEditorial = ""

fun listarEditoriales():Int {
    val panel = JPanel()
    val modeloTabla = DefaultTableModel(arrayOf(arrayOf("Nombre", "Fundacion")), arrayOf("Names", "In", "Order"))

    lecturaDatosEditorial = bufferReaderEditorial.readLine()

    val editorialesEnArchivo = lecturaDatosEditorial.split(';')

    editorialesEnArchivo.forEach { editorial ->
        val separador = editorial.split(',')

        var editorialAMostrar = Editorial(
            nombre = separador[0],
            fundacion = separador[1].toInt()
        )

        arregloEditorial.add(editorialAMostrar)

        arregloEditorial.forEach { editorial ->
            var editorialEnTabla = arrayOf(editorial.nombre, editorial.fundacion)

            modeloTabla.addRow(editorialEnTabla)
        }

        modeloTabla.removeRow(0)
    }

    val tabla = JTable(modeloTabla)
    tabla.createDefaultColumnsFromModel()
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)

    panel.add(tabla)

    JOptionPane.showConfirmDialog(null, panel, "Lista de editoriales", 2)

    return tabla.selectedRow
}

fun actualizarArchivoEditorial(listaEditoriales: ArrayList<Editorial>) {
    val bufferWriter: BufferedWriter

    var datosAEscribir = ""
    var esPrimero: Boolean = true

    if(archivoEditorial.exists()) {
        bufferWriter = BufferedWriter(FileWriter(archivoEditorial))

        listaEditoriales.forEach { editorial ->
            if(esPrimero) {
                datosAEscribir = datosAEscribir.plus(editorial.nombre).plus(",").plus(editorial.fundacion)

                esPrimero = false
            }

            else {
                datosAEscribir = datosAEscribir.plus(";").plus(editorial.nombre).plus(",").plus(editorial.fundacion)
            }
        }

        bufferWriter.write(datosAEscribir)
    }

    else {
        bufferWriter = BufferedWriter(FileWriter(archivoEditorial))

    }

    bufferWriter.close()
}

fun crearEditorial() {
    val panel = JPanel()

    val nombreLabel = JLabel("Ingrese el nombre de la editorial:")
    val nombreTextField = JTextField(10)
    val fundacionLabel = JLabel("Ingrese el año de fundacion:")
    val fundacionTextField = JTextField(10)

    panel.add(nombreLabel)
    panel.add(nombreTextField)
    panel.add(fundacionLabel)
    panel.add(fundacionTextField)

    JOptionPane.showConfirmDialog(null, panel, "Crear nueva editorial", JOptionPane.OK_CANCEL_OPTION)

    val nuevaEditorial = Editorial(
        nombre = nombreTextField.text,
        fundacion = fundacionTextField.text.toInt()
    )

    arregloEditorial.add(nuevaEditorial)

    actualizarArchivoEditorial(arregloEditorial)
}

fun editarEditorial(indice: Int) {
    val panel = JPanel()

    val nombreLabel = JLabel("Ingrese el nuevo nombre de la editorial:")
    val nombreTextField = JTextField(10)
    val fundacionLabel = JLabel("Ingrese el nuevo año de fundacion:")
    val fundacionTextField = JTextField(10)

    panel.add(nombreLabel)
    panel.add(nombreTextField)
    panel.add(fundacionLabel)
    panel.add(fundacionTextField)

    nombreTextField.text = arregloEditorial[indice].nombre
    fundacionTextField.text = arregloEditorial[indice].fundacion.toString()

    JOptionPane.showConfirmDialog(null, panel, "Editar editorial", JOptionPane.OK_CANCEL_OPTION)

    arregloEditorial[indice].nombre = nombreTextField.text
    arregloEditorial[indice].fundacion = fundacionTextField.text.toInt()

    actualizarArchivoEditorial(arregloEditorial)
}

fun eliminarEditorial(indice: Int) {
    var comicAEliminar: Editorial = arregloEditorial[indice]
    arregloEditorial.remove(comicAEliminar)

    actualizarArchivoEditorial(arregloEditorial)
}
