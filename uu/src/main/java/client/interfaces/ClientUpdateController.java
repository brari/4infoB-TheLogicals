package client.interfaces;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import tn.esprit.CRmapp.entities.Client;
import tn.esprit.CRmapp.services.userServiceRemote;

public class ClientUpdateController implements Initializable {
	@FXML
	private TextField entry1;
	@FXML
	private TextField entry11;
	@FXML
	private TextField entry12;
	@FXML
	private TextField entry13;
	@FXML
	private TextField entry14;
	@FXML
	private TextField entry15;
	@FXML
	private Button update_button;
	
	
	
	
	public void setClient(Client h){
	     
	     int t=0;
	     Client he;
	                
	      he=h;          
	                
	    
	      this.entry1.setText(String.valueOf(he.getIdUser()));
	      
	      this.entry11.setText(he.getEmail());
	      this.entry12.setText(he.getPassword());
	      this.entry13.setText(he.getAddress());
	      this.entry14.setText(String.valueOf(he.getFidelity_pt()));
	      this.entry15.setText(he.getPhoneNumber());
	      
	}
	
	
	public void initialize(URL url, ResourceBundle rb)  {
		
		
		update_button.setOnAction(new EventHandler<ActionEvent>() {
           
           @Override
           public void handle(ActionEvent event) {
             
       Client h=new Client();
       

       h.setAddress(entry12.getText());
       h.setEmail(entry13.getText());
       h.setPhoneNumber(entry14.getText());
       h.setFidelity_pt(Integer.parseInt(entry15.getText()));
      
       
       
      
          if  (entry1.getText().length() != 0&&entry11.getText().length() != 0&&entry12.getText().length() != 0&&entry13.getText().length() != 0&&entry14.getText().length() != 0&&entry15.getText().length() != 0) {
        	  String jndiName="CRmapp-ear/CRmapp-ejb/userService!tn.esprit.CRmapp.services.userServiceRemote";
      		Context context;
      		try {
				context = new InitialContext();
				userServiceRemote proxy;
				proxy = (userServiceRemote) context.lookup(jndiName);
				proxy.updateUser(h, Integer.parseInt(entry1.getText()));
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
              ((Node)event.getSource()).getScene().getWindow().hide();
          }
          else {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("information Dialog");
           alert.setHeaderText(null);
           alert.setContentText("fill all the fields");
           alert.show();
       }
     
           }
       });
	
	
	 
	    

}

}
