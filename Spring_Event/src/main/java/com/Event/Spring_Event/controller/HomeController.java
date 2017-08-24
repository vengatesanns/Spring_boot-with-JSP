package com.Event.Spring_Event.controller;

import com.Event.Spring_Event.model.*;
import com.Event.Spring_Event.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class HomeController
{
    @Autowired
    private AgendaRepository ag;
     @Autowired
    private EventRepository env;
   @GetMapping("/")
   public String index(Model model)
   {
    model.addAttribute("eventDetails", new Event());
    //model.addAttribute("list_events",env.findall());
       return "index";
   }

   @GetMapping("/add_agenda")
   public String addAgenda(Agenda agenda)
   {  
           ag.saveAndFlush(agenda);
            return "index";
   }

// ADD Event
@PostMapping("/add_event")

public String addEvents(Event event,@RequestParam("description") String des,
                                             @RequestParam("time") String time,@RequestParam("instruction") String ins,Model model)
{
    if(event.getId()==0)
    {
      Agenda a=new Agenda();
      a.setA_desc(des);
      a.setInstruction(ins);
      a.setTime(time);
      List<Agenda> a1=new ArrayList<Agenda>();
      a1.add(a);
      event.setAgenda(a1);
        env.save(event);
}
    else
    {
        //env.saveAndFlush(event);
    }

    model.addAttribute("event_details",env.findAll());
    return "index";
}

// Delete by ID

@GetMapping("{id}")

public String deleteEvent(@PathVariable Integer id,Model model)
{
    env.delete(id);
   model.addAttribute("event_details",env.findAll());
    return "index";
}

//Show Events
@PostMapping("/show")
public String showEvents(Model m)
{
    m.addAttribute("event_details", env.findAll());
    return "index";
}


@GetMapping("/Edit")
public String updateEvent(Event event,Model m)
{
    m.addAttribute("eid",event.getId());
    m.addAttribute("event_name", event.getEvent_name());
    m.addAttribute("event_location", event.geteLocation());
    m.addAttribute("event_date",event.geteDate());
    m.addAttribute("event_details", env.findAll());
    return "index";
}

}