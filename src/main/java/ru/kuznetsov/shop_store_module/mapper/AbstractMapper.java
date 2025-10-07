package ru.kuznetsov.shop_store_module.mapper;

import ru.kuznetsov.shop_store_module.dto.AbstractDto;
import ru.kuznetsov.shop_store_module.model.AbstractEntity;

import java.util.List;

public interface AbstractMapper<E extends AbstractEntity, D extends AbstractDto> {
    D entityToDto(E entity);

    E dtoToEntity(D dto);

    List<D> allEntitiesToDtos(List<E> entities);

    List<E> allDtosToEntities(List<D> entities);
}
