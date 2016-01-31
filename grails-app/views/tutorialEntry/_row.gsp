<tr>
    <%
        depth = 0
        def runner = page
        while (runner.parentEntry) {
            runner = runner.parentEntry; depth++
        }
    %>
    <td style="padding-left: ${5 + depth * 20}px ">
        <g:link action="show" id="${page.id}">${page.title}</g:link>
    </td>
    <td style="text-align:right;">${page.id}</td>
    <td style="text-align:center;">${page.author}</td>
    <td>
        ${page.text.size() > 40 ? page.text[0..37] + '...' : page.text}
    </td>
    <td>
        <span class=actionButton">
            <g:link action="show" id="${page.id}">Show</g:link>
        </span>
    </td>
</tr>