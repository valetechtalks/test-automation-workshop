# frozen_string_literal: true

APP_ENV = ENV['RACK_ENV'] || 'development'

require 'bundler/setup'
require 'dotenv/load' unless APP_ENV == 'production'

Bundler.require(:default, APP_ENV)

ActiveRecord::Base.establish_connection(
  ENV['DATABASE_URL'] || YAML::load_file('./config/database.yml')[APP_ENV]
)

require_all 'lib'
