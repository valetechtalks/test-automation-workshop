# frozen_string_literal: true

class Attendee < ActiveRecord::Base
  validates :name, :vendor_user_id, presence: true, uniqueness: true

  scope :awarded, -> { where(awarded: true) }
  scope :not_awarded, -> { where(awarded: false) }

  def self.random
    not_awarded.limit(1).order('random()').first
  end

  def award!
    update(awarded: true)
  end
end
