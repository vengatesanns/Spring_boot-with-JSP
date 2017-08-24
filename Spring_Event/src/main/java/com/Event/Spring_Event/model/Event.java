package com.Event.Spring_Event.model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Event 
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "EVENT_ID")
private int id;
@Column(name = "EVENT_NAME")
private String event_name;
@Column(name = "EVENT_DATE")
private String eDate;
@Column(name = "EVENT_LOCATION")
private String eLocation;
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "EVENT_ID")
private List<Agenda> agenda=new ArrayList<Agenda>();

public int getId() {
return id;
}

public void setId(int id) {
     this.id =id;
}

public String getEvent_name()
{
return event_name;
}

public void setEvent_name(String event_name)
 {
this.event_name = event_name;
}
public String geteDate()
{
return eDate;
}

public void seteDate(String eDate) {
this.eDate = eDate;
}
public String geteLocation() {
return eLocation;
}

public void seteLocation(String eLocation) {
this.eLocation = eLocation;
}

public List<Agenda> getAgenda() {
return agenda;
}

public void setAgenda(List<Agenda> agenda) {
this.agenda = agenda;
}
}