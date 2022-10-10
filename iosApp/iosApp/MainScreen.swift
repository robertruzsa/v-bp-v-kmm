//
//  MainScreen.swift
//  iosApp
//
//  Created by Róbert Rúzsa on 2022. 10. 08..
//  Copyright © 2022. orgName. All rights reserved.
//

import SwiftUI

struct MainScreen: View {
    var body: some View {
        TabView {
                SearchOffersScreen()
                    .tabItem {
                        Image(systemName: "magnifyingglass")
                        Text("Keresés")
                }
                Text("Friends Screen")
                    .tabItem {
                        Image(systemName: "plus")
                        Text("Hirdetés")
                }
            }
    }
}

struct MainScreen_Previews: PreviewProvider {
    static var previews: some View {
        MainScreen()
    }
}
