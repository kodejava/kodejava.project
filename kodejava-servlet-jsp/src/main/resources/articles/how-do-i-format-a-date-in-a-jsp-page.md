# How do I format a date in a JSP page?

This example show how to format date in JSP using format tag library. We create a `date`  object using the `<jsp:useBean>` taglib. To format the date we use the `<fmt:formatDate>` taglib. We assign the `value` attribute to the `date` object, set the `type` attribute as date and define the `pattern` how the date will be formatted.

```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Date Format</title>
</head>
<body>
<jsp:useBean id="date" class="java.util.Date"/>
Today is: <fmt:formatDate value="${date}" type="date" pattern="dd-MMM-yyyy"/>
</body>
</html>
```

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
