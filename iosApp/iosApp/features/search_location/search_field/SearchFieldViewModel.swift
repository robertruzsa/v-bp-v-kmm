//
//  SearchFieldObserver.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 10..
//  Copyright © 2022. orgName. All rights reserved.
//

import Foundation
import Combine

class SearchFieldViewModel : ObservableObject {
    @Published var searchText: String = ""
    @Published var debouncedSearchText: String = ""
    private var networkCalls = Set<AnyCancellable>()
    
    public init(dueTime: TimeInterval = 1.0) {
        $searchText
            .removeDuplicates()
            .debounce(for: .seconds(dueTime), scheduler: DispatchQueue.main)
            .sink(receiveValue: { [weak self] value in
                self?.debouncedSearchText = value
            })
            .store(in: &networkCalls)
    }
}
