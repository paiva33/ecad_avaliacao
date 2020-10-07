package org.ecad.sga.service.filter;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoBancarioFilter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7991105481863790669L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicial;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataFinal;
	private String nossoNumero;
	private String boleto;
	private String banco;
	private String arquivo;
}
