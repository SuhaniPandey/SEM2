package Automatic_Door;

public class Door
{
  private DoorState currentState;

  public Door(DoorState initialState)
  {
    currentState = initialState;
  }
  public void Open()
  {
    currentState.Open(this);
  }
  public void close()
  {
    currentState.Close(this);
  }
  void setDoorState(DoorState state)
  {
    this.currentState=state;
  }
}
