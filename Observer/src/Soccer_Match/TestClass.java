package Soccer_Match;

import java.beans.PropertyChangeListener;

public class TestClass
{
  public static void main(String[] args)
  {
    SoccerMatch match = new SoccerMatch();
    DreamTeamFan dreamTeamFan= new DreamTeamFan(match);
    OldBoysFan oldBoysFan= new OldBoysFan(match);
    Refree refree= new Refree(match);
    MedicClass medicClass= new MedicClass(match);
    ScoreBoard scoreBoard= new ScoreBoard(match);
    AngryCoach angryCoach= new AngryCoach(match);

    match.startMatch();


  }
}
