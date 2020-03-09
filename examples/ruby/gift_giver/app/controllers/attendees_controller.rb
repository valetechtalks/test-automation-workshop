class AttendeesController < ApplicationController 
  def index
    attendees = Attendee.all
    render json: attendees
  end

  def awarded
    attendees = Attendee.awarded.order(updated_at: :desc)
    render json: attendees
  end
end
