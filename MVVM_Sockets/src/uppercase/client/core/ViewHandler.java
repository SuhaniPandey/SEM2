package uppercase.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uppercase.client.views.log.LogViewController;
import uppercase.client.views.uppercase.UppercaseViewController;

import java.io.IOException;

public class ViewHandler {

    private Scene uppercaseScene;
    private Stage stage;
    private ViewModelFactory vmf;
    private Scene logScene;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openUppercaseView();
    }


    public void openUppercaseView(){
        FXMLLoader loader= new FXMLLoader();
        Parent root= loadFXMLFiles("../views/uppercase/UppercaseView.fxml",loader);

        UppercaseViewController uppercaseViewController = loader.getController();
        uppercaseViewController.init(this,vmf);

        uppercaseScene= new Scene(root);
        stage.setTitle("Uppercase");
        stage.setResizable(false);
        stage.setScene(uppercaseScene);
        stage.show();
    }


    public void openLogView(){
        FXMLLoader loader= new FXMLLoader();
        Parent root= loadFXMLFiles("../views/log/Log.fxml",loader);

        LogViewController logViewController = loader.getController();
        logViewController.init(this,vmf);

        logScene= new Scene(root);
        stage.setTitle("Log");
        stage.setResizable(false);
        stage.setScene(logScene);
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
}
