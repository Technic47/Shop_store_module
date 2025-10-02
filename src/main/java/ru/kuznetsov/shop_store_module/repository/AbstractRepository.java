package ru.kuznetsov.shop_store_module.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.kuznetsov.shop_store_module.model.AbstractEntity;

@NoRepositoryBean
public interface AbstractRepository<E extends AbstractEntity> extends CrudRepository<E, Long> {
}
