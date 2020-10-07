package org.ecad.sga.web.rest;

import org.ecad.sga.service.ArquivoBancarioService;
import org.ecad.sga.service.dto.ArquivoBancarioDTO;
import org.ecad.sga.service.filter.ArquivoBancarioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * REST controller for managing {@link br.com.connect.domain.ArquivoBancario}.
 */
@RestController
@CrossOrigin
@RequestMapping("/arquivos")
@RequiredArgsConstructor
public class ArquivoBancarioResource {

    private final ArquivoBancarioService arquivoBancarioService;


    @PostMapping
	public Page<ArquivoBancarioDTO> search(@RequestBody ArquivoBancarioFilter search, Pageable pageable) {
		return arquivoBancarioService.findAll(search, pageable);
	}
    
    @GetMapping
    public String ping() {
    	return "Ping";
    }
}
