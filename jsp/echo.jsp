<%@taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>MatchMaker Created Profile</title></head>
<body>
Here is the information you submitted:<br/>
<c:out value="First Name: ${profile.firstName}"/><br/>
<c:out value="Last Name: ${profile.lastName}"/><br/>
<c:out value="Email: ${profile.email}"/><br/>
<c:out value="Password: ${profile.password}"/><br/>
<c:out value="Description: ${profile.description}"/><br/>
<c:out value="Interest: ${profile.interests}"/><br/>
<c:out value="Occupation: ${profile.occupation}"/><br/>
<c:out value="Location: ${profile.location}"/><br/>
</body>
</html>