# frozen_string_literal: true

require_relative '../spec_helper'

def app
  Api
end

describe Api do
  it 'responds successfully' do
    get '/attendees'
    expect(last_response.status).to eq(200)
  end
end
