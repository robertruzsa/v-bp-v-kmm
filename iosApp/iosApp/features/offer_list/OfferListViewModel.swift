//
//  OfferListViewModel.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 08..
//  Copyright © 2022. orgName. All rights reserved.
//

import shared

class OfferListViewModel: ObservableObject {
    
    private let rideOfferRepository: RideOfferRepository = RideOfferRepositoryImpl()
    @Published var uiState = UIState<[Offer]>.loading
    
    init() {
        loadRideOffers()
    }
    
    func loadRideOffers() {
        uiState = .loading
        rideOfferRepository.getAllRideOffers() { offers, error in
            if let offers = offers {
                self.uiState = .result(offers)
            } else {
                self.uiState = .error(error?.localizedDescription ?? "error")
            }
        }
    }
}

extension Offer: Identifiable { }
