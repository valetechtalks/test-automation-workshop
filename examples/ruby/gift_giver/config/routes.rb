Rails.application.routes.draw do
  # For details on the DSL available within this file, see https://guides.rubyonrails.org/routing.html
  resources :attendees, only: [:index] do
    collection do
      get :awarded
      post :draw, to: 'draw#index'
    end
  end

  post :refresh, to: 'refresh#index'
end
