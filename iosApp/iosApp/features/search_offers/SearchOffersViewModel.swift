//
//  SearchOffersViewModel.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 09..
//  Copyright © 2022. orgName. All rights reserved.
//

import shared

class SearchOffersViewModel : ObservableObject {
    
    @Published var route: Route = Route(startLocation: Location(name: ""), endLocation: Location(name: ""))
    
    @Published var selectedLocation: LocationInfo = LocationInfo(location: Location(name: ""), type: .start) {
        didSet {
            updateRoute(locationInfo: selectedLocation)
        }
    }
    
    @Published var selectedDate = Date()

    func switchLocations() {
        let startLocation = route.startLocation
        let endLocation = route.endLocation
        route = Route(startLocation: endLocation, endLocation: startLocation)
    }
    
    func onStartLocationClicked() {
        selectedLocation = LocationInfo(location: route.startLocation, type: .start)
    }
    
    func onEndLocationClicked() {
        selectedLocation = LocationInfo(location: route.endLocation, type: .end)
    }
    
    private func updateRoute(locationInfo: LocationInfo) {
        switch locationInfo.type {
        case .start: route = Route(startLocation: locationInfo.location, endLocation: route.endLocation)
        case .end: route = Route(startLocation: route.startLocation, endLocation: locationInfo.location)
        default: {}()
        }
    }
}
