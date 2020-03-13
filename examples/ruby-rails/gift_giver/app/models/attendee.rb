class Attendee < ApplicationRecord
  validates :vendor_user_id, presence: true, uniqueness: true
  validates :awarded, inclusion: { in: [ true, false ] }

  scope :awarded, -> { where(awarded: true) }
end
