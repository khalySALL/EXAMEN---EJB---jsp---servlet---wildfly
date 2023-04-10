package sn.isi.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.isi.entities.Cv;

@Stateless
public class CvDao extends RepositoryImpl<Cv> implements ICv {
	@PersistenceContext(unitName="examalickEJB")
	protected EntityManager em;

	@Override
	public Object find(String telephone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Object find) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editCv(Cv cv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCv(Cv id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cv getCv(Cv id) {
		// TODO Auto-generated method stub
		return null;
	}


	}

