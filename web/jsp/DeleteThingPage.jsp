<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Товары</title>

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
                  <div class ="header">Удаление товара!                  </div>
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
                        <a class="button" href="/Auction/Controller?action=addthing">Добавить товар</a>
                                <br>
                        <br> 
                        <a class="button" href="/Auction/Controller?action=updatething">Редактировать товар</a>
                        <br>
                        <br>
                        <a class="button" href="/Auction/Controller?action=deletething">Удалить товар</a>
                        <br>
                        <br>
                        
                        
                                                                
						</font></td>
					</tr>
				</table> <!-- Конец таблицы меню -->
			</td>
			<td valign="top">
				<!-- Начало таблицы контента -->
				<center><table cellpadding="3">
					<tr>
					  <td align="center">
							
							<br />
                                                        <div>
        <form id="DeleteThing"  action="/Auction/Controller" method="post" >
        <div>
        <input type="hidden" name="action" value="deletething">
        
        <center> <strong>Текущий номер лота: </strong><br>
        
        <input id="serial" name="serial"  type="text" value="" maxlength="25" size="25" required><br>
               
        
        
       </center><br>
    </div>
    
    
   <center>
        <input name="Submit" id="Submit" value="Удалить" type="submit"  > </center>
    
    
    
    </form>
                                                        </div>
                            <br />
							
					  </td>
					</tr>
				</table></center>
              
<!-- Конец таблицы контента -->
			</td>
		</tr>
        
	</table>
	<!-- Конец основной таблицы -->


</body>
</html>