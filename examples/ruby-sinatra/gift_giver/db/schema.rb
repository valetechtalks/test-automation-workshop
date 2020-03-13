# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 2020_03_11_121042) do

  create_table "attendees", force: :cascade do |t|
    t.string "name", null: false
    t.string "vendor_user_id", null: false
    t.string "rsvp_answer"
    t.boolean "awarded", default: false, null: false
    t.index ["awarded"], name: "index_attendees_on_awarded"
    t.index ["vendor_user_id"], name: "index_attendees_on_vendor_user_id"
  end

end
