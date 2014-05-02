package de.gedoplan.workshop.cman.presentation;

import de.gedoplan.workshop.cman.entity.SpecialDay;
import de.gedoplan.workshop.cman.persistence.SpecialDayRepository;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.deltaspike.core.api.provider.BeanProvider;

@FacesConverter(forClass = SpecialDay.class)
public class SpecialDayFacesConverter implements Converter
{
  // leider noch nicht in Spec:
  @Inject
  SpecialDayRepository specialDayRepository;

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value)
  {
    if (value == null || value.isEmpty())
    {
      return null;
    }

    // Fall Injektion nicht wirksam, Bean per API holen
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
