package Soccer_Match;

import java.beans.PropertyChangeEvent;

public class ScoreBoard
{
  private SoccerMatch match;
  public ScoreBoard(PropertyChangeSubject subject){
    subject.addPropertyChangeListener("OldBoysScoreGoal",this::reactToOldBoysTeamScoreGoal);
    subject.addPropertyChangeListener("DreamTeamScoreGoal",this::reactToDreamTeamScoreGoal);

  }

  public void reactToDreamTeamScoreGoal(PropertyChangeEvent evt){
    System.out.println("Dream Team scored:"+evt.getNewValue());
  }
  public void reactToOldBoysTeamScoreGoal(PropertyChangeEvent evt){
    System.out.println("Dream Team Scored:"+evt.getNewValue());
  }
}
