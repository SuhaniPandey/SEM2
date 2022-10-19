package client.views.Login;

import client.core.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private StringProperty username,password;
  private ModelFactory modelFactory;

  public LoginViewModel(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    username= new SimpleStringProperty();
    password= new SimpleStringProperty();
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }


}
