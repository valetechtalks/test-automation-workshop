# frozen_string_literal: true

require 'dotenv/load'
require 'bundler/setup'

APP_ENV = ENV['SINATRA_ENV'] || 'development'

Bundler.require(:default, APP_ENV)

ActiveRecord::Base.establish_connection(
  YAML::load_file('./config/database.yml')[APP_ENV]
)

require_all 'lib'
