# Gift giver PHP example
This project was built using Lumen framework. Complete documentation can be found on the [Lumen website](https://lumen.laravel.com/docs).

## Requirements
- PHP version >= 7.2
- [Composer](https://getcomposer.org/)

## Instructions to run
- Clone or download this repository
- Run `composer install`
- Create a env file `cp .env.example .env`
- Create the sqlite database file `touch database/database.sqlite`
- Run the migrations `php artisan migrate`
- Run the project `php -S localhost:8000 -t public`

## Troubleshooting

### Sqlite
- Make sure you have the sqlite extension enabled. You can find it on your `php.ini` file. To enable you just need to uncomment the following lines on your `php.ini` file:
  - `extension=pdo_sqlite.so`
  - `extension=sqlite3.so`
  
- If you don't have the sqlite3 extension installed, you will need to install it. You can find more information about sqlite [here](https://www.php.net/manual/en/sqlite.installation.php)
 
