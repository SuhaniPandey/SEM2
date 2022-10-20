package client.views.Chat;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

public class ChatController
{

  @FXML private ListView<String> onlineUserViews;
  //@FXML private ListView<Message> chatViews;
  @FXML private TextField messageTextField;
  private ViewHandler viewHandler;
  private ChatViewModel chatViewModel;

  public void init(ViewHandler viewHandler,ChatViewModel chatViewModel){
    this.viewHandler=viewHandler;
    this.chatViewModel=chatViewModel;
  }


  //GLobal Chat
  public void onSelectUserButtonGlobalChat(ActionEvent actionEvent)
  {
    viewHandler.openIndivisualChatPage();
  }

  public void onSendButton(ActionEvent actionEvent)
  {
  }

  //shared

  // Indivisual Chat

  public void onSendButtonIndivisualChat(ActionEvent actionEvent)
  {
  }

  public void onBackToGlobalChat(ActionEvent actionEvent)
  {
    viewHandler.openGlobalChatPage();
  }
}
