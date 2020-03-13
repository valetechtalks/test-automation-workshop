class DrawController < ApplicationController 
  def index
    attendee = Attendee.where(awarded: false).sample
    attendee.update(awarded: true)
    render json: attendee
  end
end

