package de.gedoplan.workshop.cman.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TalkTypeConverter implements AttributeConverter<TalkType, Character>
{

  @Override
  public Character convertToDatabaseColumn(TalkType attribute)
  {
    return attribute != null ? attribute.getPersistentForm() : null;
  }

  @Override
  public TalkType convertToEntityAttribute(Character dbData)
  {
    return dbData != null ? TalkType.valueOf(dbData) : null;
  }

}
