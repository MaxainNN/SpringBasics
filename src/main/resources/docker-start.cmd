1) Определяем локальный IP-адрес компьютера в сети:
Команда ping -4 -n 1 %ComputerName% пингует текущий компьютер (используя только IPv4)
Результат фильтруется через findstr [ чтобы найти строку с IP-адресом
С помощью for /f извлекается IP-адрес из квадратных скобок в выводе ping
2) Выводим найденный сетевой IP-адрес
3) Устанавливаем переменную окружения DOCKERHOST равной этому IP-адресу
4) Запускаем docker-compose с файлом конфигурации docker-compose.yml
for /f "delims=[] tokens=2" %%a in ('ping -4 -n 1 %ComputerName% ^| findstr [') do set NetworkIP=%%a
echo Network IP: %NetworkIP%
set DOCKERHOST=%NetworkIP%
docker-compose -f docker-compose.yml up