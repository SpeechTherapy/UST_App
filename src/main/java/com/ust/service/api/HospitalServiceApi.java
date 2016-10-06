package com.ust.service.api;

import java.util.List;

import com.ust.entity.Hospital;

public interface HospitalServiceApi {

	 public abstract int save(Hospital hospital);

	    public void saveOrUpdate(Hospital hospital);

	    public abstract void update(Hospital hospital);

	    public abstract void delete(Hospital hospital);

	    public abstract Hospital findById(int id);

	    public abstract List<Hospital> findByHospital(Hospital hospital);

	    public abstract List<Hospital> findAll();
}
