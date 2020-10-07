package org.ecad.sga.repository;

import org.ecad.sga.domain.ArquivoBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ArquivoBancario entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ArquivoBancarioRepository extends JpaRepository<ArquivoBancario, Long>, JpaSpecificationExecutor<ArquivoBancario> {
}
