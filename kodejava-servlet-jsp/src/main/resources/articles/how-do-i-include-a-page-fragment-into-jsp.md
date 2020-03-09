# How do I include a page fragment into JSP?

In this example you can learn how to **include a JSP fragment into another JSP page**. This is a common practice when creating a web application where we usually have a navigation section, the main content and the footer of a web page. Using the `include` directive make it simpler to maintain the fragment of a web page, which mean that when we need to change for example the footer section we just need to alter the footer include file and all the page that includes it will get the benefit.

The page inclusion that using the `include` direction will occurs at page translation time, it is when the JSP page is translated into a Servlet by JSP container. We can use any file extension name for the JSP fragment used by the `include` directive. In this example we use the `.jspf` extension which is short for JSP Fragment.

Here is an example of JSP with `include` directive.

```html
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Include Directive</title>
</head>
<body>

<div id="header">
    <%@ include file="/include/common/header.jspf" %>
</div>

<div id="content">
    Main application content goes here!
</div>

<div id="footer">
    <%@ include file="/include/common/footer.jspf" %>
</div>

</body>
</html>
```

```html
Header
<hr/>
```

```html
<hr/>
Footer
```

And here is the page that you will get:

![JSP Include Directive](//kodejava.org/wp-content/uploads/2008/09/jsp-include-directive-example.png "JSP Include Directive")
[![JSP Include Directive][2]][1]

  [1]: https://github.com/kodejava/webapp-example/tree/master/jsp-example
  [2]: https://kodejava.org/wp-content/uploads/2016/02/github.png (JSP Include Directive)
