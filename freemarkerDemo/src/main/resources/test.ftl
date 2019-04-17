<html>
<head>
    <meta charset="utf-8">
    <title>Freemarker入门小DEMO </title>
</head>
<body>
<#include "head.ftl">
<#--我只是一个注释，我不会有任何输出  -->
${name},你好。${message}

<#assign linkman="abc">
<hr>
people:${linkman}
<hr>
<#if success=true>
 ifififififififif
<#else >
elseelseelse
</#if>
<hr>
<#if aaa??>
    aaa存在
<#else >
    aaa不存在
</#if>
<hr>
${bbb!'bbb不存在'}
<hr>



</body>
</html>
