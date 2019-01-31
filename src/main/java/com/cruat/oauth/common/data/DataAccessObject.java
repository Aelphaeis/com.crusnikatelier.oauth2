package com.cruat.oauth.common.data;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public interface DataAccessObject<T extends DataEntity> {

	default T find(long id) {
		return getSession().get(getEntityClass(), id);
	}
	
	default Collection<T> find(Long... ids) {
		return find(Arrays.asList(ids));
	}
	default Collection<T> find(List<Long> ids) {
		return getSession().byMultipleIds(getEntityClass()).multiLoad(ids);
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
		Session sess = getSession();
		Query<T> q = sess.createQuery(queryString, getEntityClass());
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i, params[i]);
		}
		return q.getResultList();
	}

	default void createOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	default void update(T entity) {
		getSession().update(entity);
	}

	default void create(T entity) {
		getSession().save(entity);
	}

	default void delete(T entity) {
		getSession().delete(entity);
	}

	default void delete(Iterable<T> entities) {
		for (T entity : entities) {
			getSession().delete(entity);
		}
	}
	Session getSession();
	Class<T> getEntityClass();
}
