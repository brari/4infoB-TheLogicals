package client.interfaces;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import tn.esprit.CRmapp.entities.Client;
import tn.esprit.CRmapp.services.userServiceRemote;
import javafx.scene.control.PasswordField;

public class SignupController  {
	@FXML
	private TextField sign_mail;
	@FXML
	private TextField sign_number;
	@FXML
	private TextField sign_adress;
	@FXML
	private Button sign_button;
	@FXML
	private PasswordField pass_sing;
	@FXML
	private TextField fid_sign;
	
	
public void initialize(URL url, ResourceBundle rb) throws  NamingException {
        
        
		sign_button.setOnAction((ActionEvent event)  ->  { 
          
        // TODO
			
			System.out.println("cnt");
			try {
					String jndiName="CRmapp-ear/CRmapp-ejb/userService!tn.esprit.CRmapp.services.userServiceRemote";
					Context context;
					context = new InitialContext();
					userServiceRemote proxy;
					proxy = (userServiceRemote) context.lookup(jndiName);
					Client  p =new Client(sign_mail.getText(),pass_sing.getText(),sign_adress.getText(),sign_number.getText());
					 proxy.addUser(p);
					 
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
        
         
            
        
            
        });
       /* vider_ajout.setOnAction((ActionEvent event) -> {
            
        entry1.setText("");
        entry2.setText("");
        entry3.setText("");
        entry4.setText("");
        entry5.setText("");
        entry6.setText("")
        
        
         });}*/
        
        
        // TODO
    }    
	

}



