package org.ecad.sga.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArquivoBancario {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String banco;
	private String tipo;
	private String nomeArquivo;
	private Date dataGeracao;
	private String nossoNumero;
	private String geradoPor;
	private Date dataEnvio;
	private int qtdLinhas;
	private int carteira;
	private BigDecimal valorTotal;
	
	@Lob
    private byte[] txt;

}
