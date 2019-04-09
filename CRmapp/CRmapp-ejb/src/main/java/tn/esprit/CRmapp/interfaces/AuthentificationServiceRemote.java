package tn.esprit.CRmapp.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.CRmapp.entities.User;



@Remote
public interface AuthentificationServiceRemote {
	
	public User authentifier(String login, String password);
	
	public boolean existeLogin(String login);
	
	public boolean sauvegarderUtilisateur(User  utilisateur);
	
	
	public List<User> list();

	public User sauvegarderUtilisateur(boolean selected);

	
}




