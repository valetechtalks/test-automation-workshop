# frozen_string_literal: true

class AttendeeRefresher
  class << self
    def call
      HTTParty
        .get(url)
        .each do |attendee|
          member = attendee['member']

          Attendee.find_or_create_by!(
            name: member['name'],
            vendor_user_id: member['name']
          )
        end

      OpenStruct.new(successful?: true)
    rescue
      OpenStruct.new(successful?: false)
    end

    def url
      name = ENV['MEETUP_EVENT_NAME']
      id = ENV['MEETUP_EVENT_ID']

      "https://api.meetup.com/#{name}/events/#{id}/rsvps?&sign=true&photo-host=public&fields=answers"
    end
  end

  private_class_method :url
end
