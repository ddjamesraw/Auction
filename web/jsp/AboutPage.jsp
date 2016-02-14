<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>О проекте</title>

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
				<table cellpadding="3">
					<tr>
					  <td align="center">
							
							<br />
                                                        <div> <font size="4">Это аукцион, н котором товар или услуга выставляется на продажу по минимальной стоимости. Участники торгов делают ставки с фиксированным шагом. За каждую ставку с участника взимается определенная плата. Продолжительность торгов задается при старте, однако, после каждой ставки, увеличивается на заданную величину. Победителем считается участник, сделавший последнюю ставку. Стартовая цена лотов по всем товарам всего 10-40% от рыночной стоимости. После каждой ставки цена лота возрастает с фиксированным шагом , а время до окончания изменяется в зависимости от количества сделанных ставок участниками торгов. Победителем аукциона признается участник, сделавший последнюю ставку до момента окончания торгов. В итоге, победителю торгов достается дорогая вещь за смешную цену, а организаторы аукциона получают прибыль, но в основном не за счет продажи этой вещи, а за счет плат за ставки, которые делают все участники аукциона.</font>
                                                                                                                     
                                                          
                                                        </div><br><center> <img src="/Auction/images/161_raskrutka-sajta.jpg" width="350" height="350" alt="161_raskrutka-sajta"/>
                                                        </center><br> <br>
                                                        

                                                        

							
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