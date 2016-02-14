<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Просмотр данных</title>

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
                            <div class ="header">Просмотр данных системы!                  </div>
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
                                <%--
                                <font face="Arial" size="2"><a class="button"
                                            href="/Auction/Controller?action=main">Выйти</a>
            <br>  <br>
    <a class="button" href="/Auction/Controller?action=addadmin">Добавить администатора</a>
            <br>
    <br> 
    <a class="button" href="/Auction/Controller?action=statisticadmin">Посмотреть статистику</a>
    <br>
    <br>
    <a class="button" href="/Auction/Controller?action=admindeal">Работать с товарами</a>
    <br>
    <br>
    <a class="button" href="/Auction/Controller?action=admintariff">Работа с тарифами</a>
    <br> <br>
    <a class="button" href="/Auction/Controller?action=showprofit">Посмотреть прибыль</a>
    <br> <br>
    <a class="button" href="/Auction/Controller?action=adminview">Посмотреть информацию</a>
    <br> <br>
    
                                            
                            </font>--%>
                                <c:out  value="${requestScope.MenuString}"  escapeXml="false"/> 
                            </td>
                        </tr>
                    </table> <!-- Конец таблицы меню -->
                </td>
                <td valign="top">
                    <!-- Начало таблицы контента -->
                    <table cellpadding="3" align="center">
                        <tr>
                            <td align="center">
                                <div>
                                    <form id="viewUsers"  action="/Auction/Controller" method="post" >

                                        <input type="hidden" name="action" value="viewusers">
                                        <center>
                                            <input name="Submit" id="Submit" value="Просмотреть юзеров" type="submit" > </center>

                                    </form>    
                                </div>  
                            </td>
                            <td>
                                <div>
                                    <form id="viewTariffs"  action="/Auction/Controller" method="post" >

                                        <input type="hidden" name="action" value="viewtariffs">
                                        <center>
                                            <input name="Submit" id="Submit" value="Просмотреть тарифы" type="submit" > </center>

                                    </form>    
                                </div>
                            </td>
                            <td>
                                <div>
                                    <form id="viewGoods"  action="/Auction/Controller" method="post" >

                                        <input type="hidden" name="action" value="viewgoods">
                                        <center>
                                            <input name="Submit" id="Submit" value="Просмотреть товары" type="submit" > </center>

                                    </form>    
                                </div>
                            </td>
                        </tr>
                    </table>
                    <table cellpadding="3" align="center">
                        <tr>
                            <td><div>
                                    <c:forEach var="users" items="${requestScope.users}">
<!--                                        <c:out value="${users.getId_User()}" /><br>
                                        <c:out value="${users.getName()}" /><br>
                                        <c:out value="${users.getSecondName()}" /><br>
                                        <c:out value="${users.getBirthday()}" /><br>
                                        <c:out value="${users.getUserLogin()}" /><br>
                                        <c:out value="${users.getUserPassword()}" /><br>
                                        <c:out value="${users.getUserRate()}" /><br>-->
                                        
                                        <table class="pdtable" width="100%" cellspacing="0" cellpadding="0" border="0">
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>ID пользователя</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${users.getId_User()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Имя</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${users.getName()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Фамилия</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${users.getSecondName()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Дата рождения</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${users.getBirthday()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Логин</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                               <c:out value="${users.getUserLogin()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Количество ставок</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                               <c:out value="${users.getUserRate()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <br>
                                    </c:forEach>
                                </div>
                                <div>
                                    <c:forEach var="tariff" items="${requestScope.tariffs}">
                                        
                                        <table class="pdtable" width="100%" cellspacing="0" cellpadding="0" border="0">
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>ID тарифа</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${tariff.getId_Tariff()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Название тарифа</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${tariff.getName()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Количество ставок</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${tariff.getRate()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                </table>
                                                            <br>
                                        
                                    </c:forEach>
                                </div>
                                <div>
                                    <c:forEach var="goods" items="${requestScope.goods}">
<!--                                        <c:out value="${goods.getId_Goods()}" /><br>
                                        <c:out value="${goods.getName()}" /><br>
                                        <c:out value="${goods.getGoodsDescription()}" /><br>
                                        <c:out value="${goods.getSerialNumber()}" /><br>
                                        <c:out value="${goods.getMarketValue()}" /><br>
                                        <c:out value="${goods.getTimerBegin()}" /><br>
                                        <c:out value="${goods.getStartBid()}" /><br>
                                        <c:out value="${goods.getStep()}" /><br>-->
                                        
                                        
                                        <table class="pdtable" width="100%" cellspacing="0" cellpadding="0" border="0">
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>ID товара</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                               <c:out value="${goods.getId_Goods()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Описание</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${goods.getGoodsDescription()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Рыночная стоимость</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${goods.getMarketValue()}" /> у.е.
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Стартовая цена</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${goods.getStartBid()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Ставка</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${goods.getStep()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Серийный номер</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${goods.getSerialNumber()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Время</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${goods.getTimerBegin()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                </table>
                                        <br>
                                        
                                    </c:forEach>
                                </div></td>

                        </tr>
                    </table>
                    <p>&nbsp;</p>

                    <!-- Конец таблицы контента -->
                </td>
            </tr>

        </table>
        <!-- Конец основной таблицы -->


    </body>
</html>