package upperCase.core;

import upperCase.model.TextConverter;
import upperCase.model.TextConverterModel;

public class ModelFactory
{
  private TextConverter textConverter;

  public TextConverter getTextConverter(){
    if (textConverter== null)
      textConverter= new TextConverterModel();
    return textConverter;
  }
}
