package de.gedoplan.workshop.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TalkTypeConverter implements AttributeConverter<TalkType, Character>
{

  @Override
  public Character convertToDatabaseColumn(TalkType attribute)
  {
    return attribute.getPersistentForm();
  }

  @Override
  public TalkType convertToEntityAttribute(Character dbData)
  {
    return TalkType.valueOf(dbData);
  }

}
