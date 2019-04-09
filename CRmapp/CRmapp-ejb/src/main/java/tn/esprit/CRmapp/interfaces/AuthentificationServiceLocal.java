package tn.esprit.CRmapp.interfaces;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.CRmapp.entities.User;


@Local
public interface AuthentificationServiceLocal {
	public User  authentifier(String login, String pwd);

	public boolean existeLogin(String login);

	public boolean sauvegarderUtilisateur(User utilisateur);
	
	List<User> list();
}
