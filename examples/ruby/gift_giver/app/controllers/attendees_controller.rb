class AttendeesController < ApplicationController 
  def index
    attendees = Attendee.all
    render json: attendees
  end
end
