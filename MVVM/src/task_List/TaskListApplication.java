package task_List;

import task_List.core.ModelFactory;
import task_List.core.ViewHandler;
import task_List.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class TaskListApplication extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory mf= new ModelFactory();
    ViewModelFactory vmf= new ViewModelFactory(mf);
    ViewHandler vh= new ViewHandler(vmf);
    vh.start();
  }
}
