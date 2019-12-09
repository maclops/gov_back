package com.controledegastos.entidade;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lancamento")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull(message = "Descrição")
	@Column(name = "descricao")
	private String descricao;
	
	@NotNull(message = "Data Vencimento")
	@Column(name = "data_vencimento")
	private LocalDate dataVencimento;
	
	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;
	
	@NotNull(message = "Valor")
	@Column(name = "Valor")
	private BigDecimal valor;
	
	@Column(name = "observacao")
	private String observacao;
	
	@NotNull(message = "Tipo lançamento")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoLancamento tipo;
	
	@NotNull(message = "Categoria")
	@ManyToOne
	@JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
	private Categoria categoria;
	
	@NotNull(message = "Pessoa")
	@ManyToOne
	@JoinColumn(name = "codigo_pessoa", referencedColumnName = "codigo")
	private Pessoa pessoa;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoLancamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, codigo, dataPagamento, dataVencimento, descricao, observacao, pessoa, tipo,
				valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Lancamento)) {
			return false;
		}
		Lancamento other = (Lancamento) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(dataPagamento, other.dataPagamento)
				&& Objects.equals(dataVencimento, other.dataVencimento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(pessoa, other.pessoa)
				&& tipo == other.tipo && Objects.equals(valor, other.valor);
	}
}


/*
package com.controledegastos.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@NotBlank
	@Size(min = 5, max = 50, message = "Descrição")
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "data_vencimento", nullable = false)
	private Date dataVencimento;

	@Column(name = "data_pagamento", nullable = false)
	private Date dataPagamento;

	@Column(name = "valor")
	@NotBlank
	private Double valor;

	@Size(max = 50, message = "Observação")
	@Column(name = "observacao")
	private String observacao;

	@Size(min = 5, max = 50, message = "Tipo lançamento")
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipo;

	@NotNull(message = "Categoria")
	@ManyToOne
	@JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
	private Categoria categoria;

	@NotNull(message = "Pessoa")
	@ManyToOne
	@JoinColumn(name = "codigo_pessoa", referencedColumnName = "codigo")
	private Pessoa pessoa;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoLancamento getTipo() {
		return tipo;
	}

	public void TipoLancamento(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, pessoa, dataPagamento, dataVencimento, descricao, observacao, tipo, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Lancamento)) {
			return false;
		}
		Lancamento other = (Lancamento) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(pessoa, other.pessoa)
				&& Objects.equals(dataPagamento, other.dataPagamento)
				&& Objects.equals(dataVencimento, other.dataVencimento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(valor, other.valor);
	}

}
*/