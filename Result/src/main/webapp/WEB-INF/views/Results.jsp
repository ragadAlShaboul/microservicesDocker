<%@ page import="java.util.List" %>
<%@ page import="com.example.Results.webapp.data.model.*" %>
<%@ page import="com.example.Results.webapp.data.entity.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voting Results</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
            text-align: center;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #ffb6c1; /* light pink */
        }

        div {
            margin: 10px;
            font-size: 18px;
            color: #333;
            display: inline-block;
        }

        form {
            margin-top: 20px;
        }

        input[type="submit"] {
            background-color: #ff69b4;
            color: #fff;
            cursor: pointer;
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #d44693;
        }
    </style>
</head>
<body>
        <% ResultsModel resultsModel = (ResultsModel) request.getAttribute("model"); %>
    <div>
        <p>welcome <%=resultsModel.getName()%></p>

        <h1>Voting Results</h1>

        <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Votes</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    List<Electives> top3 = resultsModel.getElectives();
                        for (int i = 0; i < top3.size(); i++) {
                    %>
                        <tr>
                            <td><%=top3.get(i).getName()%></td>
                            <td><%=top3.get(i).getVotes()%></td>
                        </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
        <!-- Navigation -->
        <a href="/">Back to Main Page</a>
    </div>
</body>
</html>
