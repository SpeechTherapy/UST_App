package com.ust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.dao.api.RecordsDaoApi;
import com.ust.entity.Records;
import com.ust.service.api.RecordsServiceApi;

@Service
public class RecordsServiceImpl implements RecordsServiceApi {
	@Autowired
	private RecordsDaoApi recordsDaoApi;

	@Override
	public void save(Records records) {
		recordsDaoApi.persist(records);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(Records records) {
		recordsDaoApi.attachDirty(records);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Records records) {
		recordsDaoApi.merge(records);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Records records) {
		// TODO Auto-generated method stub
		recordsDaoApi.delete(records);
	}

	@Override
	public Records findById(int id) {
		return recordsDaoApi.findById(id);
	}

	@Override
	public List<Records> findByRecords(Records records) {
		return recordsDaoApi.findByExampleWithLike(records);
	}

	@Override
	public List<Records> findAll() {
		return recordsDaoApi.findAll();
	}


}
