# How do I forward to other page using &lt;jsp:forward&gt;?

The `<jsp:forward/>` tag forward user request to other page. For example, a user request `page1.jsp` and in this page the server found a `<jsp:forward page="page2.jsp"/>`. The server immediately stop the processing of `page1.jsp` and jump to the `page2.jsp`.

Let see an example of using `<jsp:forward/>` tag.

**`page1.jsp`**

```html
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Page 1</title>
</head>
<body>
<strong>This is page 1</strong>

<jsp:forward page="page2.jsp"/>
</body>
</html>
```

**`page2.jsp`**

```html
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Page 2</title>
</head>
<body>
<strong>This is page 2</strong>
</body>
</html>
```

When you try to run the example above by accessing the URL `http://localhost:8080/forward/page1.jsp` you are going to see the content of `page2.jsp` instead of `page1.jsp`. It's happen because on the server side `page1.jsp` forward your request to the `page2.jsp`. But if you look at your browser URL address it will still pointing to `page1.jsp`.

Here is the directory structure of our example:

```text
.
├── pom.xml
└── src
    └── main
        └── webapp
            ├── WEB-INF
            │   └── web.xml
            └── forward
                ├── page1.jsp
                └── page2.jsp
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
