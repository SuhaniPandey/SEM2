package Soccer_Match;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements PropertyChangeSubject
{
  private PropertyChangeSupport support;
  private String team0 = "Dream Team";
  private String team1 = "Old Boys";

  public SoccerMatch(){
    support= new PropertyChangeSupport(this);
  }

  public void startMatch() {
    System.out.println("Match starting \n\n");
    Random random = new Random();
    for(int i = 0; i < 90; i++) {

      int rand = random.nextInt(100);
      int whichTeam = random.nextInt(2);

      if(rand < 8) {
        // score goal
        scoreGoal(whichTeam);
      } else if(rand < 12) {
        // penalty
        roughTackle(whichTeam);
      }

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        break;
      }
    }

    System.out.println("\n\nMatch ended");
  }

  private void roughTackle(int whichTeam) {
    if(whichTeam == 0) {
      System.out.println("\n Dream team rough tackle");
      support.firePropertyChange("DreamTeamRoughTackle",null,null);
    } else {
      System.out.println("\n Old boys rough tackle");
      support.firePropertyChange("OldBoysRoughTackleRoughTackle",null,null);
    }
  }

  private void scoreGoal(int whichTeam) {
    int DreamTeamScore =0;
    int OldBoysScore=0;

    if(whichTeam == 0) {
      DreamTeamScore++;
      System.out.println("\n Dream Team Scores goalllll");
      support.firePropertyChange("DreamTeamScoreGoal",null,DreamTeamScore);
    } else {
      OldBoysScore++;
      System.out.println("\n Old Boys Scores goal");
      support.firePropertyChange("OldBoysScoreGoal",null,OldBoysScore);
    }
  }

  @Override public void addPropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName,listener);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName,listener);
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
