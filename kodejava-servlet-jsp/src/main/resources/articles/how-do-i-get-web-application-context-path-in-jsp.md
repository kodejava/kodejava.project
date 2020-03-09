# How do I get web application context path in JSP?

This example show you how to obtain **web application context path** in JSP using _Expression Language_ (EL) feature of JSP. To get the context path we can utilize the `pageContext`, it is an implicit object that available on every JSP pages. From this object you can get access to various object such as:

* `servletContext`
* `session`
* `request`
* `response`

To get the context path value you will need to read it from the `request.contextPath` object. This `contextPath` can be useful for constructing a path to you web resources such as CSS, JavaScript and images. Some libraries that you'll need to enable the JSP Expression Language (EL) in your JSP Pages, which usually already included in a Servlet container such as Apache Tomcat including:

* `javax.servlet-api-3.0.1`
* `javax.servlet.jsp-api-2.3.1`
* `javax.servlet.jsp.jstl-api-1.2.1`

First let's create the `index.jsp` file.

```html
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Context Path</title>
</head>

<body>
Web Application Context Path = ${pageContext.request.contextPath}
</body>
</html>
```

And here is you `web.xml` configuration file:

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

![Web Application Context Path](//kodejava.org/wp-content/uploads/2008/05/webapp-context-path.png "Web Application Context Path")
[![JSP context path example][2]][1]

  [1]: https://github.com/kodejava/webapp-example/tree/master/contextpath-example
  [2]: https://kodejava.org/wp-content/uploads/2016/02/github.png (JSP context path example)
