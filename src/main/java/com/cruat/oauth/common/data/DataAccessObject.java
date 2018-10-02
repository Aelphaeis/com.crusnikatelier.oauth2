package com.cruat.oauth.common.data;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;


public interface DataAccessObject<T extends DataEntity> {

	default T find(long id) {
		return getEntityManager().find(getEntityClass(), id);
	}
	
	default Collection<T> find(Long... ids) {
		return find(Arrays.asList(ids));
	}
	
	default Collection<T> find(List<Long> ids) {
		Session session = getEntityManager().unwrap(Session.class);
		return session.byMultipleIds(getEntityClass()).multiLoad(ids);
	}

	default T first(String query, Object... params) {
		List<T> result = query(query, params);
		return result.isEmpty() ? null : result.get(0);
	}

	default T distinct(String query, Object... params) {
		List<T> result = query(query, params);
		if (result.size() > 1) {
			String err = "More than one element meeting criteria";
			throw new DuplicateEntityException(err);
		}
		return result.isEmpty() ? null : result.get(0);
	}

	default List<T> query(String queryString, Object... params) {
		EntityManager sess = getEntityManager();
		TypedQuery<T> q = sess.createQuery(queryString, getEntityClass());
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i, params[i]);
		}
		return q.getResultList();
	}

	default void createOrUpdate(T entity) {
		getEntityManager().unwrap(Session.class).saveOrUpdate(entity);
	}

	default void update(T entity) {
		getEntityManager().unwrap(Session.class).update(entity);
	}

	default void create(T entity) {
		getEntityManager().persist(entity);
	}

	default void delete(T entity) {
		getEntityManager().remove(entity);
	}

	default void delete(Iterable<T> entities) {
		for (T entity : entities) {
			getEntityManager().remove(entity);
		}
	}
	EntityManager getEntityManager();
	Class<T> getEntityClass();
}
