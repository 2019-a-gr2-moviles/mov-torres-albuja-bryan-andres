package crud

import entidades.Comic
import java.io.*
import javax.swing.*
import javax.swing.table.DefaultTableModel

val rutaArchivoComics = "src/archivos/comics.txt"
val archivoComics = File(rutaArchivoComics)
val lectorArchivoComics = FileReader(archivoComics)
val bufferReaderComics = BufferedReader(lectorArchivoComics)

val arregloComics = ArrayList<Comic>()
var lecturaDatosComics = ""

fun listarComics():Int {
    val panel = JPanel()
    val modeloTabla = DefaultTableModel(arrayOf(arrayOf("Nombre", "Autor")), arrayOf("Names", "In", "Order"))

    lecturaDatosComics = bufferReaderComics.readLine()

    val comicsEnArchivo = lecturaDatosComics.split(';')

    comicsEnArchivo.forEach { comic ->
        val separador = comic.split(',')

        var comicAMostrar = Comic(
            nombre = separador[0],
            escritor = separador[1]
        )

        arregloComics.add(comicAMostrar)

        arregloComics.forEach { comic ->
            var comicEnTabla = arrayOf(comic.nombre, comic.escritor)

            modeloTabla.addRow(comicEnTabla)
        }

        modeloTabla.removeRow(0)
    }

    val tabla = JTable(modeloTabla)
    tabla.createDefaultColumnsFromModel()
    tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)

    panel.add(tabla)

    JOptionPane.showConfirmDialog(null, panel, "Lista de comics", 2)

    return tabla.selectedRow
}

fun actualizarArchivoComics(listaComics: ArrayList<Comic>) {
    val bufferWriter: BufferedWriter

    var datosAEscribir = ""
    var esPrimero: Boolean = true

    if(archivoEditorial.exists()) {
        bufferWriter = BufferedWriter(FileWriter(archivoEditorial))

        listaComics.forEach { comic ->
            if(esPrimero) {
                datosAEscribir = datosAEscribir.plus(comic.nombre).plus(",").plus(comic.escritor)

                esPrimero = false
            }

            else {
                datosAEscribir = datosAEscribir.plus(";").plus(comic.nombre).plus(",").plus(comic.escritor)
            }
        }

        bufferWriter.write(datosAEscribir)
    }

    else {
        bufferWriter = BufferedWriter(FileWriter(archivoEditorial))

    }

    bufferWriter.close()
}

fun crearComic() {
    val panel = JPanel()

    val nombreLabel = JLabel("Ingrese el nombre del comic:")
    val nombreTextField = JTextField(10)
    val escritorLabel = JLabel("Ingrese el nombre del escritor:")
    val escritorTextField = JTextField(10)

    panel.add(nombreLabel)
    panel.add(nombreTextField)
    panel.add(escritorLabel)
    panel.add(escritorTextField)

    JOptionPane.showConfirmDialog(null, panel, "Crear nuevo comic", JOptionPane.OK_CANCEL_OPTION)

    val nuevoComic = Comic(
        nombre = nombreTextField.text,
        escritor = escritorTextField.text
    )

    arregloComics.add(nuevoComic)

    actualizarArchivoComics(arregloComics)
}

fun editarComic(indice: Int) {
    val panel = JPanel()

    val nombreLabel = JLabel("Ingrese el nuevo nombre del comic:")
    val nombreTextField = JTextField(10)
    val escritorLabel = JLabel("Ingrese el nuevo nombre del escritor:")
    val escritorTextField = JTextField(10)

    panel.add(nombreLabel)
    panel.add(nombreTextField)
    panel.add(escritorLabel)
    panel.add(escritorTextField)

    nombreTextField.text = arregloComics[indice].nombre
    escritorTextField.text = arregloComics[indice].escritor

    JOptionPane.showConfirmDialog(null, panel, "Editar comic", JOptionPane.OK_CANCEL_OPTION)

    arregloComics[indice].nombre = nombreTextField.text
    arregloComics[indice].escritor = escritorTextField.text

    actualizarArchivoComics(arregloComics)
}

fun eliminarComic(indice: Int) {
    val panel = JPanel()
    val mensajeConfirmacion = JLabel("¿Desea eliminar el elemento seleccioando?")

    panel.add(mensajeConfirmacion)
    JOptionPane.showConfirmDialog(null, panel, "Eliminar comic", JOptionPane.YES_NO_CANCEL_OPTION)

    var comicAEliminar: Comic = arregloComics[indice]
    arregloComics.remove(comicAEliminar)

    actualizarArchivoComics(arregloComics)
}