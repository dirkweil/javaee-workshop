package de.gedoplan.workshop.service;

import de.gedoplan.workshop.domain.Talk;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class XyzService
{
  public Talk getRemoteTalk()
  {

    Client client = ClientBuilder.newClient();
    WebTarget target = client.target("http://somehost:7777/app/rest/talk/777");
    Talk talk = target.request(MediaType.APPLICATION_JSON).get(Talk.class);

    return talk;
  }

}
