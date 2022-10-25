package client.views.register;

import client.core.ModelFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegisterViewModel
{
  private StringProperty usernameRegister,passswordRegister,reenterRegister,label;
  private ModelFactory modelFactory;

  public RegisterViewModel(ModelFactory modelFactory){
    this.modelFactory= modelFactory;
    usernameRegister= new SimpleStringProperty();
    passswordRegister= new SimpleStringProperty();
    reenterRegister= new SimpleStringProperty();
    label= new SimpleStringProperty();
  }

  public StringProperty usernameRegisterProperty()
  {
    return usernameRegister;
  }

  public StringProperty passswordRegisterProperty()
  {
    return passswordRegister;
  }

  public StringProperty reenterRegisterProperty()
  {
    return reenterRegister;
  }

  public StringProperty labelProperty()
  {
    return label;
  }

  public void onRegister(String username, String password, String re_enter)
  {
    if (username == null)
    {
      label.set("Username is empty");
    }
    else if (!(password.equals(re_enter)))
    {
      label.set("Password do not match");
    }
    else
    {
      if (modelFactory.getLoginModel().addUser(username, password))
      {
        {
          label.set("Account Successfully Created");
        }
      }
    }
  }
}
