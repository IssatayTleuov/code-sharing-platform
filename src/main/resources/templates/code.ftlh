<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Code</title>
    <style>
        p {
            color: green;
        }

        pre {
            border: 2px black solid;
            background-color: gray;
            height: 100px;
            width: 500px;
        }
    </style>
</head>
<body>
<#list codes as code>
<div>
    <p>${code.date}</p>
    <pre>${code.code}</pre>
</div>
</#list>
</body>
</html>