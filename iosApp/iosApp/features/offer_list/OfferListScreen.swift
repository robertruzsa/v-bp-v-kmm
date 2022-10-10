//
//  OfferListScreen.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 08..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI

struct OfferListScreen: View {
    
    @ObservedObject var viewModel = OfferListViewModel()
    
    var body: some View {
        NavigationView {
            listView()
                .navigationBarTitle("Hirdetések")
        }
    }
    
    private func listView() -> AnyView {
        switch viewModel.uiState {
        case .loading:
            return AnyView(Text("Loading...").multilineTextAlignment(.center))
        case .result(let offers):
            return AnyView(List(offers) { offer in
                OfferItem(offer: offer)
            })
        case .error(let description):
            return AnyView(Text(description).multilineTextAlignment(.center))
        }
    }
}

struct OfferListScreen_Previews: PreviewProvider {
    static var previews: some View {
        OfferListScreen()
    }
}
