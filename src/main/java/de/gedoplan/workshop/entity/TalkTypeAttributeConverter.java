package de.gedoplan.workshop.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TalkTypeAttributeConverter implements AttributeConverter<TalkType, String> {

  @Override
  public String convertToDatabaseColumn(TalkType attribute) {
    return attribute != null ? attribute.getPersistentForm() : null;
  }

  @Override
  public TalkType convertToEntityAttribute(String dbData) {
    return dbData != null ? TalkType.fromPersistentForm(dbData) : null;
  }

}
