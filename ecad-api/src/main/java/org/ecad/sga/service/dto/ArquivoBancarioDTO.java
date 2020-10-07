package org.ecad.sga.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Lob;

import lombok.Data;

/**
 * A DTO for the {@link br.com.connect.domain.ArquivoBancario} entity.
 */
@Data
public class ArquivoBancarioDTO implements Serializable {

	private Long id;

	private String banco;

	private String tipo;

	private String nomeArquivo;

	private LocalDate dataGeracao;

	private String geradoPor;

	private LocalDate dataEnvio;

	private Integer qtdLinhas;

	private Integer carteira;

	private BigDecimal valorTotal;

	@Lob
	private byte[] txt;

	private String txtContentType;
	private String foo;

}
