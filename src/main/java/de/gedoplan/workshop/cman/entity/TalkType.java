package de.gedoplan.workshop.cman.entity;

public enum TalkType
{
  KEYNOTE('K'), SESSION('S'), WORKSHOP('W');

  private char persistentForm;

  private TalkType(char persistentForm)
  {
    this.persistentForm = persistentForm;
  }

  public char getPersistentForm()
  {
    return this.persistentForm;
  }

  public static TalkType valueOf(char persistentForm)
  {
    for (TalkType talkType : values())
    {
      if (talkType.getPersistentForm() == persistentForm)
      {
        return talkType;
      }
    }

    throw new IllegalArgumentException("Unknown persistent form");
  }
}
