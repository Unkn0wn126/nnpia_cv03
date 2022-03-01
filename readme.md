## Test "login" page

**Request Get "/"**

````http request
GET http://localhost:8080/
````

**Response**

`````html
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Welcome</h1>
<form action="/;jsessionid=DEB9A82F43A4BBA6386DF8C4B255837E" method="post">
    <p>Username: <input type="text" id="name" name="name" value=""/></p>
    <p><input type="submit" value="Submit"/> <input type="reset" value="Reset"/></p>
</form>
</body>
</html>
`````

**Request Post "/"**

`````http request
POST http://localhost:8080/?name=UserName
`````

**Response**

````html
<!DOCTYPE html>
<html>
<head>
    <title>User</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>UserName&#39;s profile</h1>
<div>
    <h2>UserName&#39;s posts</h2>
    <ul>

    </ul>
</div>
<a href="/posts/post">Submit a message</a>
<a href="/posts/">View posts</a>
<a href="/user/">View users</a>
</body>
</html>
````

**Request Get "/user/"**

`````http request
GET http://localhost:8080/user/
`````

**Response**

````html
<!DOCTYPE html>
<html>
<head>
    <title>Posts</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Posts</h1>
<div>
    <h2>All users</h2>
    <ul>

        <li><a href="1"></a></li>

        <li><a href="2">UserName</a></li>

    </ul>
</div>
<a href="/posts/post">Submit message</a>
<a href="/posts/">View posts</a>
<a href="/user/">View users</a>
</body>
</html>
````

**Request Get "/user/{id}"**

`````http request
GET http://localhost:8080/user/2
`````

**Response**

````html
<!DOCTYPE html>
<html>
<head>
    <title>User</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>UserName&#39;s profile</h1>
<div>
    <h2>UserName&#39;s posts</h2>
    <ul>

    </ul>
</div>
<a href="/posts/post">Submit a message</a>
<a href="/posts/">View posts</a>
<a href="/user/">View users</a>
</body>
</html>
````

**Request Post "/posts/post"**

`````http request
POST http://localhost:8080/posts/post?header=Heading;content="Some content"
`````

**Response**

````html
<!DOCTYPE html>
<html>
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Result</h1>
<h2>Heading;content=&quot;Some content&quot;</h2>
<p>content: null</p>
<a href="/posts/post">Submit another message</a>
<a href="/posts/">View posts</a>
<a href="/user/">View users</a>
</body>
</html>
````

**Request Get "/posts/"**

`````http request
GET http://localhost:8080/posts/
`````

**Response**

````html
<!DOCTYPE html>
<html>
<head>
    <title>Posts</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Posts</h1>
<div>
    <h2>All posts</h2>
    <ul>

        <li>Header: Heading;content=&quot;Some content&quot;; Message: null</li>

        <li>Header: Some other heading; Message: Some other message</li>

    </ul>
</div>
<div>
    <h2>Your posts</h2>
    <ul>

        <li>Header: Heading;content=&quot;Some content&quot;; Message: null</li>

    </ul>
</div>
<a href="/posts/post">Submit another message</a>
<a href="/user/">View users</a>
</body>
</html>
````

**Request Get "/posts/post"**

`````http request
GET http://localhost:8080/posts/post
`````

**Response**

````html
<!DOCTYPE html>
<html>
<head>
    <title>Form submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Form</h1>
<form action="/posts/post" method="post">
    <p>Header: <input type="text" id="header" name="header" value=""/></p>
    <p>Message: <input type="text" id="content" name="content" value=""/></p>
    <p><input type="submit" value="Submit"/> <input type="reset" value="Reset"/></p>
</form>
<a href="/posts/">View posts</a>
<a href="/user/">View users</a>
</body>
</html>
````

**Request Get "/posts/user?userid={id}"**

`````http request
GET http://localhost:8080/posts/user?userid=3
`````

**Response**

````html
<!DOCTYPE html>
<html>
<head>
    <title>Posts</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h1>Posts</h1>
<div>
    <h2>All posts</h2>
    <ul>

        <li>Header: Some other heading; Message: Some other message</li>

    </ul>
</div>
<div>
    <h2>Your posts</h2>
    <ul>

        <li>Header: Heading;content=&quot;Some content&quot;; Message: null</li>

    </ul>
</div>
<a href="/posts/post">Submit another message</a>
<a href="/user/">View users</a>
</body>
</html>
````