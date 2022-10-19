package client.views.Register;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterController
{
  
  @FXML private TextField usernameRegister;
  @FXML private TextField passswordRegister;
  @FXML private TextField reenterRegister;
  @FXML private Label label;

  private ViewHandler viewHandler;
  private RegisterViewModel registerViewModel;

  public void init(ViewHandler viewHandler, RegisterViewModel registerViewModel){
    this.viewHandler= viewHandler;
    this.registerViewModel=registerViewModel;
  }

  public void onSignUpButton(ActionEvent actionEvent)
  {
    registerViewModel.onRegister(usernameRegister.getText(),passswordRegister.getText(),reenterRegister.getText());
  }

  public void onAlreadyHaveAnAccountButton()
  {
    viewHandler.openLoginPage();
  }
}
