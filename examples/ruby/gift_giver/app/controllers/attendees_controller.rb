class AttendeesController < ApplicationController 
  def index
    attendees = Attendee.all
    render json: attendees
  end

  def awarded
    attendees = Attendee.awarded
    render json: attendees
  end
end
