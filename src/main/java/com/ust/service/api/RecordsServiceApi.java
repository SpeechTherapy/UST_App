package com.ust.service.api;

import java.util.List;

import com.ust.entity.Records;

public interface RecordsServiceApi {
	
	public abstract void save(Records records);

    public void saveOrUpdate(Records records);

    public abstract void update(Records records);

    public abstract void delete(Records records);

    public abstract Records findById(int id);

    public abstract List<Records> findByRecords(Records records);

    public abstract List<Records> findAll();

}
