package client.core;

import client.model.*;
import client.networking.Client;

public class ModelFactory
{
  private ClientFactory clientFactory;
  private ChatModel chatModel;
  private LoginModel loginModel;

  public ModelFactory(ClientFactory clientFactory){
    this.clientFactory=clientFactory;
  }


  public ChatModel getChatModel(){
    if (chatModel== null){
      this.chatModel= new ChatModelImpl(clientFactory.getClient());
    }
    return chatModel;
  }

  public LoginModel getLoginModel(){
    if (loginModel== null){
      this.loginModel= new LoginImp(clientFactory.getClient());
    }
    return loginModel;
  }


}
