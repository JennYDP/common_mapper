<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"
         language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/carousel/download" method="post" enctype="multipart/form-data">
        <input type="text" name="title">
        <input type="submit" value="submit">

    </form>
</body>
</html>
