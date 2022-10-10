//
//  SearchLocationViewModel.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 10..
//  Copyright © 2022. orgName. All rights reserved.
//
import Combine
import Foundation
import shared

class SearchLocationViewModel : ObservableObject {
    
    @Published var isSearchActive: Bool = false
    
    @Published var uiState = UIState<[Location]>.loading
    
    init() {
        search(query: "")
    }
    
    private let locationRepository = SearchLocationRepositoryImpl()
    
    func toogleSearchActive() {
        isSearchActive = !isSearchActive
    }
    
    func search(query: String) {
        uiState = .loading
        locationRepository.search(query: query) { locations, error in
            DispatchQueue.main.async {
                if let locations = locations {
                    self.uiState = .result(locations)
                } else {
                    self.uiState = .error(error?.localizedDescription ?? "error")
                }
            }
        }
    }
}

extension Location: Identifiable { }
