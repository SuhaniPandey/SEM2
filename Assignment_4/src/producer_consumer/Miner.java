package producer_consumer;

import adapter.Deposit;
import multiton.MIne;
import multiton.Valuables;
import singleton.Log;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//producer
public class Miner implements Runnable
{
  private Deposit deposit;
  private MIne mIne;
  private Log log;


  public Miner(Deposit deposit,MIne mIne){
    this.deposit=deposit;
    this.mIne=mIne;
    log=Log.getInstance();
  }

  @Override public void run()
  {
    Valuables valuables= mIne.getAllValuables();
    deposit.add(valuables);
    try
    {
      log.log("It stops adding for few seconds");
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
