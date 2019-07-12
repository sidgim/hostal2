package com.hostal.springboot.app.commons;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hostal.springboot.app.model.Huesped;
import com.hostal.springboot.app.model.Reserva;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public abstract class GenericServiceImp <T, ID extends Serializable> implements GenericService<T, ID> {
	
	@Override
	public T save(T entity) {
		return getRepository().save(entity);
	}
	@Override
	public void delete(ID id) {
		getRepository().deleteById(id);
	}
	@Override
	@Transactional
	public boolean createPdf(List<Huesped> huespedes, ServletContext context, HttpServletResponse response) {
		Document document = new Document (PageSize.A4,15, 15,45,30);
		try {
			String filePath = context.getRealPath("/resources/reports");
			File file = new File(filePath);
			boolean exists = new File(filePath).exists();
			if(!exists) {
				new File(filePath).mkdirs();
			}
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file+"/"+"huespedes"+".pdf"));
			document.open();
			
			Font mainFont = FontFactory.getFont("Arial",10,BaseColor.BLACK);
			
			Paragraph paragraph = new Paragraph("Reporte de Huéspedes",mainFont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setIndentationLeft(50);
			paragraph.setIndentationRight(50);
			paragraph.setSpacingAfter(10);
			document.add(paragraph);
			
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10);
			
			Font tableHeader = FontFactory.getFont("Arial",10,BaseColor.BLACK);
			Font tableBody = FontFactory.getFont("Arial",9,BaseColor.BLACK);
			
			float [] columnWidths = {2f,2f,2f,2f,2f};
			table.setWidths(columnWidths);
			
			PdfPCell nombre = new PdfPCell (new Paragraph("Nombre", tableHeader));
			nombre.setBorderColor(BaseColor.BLACK);
			nombre.setPaddingLeft(10);
			nombre.setHorizontalAlignment(Element.ALIGN_CENTER);
			nombre.setVerticalAlignment(Element.ALIGN_CENTER);
			nombre.setBackgroundColor(BaseColor.GRAY);
			nombre.setExtraParagraphSpace(5f);
			table.addCell(nombre);
			
			PdfPCell apellido = new PdfPCell (new Paragraph("Apellido", tableHeader));
			apellido.setBorderColor(BaseColor.BLACK);
			apellido.setPaddingLeft(10);
			apellido.setHorizontalAlignment(Element.ALIGN_CENTER);
			apellido.setVerticalAlignment(Element.ALIGN_CENTER);
			apellido.setBackgroundColor(BaseColor.GRAY);
			apellido.setExtraParagraphSpace(5f);
			table.addCell(apellido);
			
			PdfPCell correo = new PdfPCell (new Paragraph("Correo", tableHeader));
			correo.setBorderColor(BaseColor.BLACK);
			correo.setPaddingLeft(10);
			correo.setHorizontalAlignment(Element.ALIGN_CENTER);
			correo.setVerticalAlignment(Element.ALIGN_CENTER);
			correo.setBackgroundColor(BaseColor.GRAY);
			correo.setExtraParagraphSpace(5f);
			table.addCell(correo);
			
			PdfPCell telefono = new PdfPCell (new Paragraph("Teléfono", tableHeader));
			telefono.setBorderColor(BaseColor.BLACK);
			telefono.setPaddingLeft(10);
			telefono.setHorizontalAlignment(Element.ALIGN_CENTER);
			telefono.setVerticalAlignment(Element.ALIGN_CENTER);
			telefono.setBackgroundColor(BaseColor.GRAY);
			telefono.setExtraParagraphSpace(5f);
			table.addCell(telefono);
			
			PdfPCell rut = new PdfPCell (new Paragraph("Rut", tableHeader));
			rut.setBorderColor(BaseColor.BLACK);
			rut.setPaddingLeft(10);
			rut.setHorizontalAlignment(Element.ALIGN_CENTER);
			rut.setVerticalAlignment(Element.ALIGN_CENTER);
			rut.setBackgroundColor(BaseColor.GRAY);
			rut.setExtraParagraphSpace(5f);
			table.addCell(rut);
			
			for(Huesped huesped : huespedes) {
				
				PdfPCell nombreValue = new PdfPCell (new Paragraph(huesped.getNombre(), tableBody));
				nombreValue.setBorderColor(BaseColor.BLACK);
				nombreValue.setPaddingLeft(10);
				nombreValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				nombreValue.setVerticalAlignment(Element.ALIGN_CENTER);
				nombreValue.setBackgroundColor(BaseColor.WHITE);
				nombreValue.setExtraParagraphSpace(5f);
				table.addCell(nombreValue);
				
				PdfPCell apellidoValue = new PdfPCell (new Paragraph(huesped.getApellido(), tableBody));
				apellidoValue.setBorderColor(BaseColor.BLACK);
				apellidoValue.setPaddingLeft(10);
				apellidoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				apellidoValue.setVerticalAlignment(Element.ALIGN_CENTER);
				apellidoValue.setBackgroundColor(BaseColor.WHITE);
				apellidoValue.setExtraParagraphSpace(5f);
				table.addCell(apellidoValue);
				
				PdfPCell correoValue = new PdfPCell (new Paragraph(huesped.getCorreo(), tableBody));
				correoValue.setBorderColor(BaseColor.BLACK);
				correoValue.setPaddingLeft(10);
				correoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				correoValue.setVerticalAlignment(Element.ALIGN_CENTER);
				correoValue.setBackgroundColor(BaseColor.WHITE);
				correoValue.setExtraParagraphSpace(5f);
				table.addCell(correoValue);
				
				PdfPCell telefonoValue = new PdfPCell (new Paragraph(huesped.getTelefono(), tableBody));
				telefonoValue.setBorderColor(BaseColor.BLACK);
				telefonoValue.setPaddingLeft(10);
				telefonoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				telefonoValue.setVerticalAlignment(Element.ALIGN_CENTER);
				telefonoValue.setBackgroundColor(BaseColor.WHITE);
				telefonoValue.setExtraParagraphSpace(5f);
				table.addCell(telefonoValue);
				
				PdfPCell rutValue = new PdfPCell (new Paragraph(huesped.getRun(), tableBody));
				rutValue.setBorderColor(BaseColor.BLACK);
				rutValue.setPaddingLeft(10);
				rutValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				rutValue.setVerticalAlignment(Element.ALIGN_CENTER);
				rutValue.setBackgroundColor(BaseColor.WHITE);
				rutValue.setExtraParagraphSpace(5f);
				table.addCell(rutValue);
				
				
			}
			document.add(table);
			document.close();
			writer.close();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean createPdfReserva(List<Reserva> reservas, ServletContext context, HttpServletResponse response) {
		Document document = new Document (PageSize.A4,15, 15,45,30);
		try {
			String filePath = context.getRealPath("/resources/reports");
			File file = new File(filePath);
			boolean exists = new File(filePath).exists();
			if(!exists) {
				new File(filePath).mkdirs();
			}
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file+"/"+"reservas"+".pdf"));
			document.open();
			
			Font mainFont = FontFactory.getFont("Arial",10,BaseColor.BLACK);
			
			Paragraph paragraph = new Paragraph("Reporte de Reservas",mainFont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			paragraph.setIndentationLeft(50);
			paragraph.setIndentationRight(50);
			paragraph.setSpacingAfter(10);
			document.add(paragraph);
			
			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(100);
			table.setSpacingBefore(10f);
			table.setSpacingAfter(10);
			
			Font tableHeader = FontFactory.getFont("Arial",10,BaseColor.BLACK);
			Font tableBody = FontFactory.getFont("Arial",9,BaseColor.BLACK);
			
			float [] columnWidths = {2f,2f,2f,2f,2f,2f,2f,2f};
			table.setWidths(columnWidths);
			
			PdfPCell fechaentrada = new PdfPCell (new Paragraph("Fecha de Entrada", tableHeader));
			fechaentrada.setBorderColor(BaseColor.BLACK);
			fechaentrada.setPaddingLeft(10);
			fechaentrada.setHorizontalAlignment(Element.ALIGN_CENTER);
			fechaentrada.setVerticalAlignment(Element.ALIGN_CENTER);
			fechaentrada.setBackgroundColor(BaseColor.GRAY);
			fechaentrada.setExtraParagraphSpace(5f);
			table.addCell(fechaentrada);
			
			PdfPCell fechasalida = new PdfPCell (new Paragraph("Fecha de Salida", tableHeader));
			fechasalida.setBorderColor(BaseColor.BLACK);
			fechasalida.setPaddingLeft(10);
			fechasalida.setHorizontalAlignment(Element.ALIGN_CENTER);
			fechasalida.setVerticalAlignment(Element.ALIGN_CENTER);
			fechasalida.setBackgroundColor(BaseColor.GRAY);
			fechasalida.setExtraParagraphSpace(5f);
			table.addCell(fechasalida);
			
			PdfPCell tpago = new PdfPCell (new Paragraph("Tipo de pago", tableHeader));
			tpago.setBorderColor(BaseColor.BLACK);
			tpago.setPaddingLeft(10);
			tpago.setHorizontalAlignment(Element.ALIGN_CENTER);
			tpago.setVerticalAlignment(Element.ALIGN_CENTER);
			tpago.setBackgroundColor(BaseColor.GRAY);
			tpago.setExtraParagraphSpace(5f);
			table.addCell(tpago);
			
			PdfPCell precio = new PdfPCell (new Paragraph("Precio", tableHeader));
			precio.setBorderColor(BaseColor.BLACK);
			precio.setPaddingLeft(10);
			precio.setHorizontalAlignment(Element.ALIGN_CENTER);
			precio.setVerticalAlignment(Element.ALIGN_CENTER);
			precio.setBackgroundColor(BaseColor.GRAY);
			precio.setExtraParagraphSpace(5f);
			table.addCell(precio);
			
			PdfPCell thabitacion = new PdfPCell (new Paragraph("Tipo de Habitación", tableHeader));
			thabitacion.setBorderColor(BaseColor.BLACK);
			thabitacion.setPaddingLeft(10);
			thabitacion.setHorizontalAlignment(Element.ALIGN_CENTER);
			thabitacion.setVerticalAlignment(Element.ALIGN_CENTER);
			thabitacion.setBackgroundColor(BaseColor.GRAY);
			thabitacion.setExtraParagraphSpace(5f);
			table.addCell(thabitacion);
			
			PdfPCell rutValue = new PdfPCell (new Paragraph("Rut", tableHeader));
			rutValue.setBorderColor(BaseColor.BLACK);
			rutValue.setPaddingLeft(10);
			rutValue.setHorizontalAlignment(Element.ALIGN_CENTER);
			rutValue.setVerticalAlignment(Element.ALIGN_CENTER);
			rutValue.setBackgroundColor(BaseColor.GRAY);
			rutValue.setExtraParagraphSpace(5f);
			table.addCell(rutValue);
			
			PdfPCell nombreValue = new PdfPCell (new Paragraph("Nombre", tableHeader));
			nombreValue.setBorderColor(BaseColor.BLACK);
			nombreValue.setPaddingLeft(10);
			nombreValue.setHorizontalAlignment(Element.ALIGN_CENTER);
			nombreValue.setVerticalAlignment(Element.ALIGN_CENTER);
			nombreValue.setBackgroundColor(BaseColor.GRAY);
			nombreValue.setExtraParagraphSpace(5f);
			table.addCell(nombreValue);
			
			PdfPCell apellidoValue = new PdfPCell (new Paragraph("Apellido", tableHeader));
			apellidoValue.setBorderColor(BaseColor.BLACK);
			apellidoValue.setPaddingLeft(10);
			apellidoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
			apellidoValue.setVerticalAlignment(Element.ALIGN_CENTER);
			apellidoValue.setBackgroundColor(BaseColor.GRAY);
			apellidoValue.setExtraParagraphSpace(5f);
			table.addCell(apellidoValue);
			
			for(Reserva reserva : reservas) {
				
				PdfPCell fechaentradaValue = new PdfPCell (new Paragraph(""+(reserva.getFechaEntrada()), tableBody));
				fechaentradaValue.setBorderColor(BaseColor.BLACK);
				fechaentradaValue.setPaddingLeft(10);
				fechaentradaValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				fechaentradaValue.setVerticalAlignment(Element.ALIGN_CENTER);
				fechaentradaValue.setBackgroundColor(BaseColor.WHITE);
				fechaentradaValue.setExtraParagraphSpace(5f);
				table.addCell(fechaentradaValue);		
				
				PdfPCell fechasalidaValue = new PdfPCell (new Paragraph(""+(reserva.getFechaSalida()), tableBody));
				fechasalidaValue.setBorderColor(BaseColor.BLACK);
				fechasalidaValue.setPaddingLeft(10);
				fechasalidaValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				fechasalidaValue.setVerticalAlignment(Element.ALIGN_CENTER);
				fechasalidaValue.setBackgroundColor(BaseColor.WHITE);
				fechasalidaValue.setExtraParagraphSpace(5f);
				table.addCell(fechasalidaValue);
				
				PdfPCell tpagoValue = new PdfPCell (new Paragraph(""+(reserva.getTipoPago()), tableBody));
				tpagoValue.setBorderColor(BaseColor.BLACK);
				tpagoValue.setPaddingLeft(10);
				tpagoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				tpagoValue.setVerticalAlignment(Element.ALIGN_CENTER);
				tpagoValue.setBackgroundColor(BaseColor.WHITE);
				tpagoValue.setExtraParagraphSpace(5f);
				table.addCell(tpagoValue);
				
				PdfPCell precioValue = new PdfPCell (new Paragraph(""+(reserva.getHabitacion().getPrecio()), tableBody));
				precioValue.setBorderColor(BaseColor.BLACK);
				precioValue.setPaddingLeft(10);
				precioValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				precioValue.setVerticalAlignment(Element.ALIGN_CENTER);
				precioValue.setBackgroundColor(BaseColor.WHITE);
				precioValue.setExtraParagraphSpace(5f);
				table.addCell(precioValue);
				
				PdfPCell thabitacionValue = new PdfPCell (new Paragraph(reserva.getHabitacion().getTipo(), tableBody));
				thabitacionValue.setBorderColor(BaseColor.BLACK);
				thabitacionValue.setPaddingLeft(10);
				thabitacionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				thabitacionValue.setVerticalAlignment(Element.ALIGN_CENTER);
				thabitacionValue.setBackgroundColor(BaseColor.WHITE);
				thabitacionValue.setExtraParagraphSpace(5f);
				table.addCell(thabitacionValue);
				
				PdfPCell rrutValue = new PdfPCell (new Paragraph(reserva.getHuesped().getRun(), tableBody));
				rrutValue.setBorderColor(BaseColor.BLACK);
				rrutValue.setPaddingLeft(10);
				rrutValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				rrutValue.setVerticalAlignment(Element.ALIGN_CENTER);
				rrutValue.setBackgroundColor(BaseColor.WHITE);
				rrutValue.setExtraParagraphSpace(5f);
				table.addCell(rrutValue);
				
				PdfPCell rnombreValue = new PdfPCell (new Paragraph(reserva.getHuesped().getNombre(), tableBody));
				rnombreValue.setBorderColor(BaseColor.BLACK);
				rnombreValue.setPaddingLeft(10);
				rnombreValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				rnombreValue.setVerticalAlignment(Element.ALIGN_CENTER);
				rnombreValue.setBackgroundColor(BaseColor.WHITE);
				rnombreValue.setExtraParagraphSpace(5f);
				table.addCell(rnombreValue);
				
				PdfPCell rapellidoValue = new PdfPCell (new Paragraph(reserva.getHuesped().getApellido(), tableBody));
				rapellidoValue.setBorderColor(BaseColor.BLACK);
				rapellidoValue.setPaddingLeft(10);
				rapellidoValue.setHorizontalAlignment(Element.ALIGN_CENTER);
				rapellidoValue.setVerticalAlignment(Element.ALIGN_CENTER);
				rapellidoValue.setBackgroundColor(BaseColor.WHITE);
				rapellidoValue.setExtraParagraphSpace(5f);
				table.addCell(rapellidoValue);
				
				
			}
			document.add(table);
			document.close();
			writer.close();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
	@Override
	public T get(ID id) {
		Optional<T> c = getRepository().findById(id);
		if (c.isPresent()) {
			return c.get();
		}
		return null;
	}
	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getRepository().findAll().forEach(c -> returnList.add(c));	
		return returnList;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<T> getAll(Pageable pageable){
		
		return getRepository().findAll(pageable);
		
	}
	
	public abstract PagingAndSortingRepository< T, ID> getRepository();

}
