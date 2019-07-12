package com.hostal.springboot.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hostal.springboot.app.model.Huesped;
import com.hostal.springboot.app.model.Reserva;
import com.hostal.springboot.app.services.HuespedService;
import com.hostal.springboot.app.services.ReservaService;

@Controller
public class PdfExcelController {
	
	@Autowired private HuespedService huespedService;
	@Autowired private ReservaService reservaService;

	@Autowired private ServletContext context;
	
	@GetMapping(value="/ReporteHuespedes")
	public void AllHuesped(HttpServletRequest request, HttpServletResponse response) {
		List<Huesped> huespedes = huespedService.getAll();
		boolean isFlag = huespedService.createPdf(huespedes, context, response);
		if(isFlag) {
			String fullPath = request.getServletContext().getRealPath("/resources/reports/"+"huespedes"+".pdf");
			filedownload(fullPath,response,"huéspedes.pdf");
		}
	}
	
	@GetMapping(value="/ReporteReservas")
	public void AllReserva(HttpServletRequest request, HttpServletResponse response) {
		List<Reserva> reservas = reservaService.getAll();
		boolean isFlag = reservaService.createPdfReserva(reservas, context, response);
		if(isFlag) {
			String fullPath = request.getServletContext().getRealPath("/resources/reports/"+"reservas"+".pdf");
			filedownload(fullPath,response,"reservas.pdf");
		}
	}

	private void filedownload(String fullPath, HttpServletResponse response, String fileName) {
		// TODO Auto-generated method stub
		File file = new File(fullPath);
		final int BUFFER_SIZE= 4096;
		if(file.exists()) {
			try {
				FileInputStream inputStream = new FileInputStream(file);
				String mimeType = context.getMimeType(fullPath);
				response.setContentType(mimeType);
				response.setHeader("content-disposition", "attachament; filename"+ fileName);
				OutputStream outputStream= response.getOutputStream();
				byte[] buffer = new byte[BUFFER_SIZE];
				int byteRead = -1;
				while((byteRead = inputStream.read(buffer))!= -1) {
					outputStream.write(buffer,0,byteRead);
				}
				inputStream.close();
				outputStream.close(); 
				file.delete();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
}