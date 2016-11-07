package de.gedoplan.workshop.entity;

public enum TalkType {
  LECTURE("L"), WORKSHOP("W"), KEYNOTE("K"), SESSION("S");

  private String persistentForm;

  private TalkType(String persistentForm) {
    this.persistentForm = persistentForm;
  }

  public String getPersistentForm() {
    return this.persistentForm;
  }

  public static TalkType fromPersistentForm(String persistentForm) {
    for (TalkType tt : values()) {
      if (tt.persistentForm.equals(persistentForm)) {
        return tt;
      }
    }

    throw new IllegalArgumentException("Unknown value");
  }

}
