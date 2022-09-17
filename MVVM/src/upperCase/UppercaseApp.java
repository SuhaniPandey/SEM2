package upperCase;


import javafx.application.Application;
import javafx.stage.Stage;
import upperCase.core.ModelFactory;
import upperCase.core.ViewHandler;
import upperCase.core.ViewModelFactory;

import javax.swing.text.View;

public class UppercaseApp extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory= new ModelFactory();
    ViewModelFactory vmf= new ViewModelFactory(modelFactory);
    ViewHandler viewHandler= new ViewHandler(vmf);

    viewHandler.start();
  }
}
