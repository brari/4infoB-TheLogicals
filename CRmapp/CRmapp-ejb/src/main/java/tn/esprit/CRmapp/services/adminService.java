package tn.esprit.CRmapp.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sun.javafx.scene.traversal.SubSceneTraversalEngine;

import javafx.collections.ObservableList;
import tn.esprit.CRmapp.entities.Admin;
import tn.esprit.CRmapp.entities.Client;
import tn.esprit.CRmapp.entities.User;




/**
 * Session Bean implementation class userService
 */
@Stateless
@LocalBean
public class adminService implements adminServiceRemote, userServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="CRmapp-ejb")
	EntityManager em;
    public adminService() {
        // TODO Auto-generated constructor stub
    }
     
	public  void addUser(Admin u)
	{
		em.persist(u);
		
	}

	@Override
	public void removeUser(int id)
	{
		em.remove(em.find(User.class, id));
	}

	@Override
	public void updateUser(User userNewValues, int id)
	{
		/*user f = em.find(User.class, id);
		f.setCin(userNewValues.getCin());
		f.setFirst_name(userNewValues.getFirst_name());
		f.setLast_name(userNewValues.getLast_name());
		f.setUsername(userNewValues.getUsername());
		f.setEmail(userNewValues.getEmail());
		f.setNum_tlf(userNewValues.getNum_tlf());
		f.setPassword(userNewValues.getPassword());
		f.setRole(userNewValues.getRole());*/
	}

	@Override
	public User findUserById(int id)
	{
		User f = em.find(User.class, id);
		return f;
	}

	@Override
	public List<Client> findAllUsers()
	{
		TypedQuery<Client> query = em.createQuery("SELECT m FROM Client m", Client.class);
		return query.getResultList();
	} 
	
	/*
	 * 
	 * public List<Etudiant> ListeDesEtudiantsQuiVeulentUneAnnulation(int anul) {
		
		
        TypedQuery<Etudiant> query = entityManager.createQuery("SELECT m FROM Etudiant m ",
                Etudiant.class);

        return query.getResultList();
		
	}
	 */
	
	
	
	public boolean authentifier(String login, String password) {
		boolean a=true;
		Admin utilisateur = null;
		Query query = em.createQuery("select u from Admin u where u.email=:e and u.password=:p");
		query.setParameter("e", login).setParameter("p", password);
		try {
			utilisateur = (Admin) query.getSingleResult();
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "authentication failed with login="+login+" and password="+password);
			a=false ;
		
		}
		return a;
		
	}
	public String IdentifierOperator(String mail) {
		boolean a=true;
		String utilisateur = null;
		Query query = em.createQuery("select phoneNumber from Admin u where u.email=:e ");
		query.setParameter("e", mail);
		try {
			utilisateur = (String) query.getSingleResult();
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "authentication failed with login="+mail);
			a=false ;

		}

		return utilisateur;		

	}
		

}

