package client.views.Login;

import client.core.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.User;

public class LoginViewModel
{
  private StringProperty username,password,label;
  private ModelFactory modelFactory;

  public LoginViewModel(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    username= new SimpleStringProperty();
    password= new SimpleStringProperty();
    label= new SimpleStringProperty();
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public StringProperty labelProperty()
  {
    return label;
  }

  public boolean login(String username, String password){
    User user= new User(username,password);
    if (!modelFactory.getLoginModel().login(user)){
      label.set("Username or password is incorrect");
      return false;
    }
    return true;
  }
}
