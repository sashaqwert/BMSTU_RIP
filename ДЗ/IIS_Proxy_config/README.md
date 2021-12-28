# Настройка HTTP reverse proxy на IIS

1. Установить службы IIS
2. Установить зависимости (см. ниже)
3. Создать сайт в диспетчере служб IIS (не использовать "Default Web Site"!!!)
4. Привязать к сайту валидный SSL сертификат, выданный на тот же домен (субдомен)
5. Скопировать `web.config` в каталог сайта
6. Запустить сервер из ЛР №6 и проверить работоспособность.

# Объяснение ошибок

* 500 - неправильный конфиг
* 502 - прокси-сервер не может связаться с API (время ожидания ответа истекло)
* 404 - сайт с настроенным прокси выключен (ошибку возвращает "Default Web Site") или ошибку вернул API

# Зависимости

IIS URL Rewriting: https://www.iis.net/downloads/microsoft/url-rewrite

Application request routing: https://www.iis.net/downloads/microsoft/application-request-routing
