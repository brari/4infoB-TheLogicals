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
	public void removeAdmin(int id)
	{
		em.remove(em.find(Admin.class, id));
	}

	@Override
	public void removeUser(int id)
	{
		em.remove(em.find(Client.class, id));
	}

	@Override
	public void updateUser(Admin userNewValues, int id)
	{
		Admin f = em.find(Admin.class, id);
		f.setAddress(userNewValues.getAddress());
		f.setEmail(userNewValues.getEmail());
		
		f.setPhoneNumber(userNewValues.getPhoneNumber());
		f.setCin(userNewValues.getCin());
	}

	@Override
	public User findUserById(int id)
	{
		User f = em.find(User.class, id);
		return f;
	}
	
	@Override
	public List<Admin> findAllAdmins()
	{
		TypedQuery<Admin> query = em.createQuery("SELECT m FROM Admin m", Admin.class);
		return query.getResultList();
	} 
	

	@Override
	public List<Client> findAllUsers()
	{
		TypedQuery<Client> query = em.createQuery("SELECT m FROM Client m", Client.class);
		return query.getResultList();
	} 
	
	
	@Override
	public List<Client> findAllUsers1()
	{
		TypedQuery<Client> query = em.createQuery("SELECT m FROM Client m WHERE (SUBSTR(m.phoneNumber,1,1)='9')", Client.class);
		return query.getResultList();
	} 
	@Override
	public List<Client> findAllUsers2()
	{
		TypedQuery<Client> query = em.createQuery("SELECT m FROM Client m WHERE (SUBSTR(m.phoneNumber,1,1)='2')", Client.class);
		return query.getResultList();
	} 
	@Override
	public List<Client> findAllUsers3()
	{
		TypedQuery<Client> query = em.createQuery("SELECT m FROM Client m WHERE (SUBSTR(m.phoneNumber,1,1)='5')", Client.class);
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

