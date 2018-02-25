package com.rcb.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rcb.entities.User;
import com.rcb.utils.AbstractRepository;

@Repository
public class UserRepository extends AbstractRepository<Long, User> {

	public User findUserById(Long userId) throws Exception {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userId", userId));
		return (User) criteria.uniqueResult();
	}

	public List<User> getAll() throws Exception {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("userId"));
		return (List<User>) criteria.list();
	}

	public Long save(User user) throws Exception {
		return (Long) getSession().save(user);
	}

	public void deleteUser(User user) throws Exception {
		getSession().delete(user);
	}

	public User findUserByEmailAndPassword(String email, String password) throws Exception {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		return (User) criteria.uniqueResult();
	}

}
