package ru.kuznetsov.shop_store_module.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.type.internal.ParameterizedTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kuznetsov.shop_store_module.dto.AbstractDto;
import ru.kuznetsov.shop_store_module.mapper.AbstractMapper;
import ru.kuznetsov.shop_store_module.model.AbstractEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class AbstractService
        <E extends AbstractEntity,
                DTO extends AbstractDto,
                R extends JpaRepository<E, Long>,
                M extends AbstractMapper<E, DTO>
                > {

    public final static String ID_FIELD = "id";
    protected final R repository;
    private final M entityMapper;
    @Autowired
    private ObjectMapper objectMapper;

    protected AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.entityMapper = mapper;
    }

    private String getEntitySimpleName() {
        return ((Class) ((ParameterizedTypeImpl) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
    }

    public List<DTO> findAll() {
        try {
            return repository.findAll()
                    .stream()
                    .map(entityMapper::entityToDto)
                    .toList();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public DTO add(DTO dto) {
        dto.setCreated(LocalDateTime.now());
        dto.setUpdated(LocalDateTime.now());
        var added = repository
                .saveAndFlush(entityMapper.dtoToEntity(dto));
        return entityMapper.entityToDto(added);
    }

    public DTO update(DTO dto) {
        repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException(String.format("%s с id=%s не существует", getEntitySimpleName(), dto.getId())));

        dto.setUpdated(LocalDateTime.now());
        var geoZoneEntity = repository
                .saveAndFlush(entityMapper.dtoToEntity(dto));
        return entityMapper.entityToDto(geoZoneEntity);
    }

    public void deleteById(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else throw new EmptyResultDataAccessException(1);
    }

    public DTO findById(Long id) {
        return entityMapper.entityToDto(findEntityById(id));
    }

    public DTO patchUpdate(Map<String, Object> fields) {
        Object idField = fields.get(ID_FIELD);
        Long id = idField instanceof Long ? (Long) idField : Long.parseLong((String) idField);
        return patchUpdate(id, fields);
    }

    public DTO patchUpdate(Long id, Map<String, Object> fields) {
        E entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("%s с id=%s не существует", getEntitySimpleName(), id)));
        return patchUpdate(entity, fields);
    }

    public DTO patchUpdate(E entity, Map<String, Object> fields) {
        fields.remove(ID_FIELD);
        DTO dto = entityMapper.entityToDto(entity);
        try {
            objectMapper.updateValue(dto, fields);
        } catch (Exception e) {
            log.warn("Error during {} patch update", getEntitySimpleName(), e);
            throw new RuntimeException(e.getMessage());
        }

        dto.setUpdated(LocalDateTime.now());
        var updated = repository
                .saveAndFlush(entityMapper.dtoToEntity(dto));
        return entityMapper.entityToDto(updated);
    }

    public E findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
