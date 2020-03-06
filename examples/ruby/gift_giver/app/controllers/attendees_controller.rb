class AttendeesController < ApplicationController 
  def index
    attendees = Attendee.all
    render json: attendees
  end

  def draw
    attendee = Attendee.where(awarded: false).sample
    attendee.update(awarded: true)
    render json: attendee
  end
  
end