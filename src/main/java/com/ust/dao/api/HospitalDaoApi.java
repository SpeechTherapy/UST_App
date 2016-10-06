package com.ust.dao.api;

import java.util.List;

import com.ust.entity.Hospital;

public interface HospitalDaoApi {
	
	public abstract int persist(Hospital hospital);

    public abstract void attachDirty(Hospital hospital);

    public abstract void attachClean(Hospital hospital);

    public abstract void delete(Hospital hospital);

    public abstract Hospital merge(Hospital hospital);

    public abstract Hospital findById(int id);

    public abstract List<Hospital> findByExampleWithLike(Hospital hospital);

    public abstract List<Hospital> findAll();

}
