package client.interfaces;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.esprit.CRmapp.entities.Admin;
import tn.esprit.CRmapp.entities.Client;
import tn.esprit.CRmapp.entities.User;
import tn.esprit.CRmapp.services.adminServiceRemote;
import tn.esprit.CRmapp.services.userServiceRemote;

public class dd extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException, NamingException {
		Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Ajouter un Article");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("test");
       String jndiName="CRmapp-ear/CRmapp-ejb/adminService!tn.esprit.CRmapp.services.adminServiceRemote";
		Context context;
		context = new InitialContext();
		adminServiceRemote proxy;
		proxy = (adminServiceRemote) context.lookup(jndiName);
		Admin  p =new Admin("Admin1","123456","Admin","Admin",12345678);
		 proxy.addUser(p);
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
	
	
	
	
}
