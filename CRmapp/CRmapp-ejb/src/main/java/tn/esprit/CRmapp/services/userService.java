package tn.esprit.CRmapp.services;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.sun.javafx.scene.traversal.SubSceneTraversalEngine;

import tn.esprit.CRmapp.entities.Client;
import tn.esprit.CRmapp.entities.User;




/**
 * Session Bean implementation class userService
 */
@Stateless
@LocalBean
public class userService implements userServiceRemote, userServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="CRmapp-ejb")
	EntityManager em;
    public userService() {
        // TODO Auto-generated constructor stub
    }
     
	public  void addUser(Client u)
	{
		em.persist(u);
		
	}

	@Override
	public void removeUser(int id)
	{
		em.remove(em.find(User.class, id));
	}

	@Override
	public void updateUser(Client userNewValues, int id)
	{
		Client f = em.find(Client.class, id);
		f.setAddress(userNewValues.getAddress());
		f.setEmail(userNewValues.getEmail());
		
		f.setPhoneNumber(userNewValues.getPhoneNumber());
		f.setFidelity_pt(userNewValues.getFidelity_pt());
		
	}

	@Override
	public Client findUserById(int id)
	{
		Client f = em.find(Client.class, id);
		return f;
	}

	@Override
	public List<User> findAllUsers()
	{
		List<User> u = em.createQuery(" select * from user", User.class).getResultList();
		return u;
	} 
	
	
	
	
	public boolean authentifier(String login, String password) {
		boolean a=true;
		Client utilisateur = null;
		Query query = em.createQuery("select u from Client u where u.email=:e and u.password=:p");
		query.setParameter("e", login).setParameter("p", password);
		try {
			utilisateur = (Client) query.getSingleResult();
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "authentication failed with login="+login+" and password="+password);
			a=false ;
		
		}
		return a;
		
	}
	public String IdentifierOperator(String mail) {
		boolean a=true;
		String utilisateur = null;
		Query query = em.createQuery("select phoneNumber from Client u where u.email=:e ");
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

