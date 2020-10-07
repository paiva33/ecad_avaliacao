package org.ecad.sga.service.specs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.ecad.sga.domain.ArquivoBancario;
import org.ecad.sga.service.filter.ArquivoBancarioFilter;
import org.springframework.data.jpa.domain.Specification;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ArquivoBancarioSpecs {

    /**
     * Retorna {@code Specification} com os filtros de pesquisa.
     * 
     */
    public static Specification<ArquivoBancario> withFilter(ArquivoBancarioFilter filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.isNotBlank(filter.getNossoNumero())) {
                predicates.add(builder.like(builder.lower(root.get("nossoNumero")), filter.getNossoNumero().toLowerCase() + "%"));
            }
//
//            if (StringUtils.isNotBlank(filter.getCpf())) {
//                predicates.add(builder.like(builder.lower(root.get("cpf")), filter.getCpf().toLowerCase() + "%"));
//            }
//
//            if (StringUtils.isNotBlank(filter.getEmail())) {
//                predicates.add(builder.like(builder.lower(root.get("email")), "%" + filter.getEmail().toLowerCase() + "%"));
//            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }


}
