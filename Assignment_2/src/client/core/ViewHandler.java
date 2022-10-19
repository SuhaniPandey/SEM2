package client.core;

import client.views.Login.LoginController;
import client.views.Register.RegisterController;
import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene loginScene, registerScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory){
    this.viewModelFactory=viewModelFactory;
  }

  public void start() throws IOException
  {
    stage= new Stage();
     openRegisterpage();
  }

  public void openLoginPage(){
    FXMLLoader loader= new FXMLLoader();

    Parent root= loadFXMLFiles("/client/views/Login/Login.fxml",loader);
    LoginController loginController= loader.getController();
    loginController.init(this, viewModelFactory.getLoginViewModel());

    loginScene= new Scene(root);
    stage.setTitle("Login");
    stage.setResizable(false);
    stage.setScene(loginScene);
    stage.show();
  }

  public void openRegisterpage() throws IOException
  {


  FXMLLoader loader= new FXMLLoader();
    Parent root= loadFXMLFiles("/client/views/Register/Register.fxml",loader);

    RegisterController registerController= loader.getController();
    registerController.init(this,viewModelFactory.getRegisterViewModel());

    registerScene= new Scene(root);
    stage.setTitle("Register");
    stage.setResizable(false);
    stage.setScene(registerScene);
    stage.show();
  }

  private Parent loadFXMLFiles(String path, FXMLLoader loader)
  {
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try
    {
      // loading fxml files in parent instance, containing all GUI elements
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

//  public void openLoginPage()
//  {
//    if (loginScene== null){
//      try
//      {
//        Parent root= loadFXML("client/views/Login/Login.fxml");
//        loginScene = new Scene(root);
//        stage.setTitle("Login");
//        stage.setResizable(false);
//      }
//      catch (IOException e)
//      {
//        e.printStackTrace();
//      }
//      stage.setScene(loginScene);
//      stage.show();
//    }
//  }
//
//  public void openRegisterPage(){
//    if (registerScene== null){
//      try
//      {
//        Parent root= loadFXML("client/views/Register/Register.fxml");
//        registerScene = new Scene(root);
//        stage.setTitle("Register");
//        stage.setResizable(false);
//      }
//      catch (IOException e)
//      {
//        e.printStackTrace();
//      }
//      stage.setScene(registerScene);
//      stage.show();
//    }
//  }
//
//  private Parent loadFXML(String path) throws IOException {
//    FXMLLoader loader = new FXMLLoader();
//    loader.setLocation(getClass().getResource(path));
//    Parent root = loader.load();
//
//    ViewController ctrl = loader.getController();
//    ctrl.init(this, viewModelFactory);
//    return root;
//  }
}
