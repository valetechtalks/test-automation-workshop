class Attendee < ApplicationRecord
    validates :vendor_user_id, :awarded, presence: true
    validates :vendor_user_id, uniqueness: true
end
