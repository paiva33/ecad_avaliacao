package org.ecad.sga.service;

import org.ecad.sga.domain.ArquivoBancario;
import org.ecad.sga.repository.ArquivoBancarioRepository;
import org.ecad.sga.service.dto.ArquivoBancarioDTO;
import org.ecad.sga.service.filter.ArquivoBancarioFilter;
import org.ecad.sga.service.mapper.ArquivoBancarioMapper;
import org.ecad.sga.service.specs.ArquivoBancarioSpecs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * Service Implementation for managing {@link ArquivoBancario}.
 */
@Service
@RequiredArgsConstructor
public class ArquivoBancarioServiceImpl implements ArquivoBancarioService {

    private final ArquivoBancarioRepository arquivoBancarioRepository;
    private final ArquivoBancarioMapper arquivoBancarioMapper;

	@Override
	public Page<ArquivoBancarioDTO> findAll(ArquivoBancarioFilter filter, Pageable pageable) {
		return arquivoBancarioRepository.findAll(ArquivoBancarioSpecs.withFilter(filter), pageable).map(arquivoBancarioMapper::toDto);
	}
}
