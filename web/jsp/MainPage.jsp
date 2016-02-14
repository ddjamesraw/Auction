<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Главная страница</title>

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
                            <div class ="header">Добро пожаловать на наш онлайн-аукцион!                  </div>
                        </center>
                    </h2>
                </td>
            </tr>
            <tr>
                <td  width="18%" valign="top">
                    <!-- Таблица меню -->
                    <table cellpadding="10" >
                        <tr>
                            <td>

                                <!--
                                                                <font face="Arial" size="2"><a class="button"
                                                                                               href="/Auction/Controller?action=main">Главная</a>
                                                                    <br>  <br>
                                                                    <a class="button" href="/Auction/Controller?action=about">О нас</a>
                                                                    <br>
                                                                    <br> 
                                                                    <a class="button" href="/Auction/Controller?action=login">Авторизироваться</a>
                                                                    <br>
                                                                    <br>
                                                                    <a class="button" href="/Auction/Controller?action=register">Зарегистрироваться</a>
                                                                    <br>
                                                                    <br>
                                                                    <a class="button" href="/Auction/Controller?action=loginadmin">Войти как администратор</a>
                                                                    <br> <br>
                                
                                </font>
                                -->
                                <c:out  value="${requestScope.MenuString}"  escapeXml="false"/>                                
                            </td>
                        </tr>
                    </table> <!-- Конец таблицы меню -->
                </td>
                <td valign="top">
                    <!-- Начало таблицы контента -->
                    <table cellpadding="3">
                        <tr>
                            <td align="center">

                                <br />
                                <div><font size="4">На нашем аукционе вы можете приобрести товары по рекордно низкой цене, практически даром. Для того, чтобы стать участником нашего онлайн-аукциона, Вам необходимо всего лишь пройти быструю регистрацию и всё! После этого вы полноценный участник аукциона!</font></div>
                                <br />
                                <center>
                                    <img src="/Auction/images/aulit1.jpg" width="520" height="345" alt="aulit1"/>

                                </center>



                                <!-- Конец таблицы контента -->
                            </td>
                        </tr>

                    </table>
                    <!-- Конец основной таблицы -->


                    </body>
                    </html>