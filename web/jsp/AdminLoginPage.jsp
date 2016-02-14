<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/Auction/js/enterCheck.js"></script>
<title>Вход как администратор</title>
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
                  <div class ="header">Вы пытаетесь войти как администратор!                  </div>
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

                                <div align="center"><br> <font size="4"> Для того, чтобы войти как администратор, пожалуйста, пройдите авторизацию!</font> <br> <br>
                                    <center> <img src="/Auction/images/admin.jpg" width="450" height="438" alt="admin"/></center><br><br>
                                        
				 
    <form id="LoginAdmin"  action="/Auction/Controller" method="post" >
    <input type="hidden" name="action" value="loginadmin">
        <div>
    	
        <center> <strong> Логин: </strong><br>
        
        <input id="loginadmin" name="login"  type="text" value="" maxlength="25" size="25" required><br>
        <strong> Пароль: </strong><br>
        <input id="passwordadmin" name="password"  type="password" value="" maxlength="25" size="25" required>
       </center>
    </div>
    <center>
        <input name="Submit" id="Submit" value="Войти" type="submit" onclick="logadmin();"> </center>
        
    </form>
</div> 
<!-- Конец таблицы контента -->
		  </td>
		</tr>
        
	</table>
	<!-- Конец основной таблицы -->


</body>
</html>