package org.ecad.sga.service.mapper;


import org.ecad.sga.domain.ArquivoBancario;
import org.ecad.sga.service.dto.ArquivoBancarioDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link ArquivoBancario} and its DTO {@link ArquivoBancarioDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ArquivoBancarioMapper extends EntityMapper<ArquivoBancarioDTO, ArquivoBancario> {



    default ArquivoBancario fromId(Long id) {
        if (id == null) {
            return null;
        }
        ArquivoBancario arquivoBancario = new ArquivoBancario();
        arquivoBancario.setId(id);
        return arquivoBancario;
    }
}
