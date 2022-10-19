package die;

public class Game
{
  protected boolean isSixSidedDice=true;
  protected Factory game= new RegularDieFactory();

  public void diceSides(){
    if (isSixSidedDice){
      System.out.println("\n it has six sides");
      game= new RegularDieFactory();
      isSixSidedDice= true;
    }
    else {
      System.out.println("\n nope its eight side dice");
      game= new VikingDieFactory();
      isSixSidedDice= false;
    }
  }

  public void makeGame(){
    Die die= game.playgame();
  }

  public Game () {
    diceSides();
    makeGame();
    makeGame();
    makeGame();
    makeGame();
    makeGame();
    makeGame();

    diceSides();
    makeGame();
    makeGame();
    makeGame();
    makeGame();
    makeGame();
    makeGame();

    diceSides();
    makeGame();
    makeGame();
    makeGame();
    makeGame();
    makeGame();
    makeGame();
  }
}
