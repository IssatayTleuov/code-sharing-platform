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
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<span id="load_date" >${date}</span>
<pre id="code_snippet">
    <code>
        ${code}
    </code>
</pre>
</body>
</html>