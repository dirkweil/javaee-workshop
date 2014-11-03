package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter("SpecialDayConverter")
public class SpecialDayConverter implements Converter
{
  @Inject
  SpecialDayRepository specialDayRepository;

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value)
  {
    if (value == null)
    {
      return null;
    }

    System.out.println("CCC: " + this.specialDayRepository);

    return this.specialDayRepository.findById(value);
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value)
  {
    if (value instanceof SpecialDay)
    {
      return ((SpecialDay) value).getId();
    }

    return null;
  }

}
