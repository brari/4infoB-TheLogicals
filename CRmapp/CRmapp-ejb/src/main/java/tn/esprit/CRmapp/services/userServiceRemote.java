package tn.esprit.CRmapp.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.CRmapp.entities.Client;
import tn.esprit.CRmapp.entities.User;




@Remote
public interface userServiceRemote {
	public void  addUser(Client f);
	public void removeUser(int id);
	public void updateUser(Client userNewValues, int id);
	public Client findUserById(int id);
	public List<User> findAllUsers();
	public boolean authentifier(String login, String password);
	public String IdentifierOperator(String mail);

}
