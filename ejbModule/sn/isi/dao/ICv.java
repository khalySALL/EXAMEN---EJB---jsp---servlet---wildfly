package sn.isi.dao;

import javax.ejb.Local;

import sn.isi.entities.Cv;

@Local
public interface ICv extends Repository<Cv> {

	Object find(String telephone);

	void remove(Object find);

	void editCv(Cv cv);

	void deleteCv(Cv id);

	Cv getCv(Cv id);

	
	
	
	}
