package com.webservice.atividade01.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.atividade01.dto.EstacaoDTO;
import com.webservice.atividade01.model.Estacao;
import com.webservice.atividade01.repository.EstacaoRepository;

@RestController
@RequestMapping("/estacoes")
public class EstacaoController {

	@Autowired
	EstacaoRepository estacaoRepository;
	
	@GetMapping
    public List<Estacao> getEstacoes() {
        return estacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Estacao getEstacao(@PathVariable Integer id) {
        return estacaoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<Estacao> createEstacao(@RequestBody EstacaoDTO estacaoDto) throws URISyntaxException {
    	Estacao estacao = estacaoRepository.save(estacaoDto.convertEstacao());
        return ResponseEntity.created(new URI("/estacoes/" + estacao.getCodigo())).body(estacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estacao> updateEstacao(@PathVariable Integer id, @RequestBody EstacaoDTO estacaoDto) {
    	Estacao estacao = estacaoRepository.findById(id).orElseThrow(RuntimeException::new);
    	estacao.setCodigo(estacaoDto.getCodigo());
    	estacao.setDescricao(estacaoDto.getDescricao());
    	estacao.setLatitude(estacaoDto.getLatitude());
    	estacao.setLongitude(estacaoDto.getLongitude());
    	estacao = estacaoRepository.save(estacao);

        return ResponseEntity.ok(estacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer id) {
    	estacaoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
	
}
