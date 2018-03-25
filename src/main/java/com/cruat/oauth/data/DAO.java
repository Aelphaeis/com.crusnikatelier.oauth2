package com.cruat.oauth.data;

public interface DAO<T extends DataEntity> {
	public T create(T obj);
	public T update(T obj);
	public void delete(T obj);
}
