# How do I include other pages using &lt;jsp:include&gt;?

The `<jsp:include/>` tag is use to include another page fragment of a JSP page into another page. This is useful when you have a common page such as header, footer or a menu that applied to many of all of your pages.

```html
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>&lt;jsp:include/&gt; Demo</title>
</head>
<body>
<div id="header">
    <jsp:include page="common/header.jsp"/>
</div>

<div id="main">
    Lorem ipsum dolor sit amet, consectetur adipisicing elit,
    sed do eiusmod tempor incididunt ut labore et dolore magna
    aliqua.
</div>

<div id="footer">
    <jsp:include page="common/footer.jsp"/>
</div>
</body>
</html>
```

Here are the page fragment of the `header.jsp`, `footer.jsp` and `menu.jsp`. All of them are placed in the common folder in the same location with the `index.jsp` file.

**`header.jsp`**

```html
<strong>&amp;lt;jsp:include/&amp;gt; Demo</strong>
<hr/>
<jsp:include page="menu.jsp"/>
```

**`footer.jsp`**

```html
<hr/>
&amp;copy; 2019 Kode Java Org.
```

**`menu.jsp`**

```html
<a href="/index.jsp">HOME</a>
```

When you access your page (http://localhost:8080/include/main.jsp) from the servlet container such as Apache Tomcat you'll have a complete display of a page that contains header, menu, content and footer.

Here is the directory structure of our example:

```text
.
├── pom.xml
└── src
    └── main
        └── webapp
            ├── WEB-INF
            │   └── web.xml
            ├── include
            │   ├── common
            │   │   ├── footer.jsp
            │   │   ├── header.jsp
            │   │   └── menu.jsp
            │   └── main.jsp
            └── index.jsp
```

The `web.xml` configuration file.

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
