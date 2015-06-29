 
     function loadimage() {
         document.getElementById("randImage").src = "image.jsp?" + Math.random();
     }
   	var forms;
     var firstName, middleName,lastName,email,title,location, salutation, areaCode,
     	eventDate, eventLink,description, countryCode, phone; 
     function validForm() {
    	 	
    	 	form = document.forms["addNewEvent"];
    	 	
    	    firstName = form["firstName"];
    	    
    	    if (firstName.value == "" || firstName == null) {
    	        alert('Empty First Name');
    	        
    	        return false;
    	        
    	    }
    	    
    	    middleName = form["middleName"];
    	    if (middleName.length >= 100) {
    	        alert('Too Long Middle Name');
    	        return false;
    	        
    	    }

    	    lastName = form["lastName"];
    	    if (lastName.value == "" || lastName == null) {
    	        alert('Empty Last Name');
    	        return false;
    	        
    	    }

    	    email = form["email"];
    	    if (email.value == "" || email == null) {
    	        alert('Empty Email');
    	        return false;
    	       
    	    }

    	    title = form ["title"];
    	    if (title.value == "" || title == null) {
    	        alert('Empty Title');
    	        return false;
    	        
    	    }

    	    location = form["location"];
    	    if (location.value == "" || location == null) {
    	        alert('Empty Event Location');
    	        return false;
    	    }
    	    
    	    eventDate = form ["date"];
    	    if (eventDate.value == "" || eventDate == null) {
    	        alert('Empty Event Date');
    	        return false;
    	    }
			
    	    
    	    
    	    description = form["description"];
    	    if (description.value == "" || description == null) {
    	        alert('Empty Description');
    	        return false;
    	        
    	    }

    	    return true;
     }

 