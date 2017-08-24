<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>
	<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js'></script>
	<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
    <link rel="stylesheet" type="text/css" href="design.css">
</head>

<body>

<header class="well well-sm">
<h2 align="center">Event Details</h2>
</header>
 <div class="col-xs-2"> 
         <form action="add_event" class="Event" method="POST">
         Event_Name : <input type="text"  name="event_name" value=${event_name}><br><br> 
		Event_Location :<input type="text"  name="eLocation" value=${event_location}><br><br> 
    
    	Event_Date : <input type="date"  name="eDate" value=${event_date}><br><br> 
       Agenda_Description : <input type="text"  name="description" ><br><br> 
        Agenda_Instruction : <input type="text"  name="instruction" ><br><br> 
         Agenda_Time : <input type="time"  name="time" ><br><br> 
	 <br>
   <c:set var = "env"  value = "${eventDetails}"/>
    	<c:if test="${!empty env.event_name}">
				<input type="submit" class="btn btn-primary" value="<spring:message text="Edit Events"/>" />
			</c:if>
      	<c:if test="${empty env.event_name}">
				<input type="submit" class="btn btn-primary" value="<spring:message text="Add Events"/>" />
			</c:if>
    <button type="reset" class="btn btn-primary">Clear</button> &nbsp&nbsp <br> <br>
      <form action="show" method="POST">
      	&nbsp&nbsp	<button type="submit" class="btn btn-primary">Show_Events</button> &nbsp&nbsp
      </form>
	</div>
  
  <div class="container">     
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Event ID</th>
        <th>Event Name</th>
        <th>Event Location</th>
        <th>Event Date</th>
      </tr>
    </thead>
    <tbody>
      <tr>
      <c:forEach items="${event_details}" var="event">
       <td>${event.id}</td>
        <td>${event.event_name}</td>
        <td>${event.eLocation}</td>
        <td>${event.eDate}</td>
        <td><a href="Edit?id=${event.id}&event_name=${event.event_name}&eLocation=${event.eLocation}&eDate=${event.eDate}">Edit</a></td>
       <td><a href="${event.id}">Delete</a></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
 </body>
</html>
