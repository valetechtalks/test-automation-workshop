# Gift Giver Ruby Sinatra example

This project was built using Sinatra. Complete documentation can be found on the [Sinatra website](http://sinatrarb.com).

## Dependencies

```
Ruby 2.7.0
SQLite
```

## Installing

Go to example.
```console
$ cd examples/ruby/sinatra/gift_giver
```

Copy the contents of the `.env.example` and `database.yml.example` to `.env` and `database.yml` then change with the credentials of your local environment.

```console
$ cp .env.example .env
$ cp config/database.yml.example config/database.yml
```

Install gems and packages, setup the database and run.
```console
$ bundle install
$ rake db:setup
$ bundle exec shotgun config.ru -p 3000
```

## Test

```console
$ bundle exec rspec
```
