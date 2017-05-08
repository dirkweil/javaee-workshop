package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Person;
import de.gedoplan.workshop.persistence.PersonRepository;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(forClass = Person.class)
public class PersonConverter implements Converter {

  @Inject
  PersonRepository personRepository;

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null) {
      return null;
    }

    if (this.personRepository == null) {
      this.personRepository = CDI.current().select(PersonRepository.class).get();
    }

    Person person = this.personRepository.findById(Integer.valueOf(value));
    if (person != null) {
      return person;
    }

    throw new ConverterException("id invalid");
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    if (value instanceof Person) {
      return ((Person) value).getId().toString();
    }

    return null;
  }

}
