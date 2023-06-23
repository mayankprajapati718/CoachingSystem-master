<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title> Add student Page</title>
</head><link href="webjars\bootstrap\5.1.3\css\bootstrap.min-jsf.css" rel="stylesheet">
<link href="\META-INF\resources\webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.css">
<body><%@include file="common/navigation.jsp" %><div class="container">
<H1><div>Enter Student Details</div></H1>
    <form:form method="post" modelAttribute="ce">
<fieldset class="mb-3">
        <form:label path="username">Name</form:label>
        <form:input type="hidden" path="id"/>
        <form:input type="text" path="username" required="required"/>
    <form:errors path="username" cssClass="text-warning"/>
</fieldset>

        <fieldset class="mb-3">
    <form:label path="courseName">CourseName</form:label>
        <form:input type="text" path="courseName" required="required"/>
    </fieldset>

        <fieldset class="mb-3">
            <form:label path="completionDate">Completion Date</form:label>
        <form:input type="date" path="completionDate" />
        <form:input type="hidden" path="done" />
            <form:errors path="completionDate" cssClass="text-warning"/>
        </fieldset>
        <input type="submit" class="btn btn-success"/>

    </form:form>
</div>
<script src="webjars\jquery\3.6.0\jquery.min.js"></script>
<script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
<script src="\META-INF\resources\webjars\bootstrap-datepicker\1.9.0\js\bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
    $('#completionDate').datepicker({
        format: 'dd/mm/yyyy',
    });
</script>
</body>
</html>