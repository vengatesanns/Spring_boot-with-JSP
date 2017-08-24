package com.Event.Spring_Event.model;
import javax.persistence.*;

@Entity
public class Agenda
 {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "AGENDA_TIME")
private String time;
@Column(name = "AGENDA_DESCRIPTION")
private String description;
@Column(name = "AGENDA_INSTRUCTION")
private String instruction;
@ManyToOne
@JoinColumn(name = "EVENT_ID",referencedColumnName="EVENT_ID")
private Event event;

public int getId() 
{
return id;
}

public void setId(int id) 
{
this.id = id;
}

public String getTime() {
return time;
}

public void setTime(String time) {
this.time = time;
}

public String getDescription() 
{
return description;
}

public void setA_desc(String description) 
{
this.description = description;
}

public String getInstruction() 
{
return instruction;
}

public void setInstruction(String instruction) 
{
this.instruction = instruction;
}

public void setEvent(Event event) 
{
this.event = event;
}
public Event getEvent(Event event) 
{
return event;
}
}