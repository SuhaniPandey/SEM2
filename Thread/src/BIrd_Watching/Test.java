package BIrd_Watching;

public class Test
{
  public static void main(String[] args) throws InterruptedException
  {
    Bird bird= new Bird();
    Bird_Watcher birdWatcher1= new Bird_Watcher(bird);
    Bird_Watcher birdWatcher2= new Bird_Watcher(bird);
    BlindBirdWatcher birdWatcher3= new BlindBirdWatcher(bird);
    bird.action();

  }
}
