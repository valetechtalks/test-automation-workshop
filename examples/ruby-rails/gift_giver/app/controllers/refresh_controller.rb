class RefreshController < ApplicationController 
  def index
    response = ::HTTParty.get(ENV['MEETUP_RSVP_URL'])
    json = JSON.parse(response.body)
    rsvps = json.map { |item| item.slice('member', 'answers') }

    rsvps.each do |rsvp|
      rsvp_answer = rsvp['answers'].present? ? rsvp['answers'].first.try(:[], 'answer') : nil

      Attendee
        .create_with(
          name: rsvp['member']['name'],
          rsvp_answer: rsvp_answer,
          awarded: false,
        )
        .find_or_create_by(
          vendor_user_id: rsvp['member']['id'],
        )
    end

    render :ok
  end
end
