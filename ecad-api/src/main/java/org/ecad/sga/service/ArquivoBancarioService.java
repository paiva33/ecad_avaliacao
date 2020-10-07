package org.ecad.sga.service;

import org.ecad.sga.service.dto.ArquivoBancarioDTO;
import org.ecad.sga.service.filter.ArquivoBancarioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link br.com.connect.domain.ArquivoBancario}.
 */
public interface ArquivoBancarioService {

	
	/**
	 * 
	 * @param filter
	 * @param pageable
	 * @return
	 */
	Page<ArquivoBancarioDTO> findAll(ArquivoBancarioFilter filter, Pageable pageable);
}
