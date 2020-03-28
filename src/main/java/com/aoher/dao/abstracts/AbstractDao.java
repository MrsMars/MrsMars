package com.aoher.dao.abstracts;

import com.aoher.model.abstracts.AbstractBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

import static java.lang.String.format;

public abstract class AbstractDao<T extends AbstractBean> {

    private static final Logger log = LoggerFactory.getLogger(AbstractDao.class);

    private Class<T> entityClass;

    @PersistenceContext(unitName = "crudEjb")
    protected EntityManager entityManager;

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T insert(T entidade) {
        try {
            entityManager.persist(entidade);
            entityManager.flush();
            return entidade;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public T update(T entidade) {
        try {
            entityManager.merge(entidade);
            entityManager.flush();
            return entidade;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public T findByPk(Serializable id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public boolean delete(T entidadte) {
        try {
            entidadte = entityManager.find(entityClass, entidadte.getId());
            entityManager.remove(entidadte);
            entityManager.flush();
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery(format("From %s", entityClass.getName())).getResultList();
    }
}
