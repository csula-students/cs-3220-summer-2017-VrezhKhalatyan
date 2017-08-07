<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/app.css">
</head>
<body>
    <form method="POST">
        <div>
            <label for="foodName">Name:</label>
            <input id="foodName" type="text" name="foodName">
        </div>
        <div>
            <label for="description">Description:</label>
            <textarea id="description" name="description" cols="30" rows="10"></textarea>
        </div>
        <div>
            <label for="price">Price:</label>
            <input id="price" type="text" name="price">
        </div>
        <button>Post</button>

    </form>
</body>
</html>