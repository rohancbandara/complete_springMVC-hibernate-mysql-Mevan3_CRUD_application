package com.rcb.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rcb.entities.Docter;
import com.rcb.utils.AbstractRepository;

@Repository
public class DocterRepository extends AbstractRepository<Long, Docter> {
	public Docter findDocterById(Long dId) throws Exception {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("dId", dId));
		return (Docter) criteria.uniqueResult();
	}

	public List<Docter> getAll() throws Exception {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("dId"));
		return (List<Docter>) criteria.list();

	}

	public Long save(Docter docter) throws Exception {

		return (Long) getSession().save(docter);
	}

	public void deleteDocter(Docter docter) throws Exception {
		getSession().delete(docter);
	}

}
