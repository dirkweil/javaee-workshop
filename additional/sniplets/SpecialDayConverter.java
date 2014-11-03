package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.SpecialDay;
import de.gedoplan.workshop.persistence.SpecialDayRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.provider.BeanProvider;

@FacesConverter(forClass = SpecialDay.class)
public class SpecialDayConverter implements Converter
{
  @Inject
  SpecialDayRepository specialDayRepository;

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value)
  {
    if (value == null || value.isEmpty())
    {
      return null;
    }

    if (this.specialDayRepository == null)
    {
      this.specialDayRepository = BeanProvider.getContextualReference(SpecialDayRepository.class);
    }

    return this.specialDayRepository.findById(value);
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value)
  {
    if (value == null)
    {
      return "";
    }

    return ((SpecialDay) value).getId();
  }

}
