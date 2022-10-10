//
//  SearchOffersScreen.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 08..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI
import shared

struct SearchOffersScreen: View {
    
    @ObservedObject private var viewModel = SearchOffersViewModel()
    
    @State var presentingModal = false
    
    var body: some View {
        
        NavigationView {
            VStack {
                VStack {
                    RouteEditor(
                        route: viewModel.route,
                        onStartLocationClick: {
                            self.presentingModal = true
                            viewModel.onStartLocationClicked()
                        },
                        onEndLocationClick: {
                            self.presentingModal = true
                            viewModel.onEndLocationClicked()
                        },
                        onSwitchLocationsClick: {
                            viewModel.switchLocations()
                        }
                    )
                }
                SelectValueButton(
                    label: "Utazás időpontja", value: "Value", startIconSystemName: "calendar", onClick: {}
                ).padding()
                NavigationLink(destination: OfferListScreen()) {
                    Text("Keresés")
                }
                Spacer()
            }
            .navigationBarTitle("Keresés")
            .sheet(isPresented: $presentingModal) {
                SearchLocationScreen(locationInfo: $viewModel.selectedLocation)
            }
        }
        
        
    }
}

struct SearchOffersScreen_Previews: PreviewProvider {
    static var previews: some View {
        EmptyView()
        //SearchOffersScreen()
    }
}
