<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Профиль</title>
        <style type="text/css">
            .header {
                font-family: Georgia, Times New Roman, Times, serif;
            }
        </style>
        <link href="/Auction/css/header.css" rel="stylesheet" type="text/css">
    </head>
    <body alink="red" link="#0051a4" vlink="#0051a4">
        <!-- Основная таблица -->
        <table background="" height="800px" border="1" align="center" width="90%">
            <tr>
                <td colspan="10" 
                    background="" height="79">
                    <h2>
                        <center>
                            <div class ="header">Добро пожаловать, ${requestScope.user.getUserLogin()}!</div>
                        </center>
                    </h2>
                </td>
            </tr>
            <tr>
                <td  width="18%" valign="top">
                    <!-- Таблица меню -->
                    <table cellpadding="10">
                        <tr>
                            <td>
                                
                                <c:out  value="${requestScope.MenuString}"  escapeXml="false"/>
                                
                            </td>
                        </tr>
                    </table> <!-- Конец таблицы меню -->
                </td>
                <td valign="top">
                    <!-- Начало таблицы контента -->
                    <center>
                        <table cellpadding="3" width="100%">
                            <tr>
                                <td>
                                    <div align="center">			
                                        <table class="pdtable" width="80%" cellspacing="0" cellpadding="0" border="0">
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Имя</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.user.getName()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Фамилия</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.user.getSecondName()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Дата рождения</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.user.getBirthday()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Количесво ставок</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.user.getUserRate()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                </table>
                                    </div>        
                                    <br>
                        </table>
                </td>
            </tr>
        </table>

        <!-- Конец таблицы контента -->
    </td>
</tr>

</table>
<!-- Конец основной таблицы -->


</body>
</html>