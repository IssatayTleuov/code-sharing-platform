<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Code</title>
    <style>
        <#--TODO #1 Move to external css file-->
        span {
            color: green;
        }

        pre {
            background-color: lightgrey;
            border: 2px solid grey;
            height: 100px;
            width: 500px;
        }

        #load_date {
            font-family: "Courier New", monospace;
        }
    </style>
</head>
<body>
<span id="load_date" >${date}</span>
<pre id="code_snippet">${code}</pre>
</body>
</html>