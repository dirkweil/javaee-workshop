package de.gedoplan.workshop.persistence;

import de.gedoplan.workshop.domain.TalkType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TalkTypeConverter implements AttributeConverter<TalkType, Character>
{

  @Override
  public Character convertToDatabaseColumn(TalkType attribute)
  {
    if (attribute == null)
    {
      return null;
    }

    return attribute.getPersistentForm();
  }

  @Override
  public TalkType convertToEntityAttribute(Character dbData)
  {
    if (dbData == null)
    {
      return null;
    }

    return TalkType.valueOf(dbData);
  }

}
