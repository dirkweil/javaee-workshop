package de.gedoplan.workshop.webservice;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(RestApplication.APPLICATION_PATH)
public class RestApplication extends Application
{

  public static final String APPLICATION_PATH = "/rs";
}
