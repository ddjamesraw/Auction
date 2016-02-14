<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Лот №${requestScope.goodItem.getSerialNumber()}</title>

        <style type="text/css">

            .header {
                color: #993300;
                font: bold 22px Arial,Tahoma,Helvetica,sans-serif;
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
                            <div class ="header">Вы участвуете в розыгрыше ${requestScope.goodItem.getName()}!                  </div>
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
                                                            <font>Текущая стоимость товара</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.auctionlog.getCurrentBid()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                    <tr class="pline">
                                                        <td class="pdinfohead">
                                                            <font>Пользователь</font>
                                                        </td>
                                                        <td class="pdinfohead">
                                                            <font>
                                                                <c:out value="${requestScope.auctionlog.getLastUserAction()}" />
                                                            </font>
                                                        </td>
                                                    </tr>
                                                </table>
                                        </div>

                                       
                                        <table border="0">
                                            <tr>
                                                <td align="center">
                                                    <h1>До конца действия лота осталось:</h1>
                                                </td>
                                                <td align="center">
                                                    <form name="d">
                                                        <p><input type="text" size="8" name="d2"></p>
                                                    </form>
                                                </td>
                                                <td align="center">
                                                    <h1>секунд!</h1>
                                                </td>
                                            </tr>
                                        </table>
                                                            
                                                            
                                        <div>
                                            <center>
                                                <form id="bidbutton"  action="/Auction/Controller" method="post" >
                                                    <input type="hidden" name="action" value="setbid">
                                                    <input type="hidden" name="newbid" value="1">
                                                    <input name="Submit" id="SubmitButton" value="Сделать ставку" type="submit" > 
                                                </form>
                                            </center>
                                        </div> 
                                                            <div align="center" class="header" id="winner" style="visibility: hidden;">
                                                                <h2>
                                                                     Товар выиграл пользователь <c:out value="${requestScope.winner}" />
                                                                </h2>
                                                            </div>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </center>


                                                                <center> <img src="/Auction/images/Auctiongoin.jpg" width="385" height="314" alt="Auctiongoin"/></center>

                    <!-- Конец таблицы контента -->
                </td>
            </tr>

        </table>
        <!-- Конец основной таблицы -->


        <script>
            var milisec = 0
            var reloadTime = 10

            var seconds = <c:out value="${requestScope.goodItem.getTimerBegin()}" />



            document.d.d2.value = '0'

            if (seconds == 0)
                {
                    document.getElementById('SubmitButton').style.visibility = 'hidden' // hide  
                    document.getElementById('winner').style.visibility = 'visible' // hide  
                }

            function display() {
                if (milisec >= 9) {
                    milisec = 0
                    seconds -= 1
                    reloadTime -= 1;
                    if (reloadTime == 0)
                        //location.reload(true)
                        //window.location = self.location;
                        //location.reload( true ); 
                        //document.location.reload(true) 
                        //window.location.reload(true);
                        window.location.href = 'Controller?action=bidaction&id=<c:out value="${requestScope.goodItem.getId_Goods()}" />';
                    if (seconds == 0 || seconds<0) {
                        window.location.href = 'Controller?action=bidaction&id=<c:out value="${requestScope.goodItem.getId_Goods()}" />';
                        return;
                    }


                }
                else
                    milisec += 1
                    //seconds-=1
                if(seconds<0) seconds = 0;
                document.d.d2.value = seconds
                if (seconds > 0)
                    setTimeout("display()", 100)

            }
            display()

        </script>


    </body>
</html>