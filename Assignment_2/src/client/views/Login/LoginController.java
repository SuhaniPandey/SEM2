package client.views.Login;

import client.core.ViewHandler;
import client.views.Register.RegisterViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController
{
  
  @FXML private TextField passwordtextField;
  @FXML private TextField usernameTextField;

  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;


  public void init(ViewHandler viewHandler, LoginViewModel loginViewModel){
    this.viewHandler= viewHandler;
    this.loginViewModel=loginViewModel;

  }
  public void onLoginButton(ActionEvent actionEvent)
  {
  }

  public void onRegisterButton(ActionEvent actionEvent)
  {
  }
}
