package sn.isi.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.isi.entities.Cv;
import sn.isi.entities.User;
@Stateless
public class UserDao extends RepositoryImpl<User> implements IUser {
	@PersistenceContext(unitName="examalickEJB")
	protected EntityManager em;
	private Object userId;

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 @Override
	public Cv getCvByUserId(Integer id1) {
		 User user = em.find(User.class, userId);
	        if (user != null) {
	            return user.getCv();
	        } else {
	            return null;
	        }
	}*/

	@Override
	public User authenticateuser(String login, String password) {
		User user = null;
		try {
			user = (User) em.createQuery("FROM User U WHERE U.login = :login").setParameter("login", login)
					.getSingleResult();
			if (user != null && user.getPassword().equals(password)) {
				return user;
			}
			return null;

		} catch (Exception e) {
			return null;
		}

	}

	
}
