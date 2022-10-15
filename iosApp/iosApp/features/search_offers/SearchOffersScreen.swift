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
    
    @State var presentingSearchModal = false
    @State var presentingDatePickerModal = false
    
    var body: some View {
        
        NavigationView {
            VStack {
                VStack {
                    RouteEditor(
                        route: viewModel.route,
                        onStartLocationClick: {
                            self.presentingSearchModal = true
                            viewModel.onStartLocationClicked()
                        },
                        onEndLocationClick: {
                            self.presentingSearchModal = true
                            viewModel.onEndLocationClicked()
                        },
                        onSwitchLocationsClick: {
                            viewModel.switchLocations()
                        }
                    )
                    .padding()
                    .sheet(isPresented: $presentingSearchModal) {
                        SearchLocationScreen(locationInfo: $viewModel.selectedLocation)
                    }
                }
                SelectValueButton(
                    label: "Utazás időpontja",
                    value: viewModel.selectedDate.humanized(),
                    startIconSystemName: "calendar",
                    onClick: {
                        presentingDatePickerModal = true
                    }
                )
                .padding([.leading, .bottom, .trailing])
                .sheet(isPresented: $presentingDatePickerModal) {
                    DatePickerScreen(selectedDate: $viewModel.selectedDate)
                }
                NavigationLink(
                    destination: OfferListScreen(
                        route: viewModel.route,
                        date: viewModel.selectedDate.toKotlinDate()
                    )
                ) {
                    Text("Keresés")
                        .foregroundColor(Color(.white))
                        .padding(.horizontal, 30.0)
                        .padding(.vertical, 15)
                        .background(Color(.systemBlue))
                        .cornerRadius(25)
                }
                Spacer()
            }
            .navigationBarTitle("Keresés")
        }
        
        
    }
}

struct SearchOffersScreen_Previews: PreviewProvider {
    static var previews: some View {
        SearchOffersScreen()
    }
}
