<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Статистика по товару ${requestScope.goodItem.getName()}</title>

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
                            <div class ="header">Статистика по товару ${requestScope.goodItem.getName()}!                  </div>
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
                    <table cellpadding="3">
                        <tr>
                            <td align="center">

                                <br />
                                <div>
                                    <div>			
                                            <center>
                                                <h1>
                                                    <span><c:out value="${requestScope.goodItem.getName()}" /></span>
                                                </h1>


                                                <table class="pdtable" width="100%" cellspacing="0" cellpadding="0" border="0">
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Описание</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.goodItem.getGoodsDescription()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Рыночная стоимость</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.goodItem.getMarketValue()}" /> у.е.
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Стартовая цена</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.goodItem.getStartBid()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Ставка</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.goodItem.getStep()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                </table>


                                            </center>
                                        </div>        
                                        <br>                 
                                        <div>
                                            <table class="pdtable" width="100%" cellspacing="0" cellpadding="0" border="0">
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Время последней ставки</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.auctionlog.getCurrentTime()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Цена продажи товара</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.auctionlog.getCurrentBid()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Пользователь, купивший товар</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.auctionlog.getLastUserAction()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                </table>
                                        </div>
                                </div>
                            </td>
                        </tr>
                    </table></center>
                      <center> <img src="/Auction/images/auction.jpg" width="300" height="300" alt="auction"/></center>
                    <!-- Конец таблицы контента -->
                </td>
            </tr>

        </table>
        <!-- Конец основной таблицы -->


    </body>
</html>