package de.gedoplan.workshop.domain;

public enum TalkType
{
  KEYNOTE, SESSION, HANDSON, WORKSHOP;
  //
  // private char persistentForm;
  //
  // private TalkType(char persistentForm)
  // {
  // this.persistentForm = persistentForm;
  // }
  //
  // public char getPersistentForm()
  // {
  // return this.persistentForm;
  // }
  //
  // public static TalkType valueOf(char persistentForm)
  // {
  // for (TalkType talkType : values())
  // {
  // if (talkType.getPersistentForm() == persistentForm)
  // {
  // return talkType;
  // }
  // }
  //
  // throw new IllegalArgumentException("Unknown persistent form");
  // }
}
