//
//  SearchField.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 10..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI

struct SearchField: View {
    
    @StateObject var viewModel = SearchFieldViewModel()
    
    var search: (String) -> Void
    
    var body: some View {
        HStack {
            Image(systemName: "magnifyingglass")
            TextField("Search...", text: $viewModel.searchText)
                .textFieldStyle(.roundedBorder)
                .onChange(of: viewModel.debouncedSearchText) { text in
                    search(text)
                }
            if (!viewModel.searchText.isEmpty) {
                Button(
                    action: {
                        viewModel.searchText = ""
                    }
                ) {
                    Image(systemName: "xmark")
                }
            }
        }
    }
}

struct SearchField_Previews: PreviewProvider {
    static var previews: some View {
        SearchField(search: { _ in })
    }
}
