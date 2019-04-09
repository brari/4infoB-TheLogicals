package client.interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.CRmapp.services.adminServiceRemote;
import tn.esprit.CRmapp.services.userServiceRemote;
import tn.esprit.CRmapp.entities.Admin;
import tn.esprit.CRmapp.entities.Client;

public class LoginController implements Initializable{
	@FXML
	private TextField log_mail_field;
	@FXML
	private TextField password_mail_field;
	@FXML
	private Button button_connextion;
	@FXML
	private Button button_connextion1;
	
public void initialize(URL url, ResourceBundle rb)  {
        
        
	button_connextion.setOnAction((ActionEvent event)  ->  {
		
		
		String jndiName="CRmapp-ear/CRmapp-ejb/userService!tn.esprit.CRmapp.services.userServiceRemote";
		Context context;
		String jndiName1="CRmapp-ear/CRmapp-ejb/adminService!tn.esprit.CRmapp.services.adminServiceRemote";
		Context context1;
		
		Admin SA=new Admin("ola","ola","ola","ola",123);
		
		 if ((log_mail_field.getText().equals(SA.getEmail()))&&(password_mail_field.getText().equals(SA.getPassword()))){
	    	 
	    	 
	    	 
	    	 Stage primaryStage=new Stage();
	 		Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("GestionAdmin.fxml"));
				 Scene scene = new Scene(root);
		         
		         primaryStage.setTitle("Oreedoo");
		         primaryStage.setScene(scene);
		         primaryStage.show();
		         System.out.print("funcional");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	 		
	    	 
	    	 
	    	 
	    	 
	     }
		 else{
		try {
			context = new InitialContext();
			userServiceRemote proxy;
			proxy = (userServiceRemote) context.lookup(jndiName);
	boolean	b=proxy.authentifier(log_mail_field.getText(), password_mail_field.getText());
	context1 = new InitialContext();
	adminServiceRemote proxy2;
	proxy2 = (adminServiceRemote) context1.lookup(jndiName1);
boolean	b1=proxy2.authentifier(log_mail_field.getText(), password_mail_field.getText());


    

    
	
     	if (b==true)
	{
		{Alert a=new Alert(Alert.AlertType.ERROR);
        a.setContentText("Success!");
        a.show();}
		
		context = new InitialContext();
		userServiceRemote proxy1;
		proxy1 = (userServiceRemote) context.lookup(jndiName);
		
		String num=proxy1.IdentifierOperator(log_mail_field.getText());
		
		
		String n=num.substring(0,1);
		System.out.println(n);
		
		
		
		String  nt="9";
		String no="2";
		
		if (n.equals(no))
		{
			
			Stage primaryStage=new Stage();
				Parent root=FXMLLoader.load(getClass().getResource("mainmenuCl.fxml"));
		        Scene scene = new Scene(root);
		        
		        primaryStage.setTitle("Oreedoo");
		        primaryStage.setScene(scene);
		        primaryStage.show();
			}
		
		if (n.equals(nt))
		{
			
			Stage primaryStage=new Stage();
				Parent root=FXMLLoader.load(getClass().getResource("MenuTT.fxml"));
		        Scene scene = new Scene(root);
		        
		        primaryStage.setTitle("Tunisie Telecom");
		        primaryStage.setScene(scene);
		        primaryStage.show();
			}
		
		if (n=="5")
		{
			
			Stage primaryStage=new Stage();
				Parent root=FXMLLoader.load(getClass().getResource("MenuOrange.fxml"));
		        Scene scene = new Scene(root);
		        
		        primaryStage.setTitle("Orange");
		        primaryStage.setScene(scene);
		        primaryStage.show();
			}
		
		
		
	
	}
	
     else if(b1==true){
		
		
		
		
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("MenuAdmin.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Oreedoo");
        primaryStage.setScene(scene);
        primaryStage.show();
		
		
		
	}
	
		}
	
			/*{Alert a=new Alert(Alert.AlertType.ERROR);
            a.setContentText("Success!");
            a.show();}*/
		 catch (NamingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 }
		
			
		 });
	
	button_connextion1.setOnAction((ActionEvent event)  ->  { 
		Stage primaryStage=new Stage();
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
			 Scene scene = new Scene(root);
		        
		        primaryStage.setTitle("Ajouter un Article");
		        primaryStage.setScene(scene);
		        primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
		
	 });
	}


}
		
		

