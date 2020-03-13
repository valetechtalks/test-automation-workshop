class UseMeetupData < ActiveRecord::Migration[6.0]
  def change
    rename_column :attendees, :email, :vendor_user_id
    rename_column :attendees, :languages, :rsvp_answer
  end
end
