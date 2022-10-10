//
//  SearchLocationScreen.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 08..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI
import shared

struct SearchLocationScreen: View {
    
    @ObservedObject private var viewModel = SearchLocationViewModel()
    
    @Environment(\.presentationMode) var presentationMode
    
    @Binding var locationInfo: LocationInfo
    
    var body: some View {
        NavigationView {
            VStack {
                HStack {
                    Spacer()
                    Button(
                        action: {
                            dismiss()
                        }
                    ) {
                        Text("Close")
                    }.padding([.top, .trailing])
                }
                SearchField(
                    search: { searchText in
                        viewModel.search(query: searchText)
                    }
                ).padding()
                switch viewModel.uiState {
                case .loading:
                    Text("Loading...").multilineTextAlignment(.center)
                case .result(let locations):
                    List(locations) { location in
                        LocationItem(
                            location: location
                        )
                        .onTapGesture {
                            locationInfo = LocationInfo(location: location, type: locationInfo.type)
                            dismiss()
                        }
                    }
                case .error(let description):
                    Text(description).multilineTextAlignment(.center)
                }
                Spacer()
            }
        }
    }
    
    private func dismiss() {
        presentationMode.wrappedValue.dismiss()
    }
}

struct SearchLocationScreen_Previews: PreviewProvider {
    static var previews: some View {
        SearchLocationScreen(locationInfo: .constant(LocationInfo(location: Location(name: "Torda"), type: LocationType.start)))
    }
}
