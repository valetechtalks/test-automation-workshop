class CreateAttendeesTable < ActiveRecord::Migration[5.2]
  def change
    create_table :attendees do |t|
      t.string :name, unique: true, null: false
      t.string :vendor_user_id, unique: true, index: true, null: false
      t.string :rsvp_answer
      t.boolean :awarded, index: true, null: false, default: false
    end
  end
end
