Проект для открытых школ t1.
Реализация Security с помощью Spring Boot и JWT токенов. 

Примеры запросов: 

Регистрация: 

localhost:8080/user/registration     (POST)   
{
    "firstName": "Ilya",
    "lastName": "Kaisik",
    "email": "test@mail.com",
    "password": "test"
}



Получение юзера по его почте: 

localhost:8080/user/email/test@mail.com (GET)

Для запроса выше нужен токен


Получение самого токена: 

localhost:8080/auth/sing-in

{
    "email": "test@mail.com",
    "password": "test"
}

В примере выше - используется почта как логин, токен который возвращается действует всего минуту (token)
refreshToken действует 1 день (refreshToken)


