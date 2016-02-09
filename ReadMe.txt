This Application must be deployed on Tomcat 7 and Java 1.6
An simple UI for searching the Texts in the Paragraph is provided in index.jsp  
This can be accessed through the URL http://localhost:8080/SpringSecurityRest/index.jsp 

Both the Task's have been tried to address 

1.  http://host/counter-api/search -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -d’{“searchText”:[“Duis”, “Sed”, “Donec”, “Augue”, “Pellentesque”, “123”]}’ -H" Content-Type: application/json" –X POST
    
	 please use the URL  http://localhost:8080/SpringSecurityRest/counter-api/search  for actual scenario.

2. http://host/counter-api/top/20 -H"Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -
H”Accept: text/csv”

	please use the URL  http://localhost:8080/SpringSecurityRest/counter-api/top/20 


Rest the application war as test over the tomcat 7 is also included as a Zip file 
