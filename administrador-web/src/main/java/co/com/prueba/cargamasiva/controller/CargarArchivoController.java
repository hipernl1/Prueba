package co.com.prueba.cargamasiva.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import co.com.prueba.cargamasiva.dto.maestros.CampaniaDto;
import co.com.prueba.cargamasiva.dto.transaccion.ArchivoDto;
import co.com.prueba.cargamasiva.dto.transaccion.ItemDto;
import co.com.prueba.cargamasiva.facade.transaccional.ArchivoFacade;

@ViewScoped
@Named("cargarArchivoController")
@ManagedBean
public class CargarArchivoController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -455286099412965728L;

	private static final String UBICACION_ARCHIVOS = "/home/leonardo/archivo_masivo/prueba";

	private UploadedFile file;
	private String delimitador;
	private ArchivoDto archivoDto;
	private List<String> columnas;
	private String[] selectedColumnas;
	private List<ItemDto> listItem;

	public CargarArchivoController() {
		columnas = new ArrayList<String>();
	}

	@Inject
	private ArchivoFacade archivoFacade;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Exito", file.getFileName() + " fue cargado.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage message = new FacesMessage("Exito", event.getFile().getFileName() + " fue cargado.");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void fileUploadListener(FileUploadEvent e) {
		try {
			this.file = e.getFile();
			guardarArchivo(file);
		} catch (IOException e1) {
			System.err.println("Error al almacenar el archico " + e1.fillInStackTrace());
		}
	}

	/**
	 * Almacena el archivo en el servidor y lo registra en la Bd
	 * 
	 * @param file
	 * @throws IOException
	 */
	private void guardarArchivo(UploadedFile file) throws IOException {
		String filename = FilenameUtils.getName(file.getFileName());
		String basename = FilenameUtils.getBaseName(filename) + "_";
		String extension = "." + FilenameUtils.getExtension(filename);
		File fileTemp = File.createTempFile(basename, extension, new File(UBICACION_ARCHIVOS));
		FileOutputStream output = new FileOutputStream(fileTemp);

		InputStream input = file.getInputstream();

		try {
			IOUtils.copy(input, output);
			archivoDto = new ArchivoDto(filename, FilenameUtils.getName(fileTemp.getName()), extension,	UBICACION_ARCHIVOS);
		} finally {
			IOUtils.closeQuietly(input);
			IOUtils.closeQuietly(output);
		}
	}

	/**
	 * Metodo encargado de obtener la primera linea del archivo y extraer sus columnas
	 */
	public void seleccionarColumnas() {
		String[] opciones = null;
		String nombreArchivo = UBICACION_ARCHIVOS + "/" + archivoDto.getNombreArchivoServidor();
		try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
			opciones = reader.readLine().split(delimitador);
			columnas.addAll(Arrays.asList(opciones));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo encargado de visulizar las columnas seleccionadas en pantalla
	 */
	public void subirArchivo() {
		listItem = new ArrayList<>();
		List<Integer> indices = new ArrayList<>();
		for (String valor : selectedColumnas) {
			if (columnas.indexOf(valor) != -1) {
				indices.add(columnas.indexOf(valor));
			}
		}
		String nombreArchivo = UBICACION_ARCHIVOS + "/" + archivoDto.getNombreArchivoServidor();
		try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
			CampaniaDto campania = archivoFacade.consultarUltimaCampania();
			String linea = "";
			while ((linea = reader.readLine()) != null) {
				ItemDto item = new ItemDto();
				String[] column = linea.split(delimitador);
				for (int i = 0; i < column.length; i++) {
					if (indices.get(0) == i) {
						item.setNombres(column[i]);
					}
					if (indices.get(1) == i) {
						item.setApellidos(column[i]);
					}
					if (indices.get(2) == i) {
						item.setTelefonos(column[i]);
					}
					if (indices.get(3) == i) {
						item.setDireccion(column[i]);
					}
				}
				item.setCodigoCampania(campania.getCodigo());
				listItem.add(item);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the delimitador
	 */
	public String getDelimitador() {
		return delimitador;
	}

	/**
	 * @param delimitador
	 *            the delimitador to set
	 */
	public void setDelimitador(String delimitador) {
		this.delimitador = delimitador;
	}

	/**
	 * @return the columnas
	 */
	public List<String> getColumnas() {
		return columnas;
	}

	/**
	 * @param columnas
	 *            the columnas to set
	 */
	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}

	/**
	 * @return the selectedColumnas
	 */
	public String[] getSelectedColumnas() {
		return selectedColumnas;
	}

	/**
	 * @param selectedColumnas
	 *            the selectedColumnas to set
	 */
	public void setSelectedColumnas(String[] selectedColumnas) {
		this.selectedColumnas = selectedColumnas;
	}

	/**
	 * @return the listItem
	 */
	public List<ItemDto> getListItem() {
		return listItem;
	}

	/**
	 * @param listItem
	 *            the listItem to set
	 */
	public void setListItem(List<ItemDto> listItem) {
		this.listItem = listItem;
	}

}
