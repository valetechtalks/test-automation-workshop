20.times do |number| 
    Attendee.create!(
        name: "Fulano #{number}", 
        email: "fulano#{number}@example.com", 
        languages: "javascript,ruby",
        awarded: false
    )
end