<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>welcome page</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        #container {
            display: flex;
        }

        #left {
            flex: 1;
            background-color: #f0f0f0;
            float: left;
            width: 70%;
            padding: 0;
            margin: 0;
        }

        #left img {
            width: 100%;
            height: 100%;
        }

        #right {
            flex: 1;
            background-color: #fff;
            padding: 20px;
            text-align: center;
            float: left;
            width: 30%;
            text-align: center;
            position: relative;
        }

        #right-title {
            color: orange;
            font-size: 24px;
            margin-bottom: 80px;
            margin-top:130px;
        }

        #right button {
            display: inline-block;
            background-color: orange;
            color: #fff;
            padding: 10px 110px;
            font-size: 16px;
            border: none;
            cursor: pointer;
            margin: 5px;
            margin-top:40px;
        }
        #right button:focus,
		#right button:hover {
   		background-color:black;
    </style>
</head>
<body>

<div id="container">
    <div id="left">
        <img src="img/image.jpg" alt="Your Image" style="max-width: 100%;">
    </div>
    <div id="right">
        <div id="right-title">
            <h1>WELCOME TO THE DREAM CAR!</h1>
        </div>
        <a href="LoginAdmin.jsp"><button>ADMIN</button></a> 
        <a href="ClientSpace.jsp"><button>CLIENT</button></a> 
    </div>
</div>

</body>
</html>
