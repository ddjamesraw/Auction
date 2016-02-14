<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Главная страница</title>

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
				<table cellpadding="10">
					<tr>
						<td><font face="Arial" size="2"><a
								href="/Auction/Controller?action=main">Вернуться на главную</a>
                                <br>  <br>
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
                                                        <div align="center">
                            
					<center>
						<h2>
                                                    Что-то пошло не так :(
						</h2>
                                            
                                           
                                            <img src="/Auction/images/error.png" width="256" height="256" alt="error"/>

                                            
					</center>
                    
                                        
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