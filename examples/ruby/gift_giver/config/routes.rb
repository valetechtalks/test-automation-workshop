Rails.application.routes.draw do
  # For details on the DSL available within this file, see https://guides.rubyonrails.org/routing.html
  get :attendees, to: 'attendees#index'
  get :'attendees/awarded', to: 'attendees#awarded'
  post :'attendees/draw', to: 'draw#index'
  post :refresh, to: 'refresh#index'
end
