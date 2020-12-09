<table>
    <tr>
        <td>
            SQL
        </td>
    </tr>
    <%
                Object[] array = bookstore.SQLHistory.getSql();
                for (int i = array.length - 1; i >= 0; i--) {
                    out.print("<tr><td>");
                    out.print(array[i]);
                    out.print("</td></tr>");
                }
    %>
</table>