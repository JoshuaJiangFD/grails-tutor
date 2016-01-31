<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'tutorialEntry.label', default: 'TutorialEntry')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-tutorialEntry" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                    default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-tutorialEntry" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <tr>
            <th>Id</th>
            <th>Author</th>
            <th>Parent Entry</th>
            <th>Text</th>
            <th>Title</th>
            <th></th>
        </tr>
        %{--version 1--}%
        %{--<g:each var="page" in="${tutorialEntryList}">--}%
            %{--<tr>--}%
                %{--<%--}%
                    %{--depth = 0--}%
                    %{--def runner = page--}%
                    %{--while (runner.parentEntry) {--}%
                        %{--runner = runner.parentEntry; depth++--}%
                    %{--}--}%
                %{--%>--}%
                %{--<td style="padding-left: ${5 + depth * 20}px ">--}%
                    %{--<g:link action="show" id="${page.id}">${page.title}</g:link>--}%
                %{--</td>--}%
                %{--<td style="text-align:right;">${page.id}</td>--}%
                %{--<td style="text-align:center;">${page.author}</td>--}%
                %{--<td>--}%
                    %{--${page.text.size() > 40 ? page.text[0..37] + '...' : page.text}--}%
                %{--</td>--}%
                %{--<td>--}%
                    %{--<span class=actionButton">--}%
                        %{--<g:link action="show" id="${page.id}">Show</g:link>--}%
                    %{--</span>--}%
                %{--</td>--}%
            %{--</tr>--}%
        %{--</g:each>--}%
        <g:render  template="row"  var="page" collection="${tutorialEntryList}"/>
    </table>

    <div class="pagination">
        <g:paginate total="${tutorialEntryCount ?: 0}"/>
    </div>
</div>
</body>
</html>