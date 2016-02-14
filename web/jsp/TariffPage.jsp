<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Пополнить счёт</title>

        <style type="text/css">
           .header {
                font-family: Georgia, Times New Roman, Times, serif;
            }



        </style>
     <link href="/Auction/css/header.css" rel="stylesheet" type="text/css">
    </head>
    <body alink="red" link="#0051a4" vlink="#0051a4">
        <div><!-- Основная таблица -->
          <table background="" height="800px" border="1" align="center" width="90%">
            <tr>
              <td colspan="10" 
                    background="" height="79">
                <h2>
                  <center>
                    <div class ="header">Пожалуйста, выберите тариф!                  </div>
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
                  <div align="center">
                <!-- Начало таблицы контента -->
                <table cellpadding="3">
                  <tr>
                    <td align="center">
                      
                      <br />
                      <div>
                        <form id="tariffchoice" action="/Auction/Controller" method="post">
                          <input type="hidden" name="action" value="buytariff"><br>
                          <c:forEach var="tariff" items="${requestScope.tariffname}"><br>
                            Тариф: <c:out value="${tariff.getName()}"/>&nbsp;<input type="radio" name="checktarif" value="<c:out value="${tariff.getRate()}"/>"checked>  Покупая данный тариф вы получаете <c:out value="${tariff.getRate()}"/> ставок на свой счёт <br>
                            
                          </c:forEach>
                          <br />
                          <center>
        <input name="Submit" id="Submit" value="Приобрести" type="submit"> </center>
                        </form>
  </div>
                      </td>
                    </tr>
                  </table>
                  </div>
                <!-- Конец таблицы контента -->
                </td>
              </tr>
            
            </table>
        </div>
        <!-- Конец основной таблицы -->


    </body>
</html>