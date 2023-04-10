package sn.isi.dao;

import javax.ejb.Local;

import sn.isi.entities.Cv;
import sn.isi.entities.User;
@Local
public interface IUser extends Repository<User> {

	User getUserById(Integer id);

	

	 public  User authenticateuser(String login,String password);

}
