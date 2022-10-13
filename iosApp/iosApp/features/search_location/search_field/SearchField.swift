//
//  SearchField.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 10..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI
import shared

struct SearchField: View {
    
    @StateObject var viewModel = SearchFieldViewModel()
    
    var search: (String) -> Void
    
    @FocusState var isSearchFieldFocused: Bool
    
    var body: some View {
        ZStack {
            Rectangle()
                .foregroundColor(Color(UIColor.secondarySystemBackground))
            HStack {
                Image(systemName: "magnifyingglass")
                TextField("Search ..", text: $viewModel.searchText)
                    .onChange(of: viewModel.debouncedSearchText) { text in
                        search(text)
                    }
                    .focused($isSearchFieldFocused)
                    .onAppear {
                        isSearchFieldFocused = true
                    }
                if (!viewModel.searchText.isEmpty) {
                    Button(
                        action: {
                            viewModel.searchText = ""
                        }
                    ) {
                        Image(systemName: "xmark.circle.fill")
                    }
                }
            }
            .foregroundColor(.gray)
            .padding([.leading, .trailing] , 10)
        }
        .frame(height: 40)
        .cornerRadius(13)
    }
}

struct SearchField_Previews: PreviewProvider {
    static var previews: some View {
        SearchField(search: { _ in })
    }
}
