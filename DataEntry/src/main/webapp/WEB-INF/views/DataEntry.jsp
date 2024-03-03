<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VOTE</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
    }

    form {
        max-width: 400px;
        padding: 15px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center; /* Center text content within the form */
    }

    label {
        display: inline-block; /* Make the label inline to center it */
        margin-bottom: 10px; /* Add space between label and input */
    }

    input {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #ff69b4;
        color: #fff;
        cursor: pointer;
        border: none;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #d44693;
    }

    input[type="text"],
    input[type="password"] {
        border: 1px solid #ccc;
        border-radius: 3px;
        padding: 10px;
        box-sizing: border-box;
    }

    font {
        color: red;
    }
</style>


</head>
<body>
    <div>
        <form action="submit">
            <label>Vote</label>
            <br/>
             <input name="hidden" type="hidden" value=<%=request.getAttribute("name")%> placeHolder="name"/>
            <input name="data" type="text" placeHolder="name"/>
            <input type="submit" value="Submit"/>
        </form>
    </div>
</body>
</html>
