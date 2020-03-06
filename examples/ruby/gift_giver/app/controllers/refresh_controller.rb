class RefreshController < ApplicationController 
    URL = 'https://api.meetup.com/valetechtalks/events/268854460/rsvps?&sign=true&photo-host=public&fields=answers'

    def index
        json = JSON.parse(::HTTParty.get(URL).body)
        names = json.map { |item| item['member']['name'] }
        names.each do |name|
            Attendee.create!(
              name: name,
              awarded: false,
              email: "#{name}@example.com"
            )

        end

        render :ok
    end
end