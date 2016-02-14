<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Статистика по проданным товарам</title>

        <style type="text/css">
            .header {
                font-family: Georgia, Times New Roman, Times, serif;
            }

            A:link {text-decoration: none} 
            A:visited {text-decoration: none} 
            A:active {text-decoration: none}
            A:hover {text-decoration: underline; color: #993300;}


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
                            <div class ="header">Статистика по проданным товарам!                  </div>
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
                    <div align="center">
                    <table cellpadding="3">
                        <tr>
                            <td align="center">
                                <div>
                                    <c:forEach var="item" items="${requestScope.statistic }">
                                        <h2>
                                            <a href="<c:out value="/Auction/Controller?action=statisticbid&id=${item.getId_Goods()}" />">
                                                <c:out value="${item.name}"/>
                                            </a>
                                        </h2>
                                    </c:forEach>
                                </div>

                            </td>
                        </tr>
                    </table>
                    </div>
                    <!-- Конец таблицы контента -->
                </td>
            </tr>

        </table>
        <!-- Конец основной таблицы -->


    </body>
</html>