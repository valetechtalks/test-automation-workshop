class RefreshController < ApplicationController 
  URL = 'https://api.meetup.com/valetechtalks/events/268854460/rsvps?&sign=true&photo-host=public&fields=answers'

  def index
    json = JSON.parse(::HTTParty.get(URL).body)
    rsvps = json.map { |item| item.slice('member', 'answers') }

    rsvps.each do |rsvp|
      rsvp_answer = if rsvp['answers'].present?
        rsvp['answers'].first.try(:[], 'answer')
      else
        nil
      end

      Attendee.create!(
        name: rsvp['member']['name'],
        vendor_user_id: rsvp['member']['id'],
        rsvp_answer: rsvp_answer,
        awarded: false,
      )
    end

    render :ok
  end
end
