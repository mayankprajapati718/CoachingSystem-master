<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Coaching Management Page</title>
</head><link href="webjars\bootstrap\5.1.3\css\bootstrap.min-jsf.css" rel="stylesheet">
<body>
<%@include file="common/navigation.jsp" %><div class="container">
<H1><div>Your Coaching Students' List</div></H1><table class="table">
    <thead><tr>
        <th>Id</th>
        <th>Student Name</th>
        <th>Course Name</th>
        <th>Completion Date</th>
        <th>Completed?</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${c}" var="student">
    <tr>
        <th>${student.id}</th><th>${student.username}</th>
        <th>${student.courseName}</th>
        <th>${student.completionDate}</th>
        <th>${student.done}</th>
        <th><a href="delete-student?id=${student.id} " class="btn btn-warning">DELETE</a> </th>
        <th><a href="update-student?id=${student.id} " class="btn btn-success">UPDATE</a> </th>
    </tr>
</c:forEach></tbody></table><a href="add-student" class="btn btn-success">Add-student</a>
</div>
<script src="webjars\jquery\3.6.0\jquery.min.js"></script>
<script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
</body>
</html>