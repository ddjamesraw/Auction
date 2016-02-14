<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактирование тарифа</title>

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
                            <div class ="header">Редактирование тарифа!                  </div>
                        </center>
                    </h2>
                </td>
            </tr>
            <tr>
                <td  width="18%" valign="top">
                    <!-- Таблица меню -->
                    <table cellpadding="10">
                        <tr>
                            <td><font face="Arial" size="2"><a class="button"
                                        href="/Auction/Controller?action=adminmain">Назад</a>
                                    <br>  <br>
                                    <a class="button" href="/Auction/Controller?action=addtariff">Добавить тариф</a>
                                    <br>
                                    <br> 
                                    <a class="button" href="/Auction/Controller?action=updatetariff">Редактировать тариф</a>
                                    <br>
                                    <br>
                                    <a class="button" href="/Auction/Controller?action=deletetariff">Удалить тариф</a>
                                    <br>
                                    <br>



                                </font></td>
                        </tr>
                    </table> <!-- Конец таблицы меню -->
                </td>
                <td valign="top">
                    <!-- Начало таблицы контента -->
                    <table cellpadding="3">
                        <tr>
                            <td align="center">

                                <br />
                                <div>
                                    <form id="UpdateTariff"  action="/Auction/Controller" method="post" >
                                        <div>
                                            <input type="hidden" name="action" value="updatetariff">
                                            <strong> Номер тарифа: </strong><br>
                                            <input id="id" name="id"  type="text" value="" maxlength="25" size="25" required><br>
                                            <center> <strong>Название: </strong><br>

                                                <input id="tariffname" name="tariffname"  type="text" value="" maxlength="25" size="25" required><br>
                                                <strong> Количество ставок: </strong><br>
                                                <input id="rate" name="rate"  type="text" value="" maxlength="25" size="25" required><br>

                                            </center><br>
                                        </div>


                                        <center>
                                            <input name="Submit" id="Submit" value="Редактировать" type="submit"  > </center>



                                    </form>
                                </div>
                                <br />

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