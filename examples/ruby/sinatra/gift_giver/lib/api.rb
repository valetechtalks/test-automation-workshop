# frozen_string_literal: true

require 'sinatra/base'
require 'sinatra/json'
require 'httparty'

class Api < Sinatra::Base
  before { content_type :json }

  get '/attendees' do
    json Attendee.all
  end

  get '/attendees/awarded' do
    json Attendee.awarded.all
  end

  post '/attendees/draw' do
    attendee = Attendee.random

    if attendee&.award!
      status 201
      json attendee
    else
      server_error
    end
  end

  post '/refresh' do
    if AttendeeRefresher.call.successful?
      status 201
      json text: 'Successfully refreshed attendees.'
    else
      server_error
    end
  end

  private

  def server_error
    status 500
    json message: 'Something went wrong!'
  end
end
