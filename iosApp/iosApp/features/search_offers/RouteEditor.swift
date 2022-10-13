//
//  RouteEditor.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 09..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI
import shared

struct RouteEditor: View {
    
    var route: Route
    let onStartLocationClick: () -> Void
    let onEndLocationClick: () -> Void
    let onSwitchLocationsClick: () -> Void
    
    var isLocationSelected: Bool {
        let start = route.startLocation.name
        let end = route.endLocation.name
        return !start.isEmpty || !end.isEmpty
    }
    
    var body: some View {
        HStack {
            VStack {
                SelectValueButton(
                    label: "Indulás helye",
                    value: route.startLocation.name,
                    startIconSystemName: "circlebadge",
                    onClick: {
                        onStartLocationClick()
                    }
                )
                .padding(.bottom)
                SelectValueButton(
                    label: "Érkezés helye",
                    value: route.endLocation.name,
                    startIconSystemName: "mappin",
                    onClick: {
                        onEndLocationClick()
                    }
                )
            }
            if (isLocationSelected) {
                Button(
                    action: {
                        onSwitchLocationsClick()
                    }
                ) {
                    Image(systemName: "arrow.up.arrow.down")
                }.padding()
            }
        }
    }
}

struct RouteEditor_Previews: PreviewProvider {
    static var previews: some View {
        RouteEditor(
            route: Route(
                startLocation: Location(name: "Torda"),
                endLocation: Location(name: "Budapest")
            ),
            onStartLocationClick: {},
            onEndLocationClick: {},
            onSwitchLocationsClick: {}
        )
    }
}
