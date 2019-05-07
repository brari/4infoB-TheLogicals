package tn.esprit.CRmapp.services;



import java.util.List;

import javax.ejb.Remote;

import javafx.collections.ObservableList;
import tn.esprit.CRmapp.entities.User;
import tn.esprit.CRmapp.entities.Admin;
import tn.esprit.CRmapp.entities.Client;
import tn.esprit.CRmapp.entities.User;
import tn.esprit.CRmapp.entities.User;




@Remote
public interface adminServiceRemote {
	public void  addUser(Admin f);
	public void removeUser(int id);
	public void updateUser(Admin UserNewValues, int id);
	public User findUserById(int id);
	public List<Client> findAllUsers();
	public boolean authentifier(String login, String password);
	public String IdentifierOperator(String mail);
	public List<Client> findAllUsers1();
	public List<Client> findAllUsers2();
	public List<Client> findAllUsers3();
	public List<Admin> findAllAdmins();
	public void removeAdmin(int id);

}