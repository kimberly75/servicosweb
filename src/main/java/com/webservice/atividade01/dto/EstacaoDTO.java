package com.webservice.atividade01.dto;

import com.webservice.atividade01.model.Estacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstacaoDTO {

	private Integer codigo;
	private Double latitude;
	private Double longitude;
	private String descricao;

	public Estacao convertEstacao() {
		return Estacao.builder().codigo(this.codigo).descricao(this.descricao).latitude(this.latitude)
				.longitude(this.longitude).build();
	}

}
