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
    json Attendee.awarded
  end

  post '/attendees/draw' do
    attendee = Attendee.not_awarded.random

    if attendee&.award!
      status 201
      json attendee
    else
      status 422
      json message: 'All attendees were already awarded.'
    end
  end

  post '/refresh' do
    if AttendeeRefresher.call.successful?
      status 201
      json message: 'Successfully refreshed attendees.'
    else
      status 500
      json message: 'Something went wrong!'
    end
  end

  delete '/refresh' do
    Attendee.destroy_all
    json message: 'Successfully deleted all attendees.'
  end
end
