<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Event</title>
</head>
<body>

<form:form method="POST" commandName="event" action="${pageContext.request.contextPath}/event/add">
    <table>
        <tbody>
        <tr>
            <td>Event Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Date:</td>
            <td><form:input type="date" path="date"/></td>
        </tr>
        <tr>
            <td>Time:</td>
            <td><form:input type="time" path="time"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:input type="text" path="description"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Sign up"></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>


</body>
</html>