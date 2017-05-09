<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PandaDar</title>
</head>
<body>
<form id="myInput" action="Servlet" method= "post">
Please input the word: <br/><textarea style="width:1000px;height:500px" name="intext" ></textarea><br/>
   Choose the voice you prefer ： <br/>
   <input type="radio" name ="sex"checked="checked"value="male"/>Male<input type="radio"name ="sex" value="female"/>Female<br/>
   <input type="submit" value="Submit" />
</form>
</body>
</html>