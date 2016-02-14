/*Регистрация*/
function reg()
{
    var userName = document.getElementById('username').value;
    var secondName = document.getElementById('secondname').value;
    var birthday = document.getElementById('birthday').value;
    var login = document.getElementById('login').value;
    var password = document.getElementById('password').value;
    
  
    
    if (!(/^.{3,25}$/.test(userName))) {
        alert ('Введите имя! Не менее 3 и не более 25 символов');
        return;
    }
    if (!(/^.{3,25}$/.test(secondName))) {
        alert ('Введите фамилию! Не менее 3 и не более 25 символов');
        return;
    }
    
    if (!(/^.{8,10}$/.test(birthday))) {
        alert ('Введите дату рождения в формате DD.MM.YYYY!');
        return;
    }
   
    
    if (!(/^.{3,25}$/.test(login))) {
        alert('Логин должен быть не менее 3 и не более 25 символов!');
        return;
    }
    
    if (!(/^.{6,25}$/.test(password))) {
        alert ('Пароль должен быть не короче 6 символов и не более 25!');
        return;
    } 
}

/*Авторизация*/
function log()
{
    var login=document.getElementById('login').value;
    var password=document.getElementById('password').value;

    if (!(/^.{3,25}$/.test(login))) {
        alert ('Введите логин от 3 до 25 символов');
        return;
    }

    if (!(/^.{6,25}$/.test(password))) {
        alert ('Введите пароль от 6 до 25 символов');
        return;
    }
}
function logadmin()
{
    var login = document.getElementById('loginadmin').value;
    var password = document.getElementById('passwordadmin').value;
   
    if (!(/^.{5,25}$/.test(login))) {
        alert ('Логин должен содержать не менее 5 символов!');
        return;
    }

    if (!(/^.{5,25}$/.test(password))) {
        alert ('Пароль должен содержать не менее 5 символов!');
        return;
    }
}
