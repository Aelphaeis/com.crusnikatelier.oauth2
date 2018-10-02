package com.cruat.oauth.common.data;

public interface DataAccessObject<T extends DataEntity> {
	public T create(T obj);
	public T update(T obj);
	public void delete(T obj);
}
