//
//  LocationItem.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 10..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI
import shared

struct LocationItem: View {
    var location: Location
    var body: some View {
        Text(location.displayName)
            .frame(maxWidth: .infinity, alignment: .leading)
            .contentShape(Rectangle())
    }
}

struct LocationItem_Previews: PreviewProvider {
    static var previews: some View {
        LocationItem(location: Location(name: "Torda"))
    }
}
