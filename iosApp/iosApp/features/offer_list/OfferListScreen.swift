//
//  OfferListScreen.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 08..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI
import shared

struct OfferListScreen: View {
    
    @ObservedObject var viewModel = OfferListViewModel()
    
    var route: Route? = nil
    
    var body: some View {
        switch viewModel.uiState {
        case .loading:
            Text("Loading...").multilineTextAlignment(.center)
        case .result(let offers):
            List(offers) { offer in
                OfferItem(offer: offer)
            }
            .navigationTitle(route?.getDisplayText(default: "Hirdetések") ?? "")
        case .error(let description):
            Text(description).multilineTextAlignment(.center)
        }
    }
}

struct OfferListScreen_Previews: PreviewProvider {
    static var previews: some View {
        OfferListScreen()
    }
}
