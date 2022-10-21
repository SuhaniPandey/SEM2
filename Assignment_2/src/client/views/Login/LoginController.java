package client.views.Login;

import client.core.ViewHandler;
import client.views.Register.RegisterViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController
{
  
  @FXML private TextField passwordtextField;
  @FXML private TextField usernameTextField;
  @FXML private Label label;

  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;


  public void init(ViewHandler viewHandler, LoginViewModel loginViewModel){
    this.viewHandler= viewHandler;
    this.loginViewModel=loginViewModel;
    usernameTextField.textProperty().bindBidirectional(loginViewModel.usernameProperty());
    passwordtextField.textProperty().bindBidirectional(
        loginViewModel.passwordProperty());
    label.textProperty().bind(loginViewModel.labelProperty());

  }
  public void onLoginButton() throws IOException
  {
    // error when login method is called
    if (loginViewModel.login()){
      //System.out.println("inside if");
      viewHandler.openGlobalChatPage();
    }
  }

  public void onRegisterButton() throws IOException
  {
    viewHandler.openRegisterpage();
  }
}
