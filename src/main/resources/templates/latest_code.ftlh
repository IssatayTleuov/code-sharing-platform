<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Code</title>
    <style>
        <#--TODO #3 Move to external css file-->
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
<#list codes as code>
    <span id="load_date" >${code.date}</span>
    <pre id="code_snippet">${code.code}</pre>
</#list>
</body>
</html>