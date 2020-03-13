# frozen_string_literal: true

class AttendeeRefresher
  class << self
    def call
      HTTParty
        .get(url)
        .each do |hash|
          member = hash['member']

          attendee = Attendee.find_or_initialize_by(
            vendor_user_id: member['id']
          )

          attendee.name = member['name']
          attendee.save!
        end

      OpenStruct.new(successful?: true)
    rescue
      OpenStruct.new(successful?: false)
    end

    def url
      return @url if defined?(@url)

      api = ENV['MEETUP_API']
      name = ENV['MEETUP_EVENT_NAME']
      id = ENV['MEETUP_EVENT_ID']

      @url ||= "#{api}/#{name}/events/#{id}/rsvps?&sign=true&photo-host=public&fields=answers"
    end
  end

  private_class_method :url
end
