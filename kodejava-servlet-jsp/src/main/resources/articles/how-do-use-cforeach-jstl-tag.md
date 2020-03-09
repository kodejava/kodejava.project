# How do use &lt;c:forEach&gt; JSTL tag?

The `<c:forEach>` tag in the core JSTL tag library is a useful tag when we want to iterate over a collection of data such as array. It is commonly use to render a tabular data in our web pages in form of HTML table.

In the example below we display a weather data that we stored as two dimensional array of string. After declaring and initializing the data with some value we put it into the request scope. Later on the `<c:forEach>` tag can use the data, iterates it row by row to form an HTML table. Our weather data consist of the date, condition and the high and low temperature.

```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Weather Forecast</title>
</head>
<body>
<%
    String[][] data = {
            {"Nov 6", "Sunny", "32", "26"},
            {"Nov 7", "Sunny", "32", "26"},
            {"Nov 8", "Sunny", "32", "26"},
            {"Nov 9", "Partly Cloudy", "32", "26"},
            {"Nov 10", "Isolated T-Storms", "32", "26"}
    };
    request.setAttribute("weathers", data);
%>
<strong>5-Days Weather for Denpasar, Indonesia</strong>

<table border="1">
    <tr>
        <th>DATE</th>
        <th>CONDITION</th>
        <th>TEMP. HIGH</th>
        <th>TEMP. LOW</th>
    </tr>
    <c:forEach var="weather" items="${weathers}">
        <tr>
            <td>${weather[0]}</td>
            <td>${weather[1]}</td>
            <td align="center">${weather[2]}&#x2103;</td>
            <td align="center">${weather[3]}&#x2103;</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
```

Our JSP page above creates the following output:

**5-Days Weather for Denpasar, Indonesia**

| DATE | CONDITION | TEMP. HIGH | TEMP. LOW |
|---|---|:---:|:---:|
| Nov 6 | Sunny | 32&#x2103; | 26&#x2103; |
| Nov 7 | Sunny | 32&#x2103; | 26&#x2103; |
| Nov 8 | Sunny | 32&#x2103; | 26&#x2103; |
| Nov 9 | Partly Cloudy | 32℃ | 26&#x2103; |
| Nov 10 | Isolated T-Storms | 32&#x2103; | 26&#x2103; |

Here is the `web.xml` configuration file.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app
        xmlns="http://xmlns.jcp.org/xml/ns/javaee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
        version="4.0">

  <!-- Config here. -->

</web-app>
```

**Maven Dependencies**

```xml
<!--https://search.maven.org/remotecontent?filepath=javax/servlet/jstl/1.2/jstl-1.2.jar-->
<dependency>
  <groupId>javax.servlet</groupId>
  <artifactId>jstl</artifactId>
  <version>1.2</version>
</dependency>
```

[![Maven Central](https://img.shields.io/maven-central/v/javax.servlet/jstl.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22javax.servlet%22%20AND%20a:%22jstl%22)
